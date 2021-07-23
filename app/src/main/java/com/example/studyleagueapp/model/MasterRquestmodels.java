package com.example.studyleagueapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MasterRquestmodels {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result_array")
    @Expose
    private List<ResultArray> resultArray = null;

    public MasterRquestmodels(String response, Boolean error, String message, List<ResultArray> resultArray) {
        this.response = response;
        this.error = error;
        this.message = message;
        this.resultArray = resultArray;
    }

    public String getResponse() {
        return response;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public List<ResultArray> getResultArray() {
        return resultArray;
    }
}
