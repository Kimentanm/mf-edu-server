package com.mf.bo;

import lombok.Data;

@Data
public class MessageBO {

    private Long id;

    private Long sender;

    private Long receiver;

    private String time;

    private Integer version;

    private Object content;

    private Boolean self;

    private String flag;

    private Object sdp;
}
