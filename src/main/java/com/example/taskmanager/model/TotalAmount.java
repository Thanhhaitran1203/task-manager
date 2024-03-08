package com.example.taskmanager.model;

public class TotalAmount {
    private String getCategoryName;
    private String getTotalAmount;

    public TotalAmount() {
    }

    public TotalAmount(String getCategoryName, String getTotalAmount) {
        this.getCategoryName = getCategoryName;
        this.getTotalAmount = getTotalAmount;
    }

    public String getGetCategoryName() {
        return getCategoryName;
    }

    public void setGetCategoryName(String getCategoryName) {
        this.getCategoryName = getCategoryName;
    }

    public String getGetTotalAmount() {
        return getTotalAmount;
    }

    public void setGetTotalAmount(String getTotalAmount) {
        this.getTotalAmount = getTotalAmount;
    }
}
