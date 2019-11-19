package com.mf.socket;

import com.corundumstudio.socketio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("SocketIO")
public class SocketIO implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 解决地址被占用
     * 每次执行root ApplicationListener 时候都会调用一次onApplicationEvent方法，
     * 这就会使得重复执行onApplicationEvent方法，会导致 地址被占用的（address already in use）
     * @param arg0
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
//        if (arg0.getApplicationContext().getParent() != null) {// root application context 有parent，他就是儿子.
            // 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            new Thread(() -> {
                // TODO Auto-generated method stub
                socketStart();
            }).start();
//        }

    }

    private void socketStart() {
        log.info("in socketio");

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(7777);

        SocketConfig sockConfig = new SocketConfig();
        //地址服用，这时候再启动不报错
        sockConfig.setReuseAddress(true);

        //设置使用的协议和轮询方式
        config.setTransports( Transport.WEBSOCKET, Transport.POLLING);
        //设置允许源
        config.setOrigin(":*:");

        config.setSocketConfig(sockConfig);
        //允许最大帧长度
        config.setMaxFramePayloadLength(1024 * 1024);
        //允许下最大内容
        config.setMaxHttpContentLength(1024 * 1024);
        SocketIOServer server = new SocketIOServer(config);
        server.addConnectListener(client -> {
            // TODO Auto-generated method stub
            String clientInfo = client.getRemoteAddress().toString();
            String clientIp = clientInfo.substring(1, clientInfo.indexOf(":"));// 获取ip
            log.info("建立客户端连接ip"+clientIp);
            client.sendEvent("connected", "ip: " + clientIp);
        });

        server.addDisconnectListener(client -> {
            String clientInfo = client.getRemoteAddress().toString();
            String clientIp = clientInfo.substring(1, clientInfo.indexOf(":"));// 获取ip
            log.info("断开客户端连接ip"+clientIp);
            client.sendEvent("disconned", "ip: " + clientIp);

        });

        server.addEventListener("msginfo", String.class, (client, data, arg2) -> {
            // TODO Auto-generated method stub
            String clientInfo = client.getRemoteAddress().toString();
            String clientIp = clientInfo.substring(1, clientInfo.indexOf(":"));
            log.info(clientIp + "：客户端：************" + data);

            client.sendEvent("msginfo", "服务端返回信息!");
        });

        server.start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        server.stop();
    }
}
