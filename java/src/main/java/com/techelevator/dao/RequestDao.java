package com.techelevator.dao;

import com.techelevator.model.Request;

import java.math.BigDecimal;
import java.util.List;

public interface RequestDao {

    List<Request> findAll();

    Request getRequestById(int requestId);

    boolean create(int serviceId, String dateReported, String estimatedCompletionDate, String status, BigDecimal estimatedCost, String labor, boolean paid);

//    boolean updateEstimatedCost(BigDecimal cost, int requestId, int serviceId);

    List <Request> getRequestByServiceId(int serviceId);
}
