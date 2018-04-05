package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.GeoCoordinate;

public class CarMapper {
	
	 public static CarDO makeCarDO(CarDTO carDTO)
	    {
	        return new CarDO(carDTO.getLicense_plate(), carDTO.getSeat_count(),carDTO.getConvertible(),carDTO.getRating(),carDTO.getEngine_type(),carDTO.getManufacturer(),carDTO.getSelected(),carDTO.getDriverId());
	    }


	    public static CarDTO makeCarDTO(CarDO carDO)
	    {
	        CarDTO.CarDTOBuilder carDTOBuilder =  CarDTO.newBuilder()     		
	            .setId(carDO.getId())
	            .setLicense_plate(carDO.getLicense_plate())
	            .setSeat_count(carDO.getSeat_count())
	            .setConvertible(carDO.getConvertible())
	            .setRating(carDO.getRating())
	            .setEngine_type(carDO.getEngine_type())
	            .setManufacturer(carDO.getManufacturer())
	            .setSelected(carDO.getSelected())
	            .setDriverId(carDO.getDriverId());

	        return carDTOBuilder.createCarDTO();
	    }


	    public static List<CarDTO> makeCarDTOList(Collection<CarDO> drivers)
	    {
	        return drivers.stream()
	            .map(CarMapper::makeCarDTO)
	            .collect(Collectors.toList());
	    }

}
