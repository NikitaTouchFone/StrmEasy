package com.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 15/07/2016.
 */
public class RestError {

    @SerializedName("status")
    boolean success;

    @SerializedName("error")
    private String errorMessage;

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    @SerializedName("registrationType")
    private String registrationType;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @SerializedName("uid")
    private String uid;

    @SerializedName("errors")
    private List<Error> errors = new ArrayList<Error>();

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return ("Error Message: " + errorMessage + ", success: " + success);
    }

    /**
     * @return The errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * @param errors The errors
     */
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
