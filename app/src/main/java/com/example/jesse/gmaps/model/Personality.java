package com.example.jesse.gmaps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Srinjoy on 3/16/2017.
 */

public class Personality {

    public static Personality userPersonality;

    public Personality(){
        userPersonality = this;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("attr_a")
    @Expose
    private String attrA;
    @SerializedName("attr_b")
    @Expose
    private String attrB;
    @SerializedName("attr_c")
    @Expose
    private String attrC;
    @SerializedName("attr_d")
    @Expose
    private String attrD;
    @SerializedName("attr_e")
    @Expose
    private String attrE;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrA() {
        return attrA;
    }

    public void setAttrA(String attrA) {
        this.attrA = attrA;
    }

    public String getAttrB() {
        return attrB;
    }

    public void setAttrB(String attrB) {
        this.attrB = attrB;
    }

    public String getAttrC() {
        return attrC;
    }

    public void setAttrC(String attrC) {
        this.attrC = attrC;
    }

    public String getAttrD() {
        return attrD;
    }

    public void setAttrD(String attrD) {
        this.attrD = attrD;
    }

    public String getAttrE() {
        return attrE;
    }

    public void setAttrE(String attrE) {
        this.attrE = attrE;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}