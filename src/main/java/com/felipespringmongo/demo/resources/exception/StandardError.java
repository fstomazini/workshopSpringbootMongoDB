package com.felipespringmongo.demo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String menssage;
    private String path;

    public StandardError() {
    }

    public StandardError(Long timeStamp, Integer status, String error, String menssage, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.menssage = menssage;
        this.path = path;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
