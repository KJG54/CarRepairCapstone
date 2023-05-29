package com.techelevator.model;

import java.math.BigDecimal;

public class Request {

    private int requestId;
    private String dateReported;
    private String estimatedCompletionDate;
    private String status;
    private BigDecimal estimatedCost;
    private String labor;
    private boolean paid;

    public Request() {}

    public Request(int requestId, String dateReported, String estimatedCompletionDate, String status, BigDecimal estimatedCost, String labor, boolean paid) {
        this.requestId = requestId;
        this.dateReported = dateReported;
        this.estimatedCompletionDate = estimatedCompletionDate;
        this.status = status;
        this.estimatedCost = estimatedCost;
        this.labor = labor;
        this.paid = paid;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public String getEstimatedCompletionDate() {
        return estimatedCompletionDate;
    }

    public void setEstimatedCompletionDate(String estimatedCompletionDate) {
        this.estimatedCompletionDate = estimatedCompletionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", dateReported='" + dateReported + '\'' +
                ", estimatedCompletionDate='" + estimatedCompletionDate + '\'' +
                ", status='" + status + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", labor='" + labor + '\'' +
                ", paid=" + paid +
                '}';
    }
}
