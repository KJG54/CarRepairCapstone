package com.techelevator.pricing;

import com.techelevator.model.RequestServiceDTO;

import java.math.BigDecimal;

public class PricingEngine {

    public BigDecimal calculatePrice(RequestServiceDTO requestServiceDTO) {

        BigDecimal cost = new BigDecimal("0.00");

        String oil = requestServiceDTO.getOil();

        if (oil != null) {
            if (oil.equals("Regular")) {
                cost = cost.add(new BigDecimal("39.99"));
            } else if (oil.equals("Semi Synthetic")){
                cost = cost.add(new BigDecimal("49.99"));
            } else if (oil.equals("Full Synthetic")){
                cost = cost.add(new BigDecimal("99.99"));
            }
        }

        String frontBrakes = requestServiceDTO.getFrontBrakes();
        if (frontBrakes != null){
            if (frontBrakes.equals("Good Year")){
                cost = cost.add(new BigDecimal("209.00"));
            } else if (frontBrakes.equals("Power Shop")){
                cost = cost.add(new BigDecimal("179.00"));
            } else if (frontBrakes.equals("Firestone")){
                cost = cost.add(new BigDecimal("149.00"));
            }
        }
        String backBrakes = requestServiceDTO.getBackBrakes();
        if (backBrakes != null){
            if (backBrakes.equals("Good Year")){
                cost = cost.add(new BigDecimal("209.00"));
            } else if (backBrakes.equals("Power Shop")){
                cost = cost.add(new BigDecimal("179.00"));
            } else if (backBrakes.equals("Firestone")){
                cost = cost.add(new BigDecimal("149.00"));
            }
        }
        String tires = requestServiceDTO.getTires();
        if (tires != null){
            if (tires.equals("x1 Firestone")){
                cost = cost.add(new BigDecimal("129.00"));
            } else if (tires.equals("x2 Firestone")){
                cost = cost.add(new BigDecimal("258.00"));
            } else if (tires.equals("x3 Firestone")){
                cost = cost.add(new BigDecimal("387.00"));
            } else if (tires.equals("x4 Firestone")){
                cost = cost.add(new BigDecimal("516.00"));
            } else if (tires.equals("x1 Bridgestone")){
                cost = cost.add(new BigDecimal("159.00"));
            } else if (tires.equals("x2 Bridgestone")){
                cost = cost.add(new BigDecimal("318.00"));
            } else if (tires.equals("x3 Bridgestone")){
                cost = cost.add(new BigDecimal("477.00"));
            } else if (tires.equals("x4 Bridgestone")){
                cost = cost.add(new BigDecimal("636.00"));
            } else if (tires.equals("x1 WeatherGuard")){
                cost = cost.add(new BigDecimal("179.00"));
            } else if (tires.equals("x2 WeatherGuard")){
                cost = cost.add(new BigDecimal("358.00"));
            } else if (tires.equals("x3 WeatherGuard")){
                cost = cost.add(new BigDecimal("537.00"));
            } else if (tires.equals("x4 WeatherGuard")){
                cost = cost.add(new BigDecimal("716.00"));
            }
        }

        return cost;

    }
}
