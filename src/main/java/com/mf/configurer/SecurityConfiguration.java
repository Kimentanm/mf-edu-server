package com.mf.configurer;

import com.mf.security.Http401UnauthorizedEntryPoint;
import com.mf.security.UserDetailsService;
import com.mf.security.jwt.JWTConfigurer;
import com.mf.security.jwt.TokenProvider;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private final UserDetailsService userDetailsService;

    private final TokenProvider tokenProvider;

//    private final CorsFilter corsFilter;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
                                 UserDetailsService userDetailsService,
                                 TokenProvider tokenProvider) {

        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
//        this.corsFilter = corsFilter;
    }

    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Bean
    public Http401UnauthorizedEntryPoint http401UnauthorizedEntryPoint() {
        return new Http401UnauthorizedEntryPoint();
    }

    /**
     * 装载BCrypt密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger")
            .antMatchers("/test/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //登录页面用户任意访问
//                .formLogin().loginPage("/authenticate").permitAll()
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()

//                .logout().permitAll() //注销行为任意访问
//        .and()
            .exceptionHandling()
            .authenticationEntryPoint(http401UnauthorizedEntryPoint())
        .and()
//        取消csrf
            .csrf().disable()
            .headers()
            .frameOptions()
            .disable()
        .and()
                // 基于token，所以不需要session
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .apply(securityConfigurerAdapter());

    }

    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}
