package com.techelevator.controller;


import com.techelevator.dao.CarDao;
import com.techelevator.dao.RequestDao;
import com.techelevator.dao.ServiceDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import com.techelevator.pricing.PricingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class RequestController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private RequestDao requestDao;

    @RequestMapping(path = "userData", method = RequestMethod.GET)
    public UserData getUserData(){
        UserData data = new UserData();

        return data;
    }

    @RequestMapping(path = "/services", method = RequestMethod.POST)
    public void createRequest(@RequestBody RequestServiceDTO request, Principal principal) {


        PricingEngine pricingEngine = new PricingEngine();
        BigDecimal price = pricingEngine.calculatePrice(request);
        request.setEstimatedCost(price);


        int userId = userDao.findIdByUsername(principal.getName());
        Car car = new Car(request.getCarId(), request.getMake(), request.getModel(),
                request.getColor(), request.getYear());
        if (car.getCarId() == 0) {

            car.setCarId(carDao.create(userId, car.getMake(), car.getModel(), car.getColor(), car.getYear()));

        }
        Service service = new Service(request.getServiceId(), request.getOil(), request.getFrontBrakes(), request.getBackBrakes(), request.getTires(),
                request.getBody(), request.getCarbonAirFilter(), request.getBattery(),
                request.getScheduledMaintenance(), request.getMisc());
        if (service.getServiceId() == 0) {
            service.setServiceId(serviceDao.create(car.getCarId(), request.getOil(), request.getFrontBrakes(), request.getBackBrakes(), request.getTires(),
                    request.getBody(), request.getCarbonAirFilter(), request.getBattery(),
                    request.getScheduledMaintenance(), request.getMisc()));
        }

        requestDao.create(service.getServiceId(), LocalDate.now().toString(), request.getEstimatedCompletionDate(), request.getStatus(), request.getEstimatedCost(), request.getLabor(), request.isPaid());


    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public GetAllDto getAllDto() {
        GetAllDto getAll = new GetAllDto();
        List<User> users = userDao.listUsers();
        List<Car> cars = carDao.findAll();
        List<Service> services = serviceDao.findAll();
        List<Request> requests = requestDao.findAll();
        getAll.setUsers(users);
        getAll.setCars(cars);
        getAll.setServices(services);
        getAll.setRequests(requests);
        return getAll;
    }

    @RequestMapping(path = "/services/{id}", method = RequestMethod.GET)
    public GetServiceDTO getRequestService(@PathVariable int id) {
        GetServiceDTO getServiceDTO = new GetServiceDTO();
        Service service = serviceDao.getServiceById(id);
        List<Request> request = requestDao.getRequestByServiceId(id);
        getServiceDTO.setService(service);
        getServiceDTO.setRequests(request);
        return getServiceDTO;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public List<Car> getCarsByUser(@PathVariable int id) {
        List<Car> cars = carDao.getCarByUserId(id);
        return cars;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userDao.listUsers();
    }
//
//    @RequestMapping(path="/services", method=RequestMethod.PUT)
//    public void updateEstimatedCost(@RequestBody RequestServiceDTO requestServiceDTO){
//        Service service = new Service(requestServiceDTO.getServiceId(),requestServiceDTO.getOil(),
//                requestServiceDTO.getFrontBrakes(),requestServiceDTO.getBackBrakes(),requestServiceDTO.getTires(),
//                requestServiceDTO.getBody(),requestServiceDTO.getCarbonAirFilter(),requestServiceDTO.getBattery(),
//                requestServiceDTO.getScheduledMaintenance(),requestServiceDTO.getMisc());
//        Request request = new Request(requestServiceDTO.getRequestId(),requestServiceDTO.getDateReported(),
//                requestServiceDTO.getEstimatedCompletionDate(),requestServiceDTO.getStatus(),requestServiceDTO.getEstimatedCost(),
//                requestServiceDTO.getLabor(),requestServiceDTO.isPaid());
//        BigDecimal cost = new BigDecimal("0.00");
//        String oil = service.getOil();
//        if (oil != null) {
//            if (oil.equals("Regular")) {
//                cost = cost.add(new BigDecimal("39.99"));
//            } else if (oil.equals("Semi Synthetic")){
//                cost = cost.add(new BigDecimal("49.99"));
//            } else if (oil.equals("Full Synthetic")){
//                cost = cost.add(new BigDecimal("99.99"));
//            }
//        }
//        String frontBrakes = service.getFrontBrakes();
//        if (frontBrakes != null){
//            if (frontBrakes.equals("Good Year")){
//                cost = cost.add(new BigDecimal("209.00"));
//            } else if (frontBrakes.equals("Power Shop")){
//                cost = cost.add(new BigDecimal("179.00"));
//            } else if (frontBrakes.equals("Firestone")){
//                cost = cost.add(new BigDecimal("149.00"));
//            }
//        }
//        String backBrakes = service.getBackBrakes();
//        if (backBrakes != null){
//            if (backBrakes.equals("Good Year")){
//                cost = cost.add(new BigDecimal("209.00"));
//            } else if (backBrakes.equals("Power Shop")){
//                cost = cost.add(new BigDecimal("179.00"));
//            } else if (backBrakes.equals("Firestone")){
//                cost = cost.add(new BigDecimal("149.00"));
//            }
//        }
//        String tires = service.getTires();
//        if (tires != null){
//            if (tires.equals("x1 Firestone")){
//                cost = cost.add(new BigDecimal("129.00"));
//            } else if (tires.equals("x2 Firestone")){
//                cost = cost.add(new BigDecimal("258.00"));
//            } else if (tires.equals("3x Firestone")){
//                cost = cost.add(new BigDecimal("387.00"));
//            } else if (tires.equals("x4 Firestone")){
//                cost = cost.add(new BigDecimal("516.00"));
//            } else if (tires.equals("x1 Bridgestone")){
//                cost = cost.add(new BigDecimal("159.00"));
//            } else if (tires.equals("2x Bridgestone")){
//                cost = cost.add(new BigDecimal("318.00"));
//            } else if (tires.equals("3x Bridgestone")){
//                cost = cost.add(new BigDecimal("477.00"));
//            } else if (tires.equals("4x Bridgestone")){
//                cost = cost.add(new BigDecimal("636.00"));
//            } else if (tires.equals("1x WeatherGuard")){
//                cost = cost.add(new BigDecimal("179.00"));
//            } else if (tires.equals("2x WeatherGuard")){
//                cost = cost.add(new BigDecimal("358.00"));
//            } else if (tires.equals("x3 WeatherGuard")){
//                cost = cost.add(new BigDecimal("537.00"));
//            } else if (tires.equals("4x WeatherGuard")){
//                cost = cost.add(new BigDecimal("716.00"));
//            }
//        }
//        String body = service.getBody();
//
//        String carbonAirFilter = service.getCarbonAirFilter();
//        if (carbonAirFilter != null){
//            if (carbonAirFilter.equals("Good Year")){
//                cost = cost.add(new BigDecimal("59.99"));
//            } else if (carbonAirFilter.equals("Firestone")){
//                cost = cost.add(new BigDecimal("79.99"));
//            }
//        }
//        String battery = service.getBattery();
//        if (battery != null){
//            if (battery.equals("Sedan")){
//                cost = cost.add(new BigDecimal("149.00"));
//            } else if (battery.equals("SUV")){
//                cost = cost.add(new BigDecimal("199.00"));
//            } else if (battery.equals("Truck")){
//                cost = cost.add(new BigDecimal("289.00"));
//            }
//        }
//        String scheduledMaintenance = service.getScheduledMaintenance();
//        if (scheduledMaintenance != null){
//            if (scheduledMaintenance.equals("6,000 Miles")){
//                cost = cost.add(new BigDecimal("299.99"));
//            } else if (scheduledMaintenance.equals("12,000 Miles")){
//                cost = cost.add(new BigDecimal("499.99"));
//            } else if (scheduledMaintenance.equals("2 Year")){
//                cost = cost.add(new BigDecimal("399.00"));
//            }
//        }
//        String labor = request.getLabor();
//        if (labor != null){
//            if (labor.equals("Basic Labor")){
//                cost = cost.add(new BigDecimal("99.00"));
//            } else if (labor.equals("Half Day Labor")){
//                cost = cost.add(new BigDecimal("199.00"));
//            } else if (labor.equals("Full Day Labor")){
//                cost = cost.add(new BigDecimal("299.00"));
//            }
//        }
//        request.setEstimatedCost(cost);
//    }


}
