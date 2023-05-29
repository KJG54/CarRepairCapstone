package com.techelevator.model;

import java.util.List;

public class GetServiceDTO {

    private Service service;
    private List<Request> requests;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
