package com.techelevator.dao;

import com.techelevator.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    Car getCarById(int carId);

    List<Car> getCarByUserId(int userId);

    int create(int userId, String make, String model, String color, String year);
}
