package com.techelevator.model;

public class Service {

    private int serviceId;
    private String oil;
    private String frontBrakes;
    private String backBrakes;
    private String tires;
    private String body;
    private String carbonAirFilter;
    private String battery;
    private String scheduledMaintenance;
    private String misc;

    public Service() {}

    public Service(int serviceId, String oil, String frontBrakes, String backBrakes, String tires, String body, String carbonAirFilter, String battery, String scheduledMaintenance, String misc) {
        this.serviceId = serviceId;
        this.oil = oil;
        this.frontBrakes = frontBrakes;
        this.backBrakes = backBrakes;
        this.tires = tires;
        this.body = body;
        this.carbonAirFilter = carbonAirFilter;
        this.battery = battery;
        this.scheduledMaintenance = scheduledMaintenance;
        this.misc = misc;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(String frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public String getBackBrakes() {
        return backBrakes;
    }

    public void setBackBrakes(String backBrakes) {
        this.backBrakes = backBrakes;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCarbonAirFilter() {
        return carbonAirFilter;
    }

    public void setCarbonAirFilter(String carbonAirFilter) {
        this.carbonAirFilter = carbonAirFilter;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getScheduledMaintenance() {
        return scheduledMaintenance;
    }

    public void setScheduledMaintenance(String scheduledMaintenance) {
        this.scheduledMaintenance = scheduledMaintenance;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }


    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", oil='" + oil + '\'' +
                ", frontBrakes='" + frontBrakes + '\'' +
                ", backBrakes='" + backBrakes + '\'' +
                ", tires='" + tires + '\'' +
                ", body='" + body + '\'' +
                ", carbonAirFilter='" + carbonAirFilter + '\'' +
                ", battery='" + battery + '\'' +
                ", scheduledMaintenance='" + scheduledMaintenance + '\'' +
                ", misc='" + misc + '\'' +
                '}';
    }
}
