package com.mytaxi.service.driver;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

@Service
public class DefaultCarService implements CarService{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final CarRepository carRepository;


    public DefaultCarService(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }


    /**
     * Selects a car by id.
     *
     * @param carId
     * @return found car
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    public CarDO find(Long carId) throws EntityNotFoundException
    {
        return findCarChecked(carId);
    }
    
    

    /**
     * Selects a car by id.
     *
     * @param carId
     * @return found car
     * @throws CarAlreadyInUseException if no car with the given id was found.
     * @throws EntityNotFoundException 
     */
    @Override
    public CarDO checkAvailable(Long carId,Long driverId) throws CarAlreadyInUseException
    {
        return checkCarAvailable(carId,driverId);
    }

    /**
     * Updates car for driver ID.
     *
     * @param carId,driverId
     * @return found car

     */
  //  @Override
   // public CarDO updatedCar(Long carId,Long driverId)
   // {
        //return updatedCarForDriver(carId,driverId);
  //  }
    

    /**
     * Creates a new car.
     *
     * @param carDO
     * @return
     * @throws ConstraintsViolationException if a car already exists with the given id, ... .
     */
    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException
    {
        CarDO car;
        try
        {
        	car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to car creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }


    /**
     * Deletes an existing car by id.
     *
     * @param carId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long carId) throws EntityNotFoundException
    {
        CarDO carDO = findCarChecked(carId);
        carDO.setDeleted(true);
    }


    /**
     * Update the location for a car.
     *
     * @param carId
     * @param rating
     * @param engine_type
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateCar(long carId,double rating,String engine_type) throws EntityNotFoundException
    {
        CarDO carDO = findCarChecked(carId);
        carDO.setRating(rating);
        carDO.setEngine_type(engine_type);
    }



    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
 /*   @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return carRepository.findByOnlineStatus(onlineStatus);
    }*/


    private CarDO findCarChecked(Long carId) throws EntityNotFoundException
    {
        CarDO carDO = carRepository.findOne(carId);
        if (carDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + carId);
        }
        return carDO;
    }
    
    
    private CarDO checkCarAvailable(Long carId,Long driverId) throws CarAlreadyInUseException
    {
        CarDO carDO = carRepository.findCarAvailable(carId);
        if (carDO == null)
        {
            throw new CarAlreadyInUseException("Car not available with id: " + carId);
        }
        else
        {
        	carRepository.updatedCarForDriver(carId,driverId);
        }
        return carDO;
    }
    
  //  private CarDO  updatedCarForDriver(Long carId,Long driverId)
  // {
       // CarDO carDO = carRepository.updatedCarForDriver(carId,driverId);

   // }

}
