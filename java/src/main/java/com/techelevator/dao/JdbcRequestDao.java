package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        String sql = "select * from requests";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Request request = mapRowToRequest(results);
            requests.add(request);
        }
        return requests;
    }

    @Override
    public Request getRequestById(int requestId) {
        String sql = "select * from requests where request_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestId);
        if (results.next()){
            return mapRowToRequest(results);
        } else {
            return null;
        }
    }

    @Override
    public List <Request> getRequestByServiceId(int serviceId) {
        List <Request> requests = new ArrayList<>();
        String sql = "select * from requests where service_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serviceId);
        while (results.next()){
            requests.add(mapRowToRequest(results));
        }
        return requests;
    }

    @Override
    public boolean create(int serviceId, String dateReported, String estimatedCompletionDate, String status, BigDecimal estimatedCost, String labor, boolean paid) {
        String sql = "insert into requests (service_id,date_reported,estimated_completion_date,status,estimated_cost,labor,paid) values (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, serviceId, dateReported, estimatedCompletionDate, status, estimatedCost, labor, paid) == 1;
    }

//    @Override
//    public boolean updateEstimatedCost(int serviceId){
//        String sql = "select * from requests r " +
//                "join service s on r.service_id = s.service_id " +
//                "where s.service_id = ?";
//
//        return jdbcTemplate.update(sql, cost, requestId, serviceId) == 1;
//
//    }

    private Request mapRowToRequest(SqlRowSet results){
        Request request = new Request();
        request.setRequestId(results.getInt("request_id"));
        request.setDateReported(results.getString("date_reported"));
        request.setEstimatedCompletionDate(results.getString("estimated_completion_date"));
        request.setStatus(results.getString("status"));
        request.setEstimatedCost(results.getBigDecimal("estimated_cost"));
        request.setLabor(results.getString("labor"));
        request.setPaid(results.getBoolean("paid"));
        return request;
    }
}
