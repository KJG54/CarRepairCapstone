package com.techelevator.dao;

import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDao {

    List<Service> findAll();

    Service getServiceById(int serviceId);

    int create(int carId, String oil, String frontBrakes, String backBrakes, String tires, String body, String carbonAirFilter, String battery, String scheduledMaintenance, String misc);
}
