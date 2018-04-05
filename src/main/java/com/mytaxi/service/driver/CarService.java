package com.mytaxi.service.driver;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService {

    CarDO find(Long carId) throws EntityNotFoundException;
    
    CarDO checkAvailable(Long carId,Long driverId) throws CarAlreadyInUseException;
    
    //CarDO updatedCar(Long carId,Long driverId);

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(Long carId) throws EntityNotFoundException;

    void updateCar(long carId,double rating,String engine_type) throws EntityNotFoundException;
}
