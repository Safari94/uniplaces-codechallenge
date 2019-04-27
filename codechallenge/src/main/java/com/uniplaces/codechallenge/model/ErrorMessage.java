package com.uniplaces.codechallenge.model;

import java.io.Serializable;
import java.util.Date;

public class ErrorMessage implements Serializable {

    private Date timestamp;

    private String errorMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timestamp, String errorMessage) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
