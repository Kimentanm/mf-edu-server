package com.mf.dto;

import java.io.Serializable;

public class FileResultDTO implements Serializable {


    private String location;

    private String hash;


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
