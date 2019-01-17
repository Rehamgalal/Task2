package com.example.reham.task2.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by reham on 1/16/2019.
 */

public class Country {
    @SerializedName("Id")
    private int Id;
    @SerializedName("TitleEN")
    private String titleEn;
    @SerializedName("TitleAR")
    private String titleAr;
    @SerializedName("CurrencyId")
    private int currencyId;
    @SerializedName("CurrencyEN")
    private String currencyEn;
    @SerializedName("CurrencyAR")
    private String currencyAr;
    @SerializedName("codeEN")
    private String codeEn;
    @SerializedName("codeAR")
    private String codeAr;
    @SerializedName("Code")
    private int Code;

    public Country(int Id, String titleEn, String titleAr, int currencyId, String currencyEn, String currencyAr, String codeEn, String codeAr, int code) {
        this.Id = Id;
        this.titleEn = titleEn;
        this.titleAr = titleAr;
        this.currencyId = currencyId;
        this.currencyEn = currencyEn;
        this.currencyAr = currencyAr;
        this.codeEn = codeEn;
        this.codeAr = codeAr;
        this.Code = code;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleAr() {
        return titleAr;
    }

    public void setTitleAr(String titleAr) {
        this.titleAr = titleAr;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyEn() {
        return currencyEn;
    }

    public void setCurrencyEn(String currencyEn) {
        this.currencyEn = currencyEn;
    }

    public String getCurrencyAr() {
        return currencyAr;
    }

    public void setCurrencyAr(String currencyAr) {
        this.currencyAr = currencyAr;
    }

    public String getCodeEn() {
        return codeEn;
    }

    public void setCodeEn(String codeEn) {
        this.codeEn = codeEn;
    }

    public String getCodeAr() {
        return codeAr;
    }

    public void setCodeAr(String codeAr) {
        this.codeAr = codeAr;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}
