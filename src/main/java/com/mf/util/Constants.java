package com.mf.util;

public interface Constants {

    interface objectType{
        String product = "product";
        String expert = "expert";
    }

    interface status{
        String active = "A";
        String inactive = "I";
    }

    /**
     * 用户类型
     */
    interface UserType {
        /**
         * 平台运营人员
          */
        String ADMIN = "1";
    }

    interface NewsStatus {
        Integer RELEASED = 1;
        Integer UNRELEASE = 0;
    }
}
