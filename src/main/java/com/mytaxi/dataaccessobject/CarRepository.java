package com.mytaxi.dataaccessobject;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.domainobject.CarDO;

public interface CarRepository extends CrudRepository<CarDO, Long>{

	 @Query("FROM CarDO c WHERE c.id = :id and c.selected='NO'")
     public CarDO findCarAvailable(@Param("id") Long carId);

	 @Transactional
	 @Modifying
	 @Query("update CarDO set driverId = :driverId,selected='YES' where id = :id")
	 public void updatedCarForDriver(@Param("id") Long carId,@Param("driverId") Long driverId);
	
	 
}

