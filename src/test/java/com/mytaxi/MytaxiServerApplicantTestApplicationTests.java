package com.mytaxi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.driver.DefaultCarService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MytaxiServerApplicantTestApplication.class)
public class MytaxiServerApplicantTestApplicationTests
{
	@Autowired
	private DefaultCarService defaultCarService;
	
	//@MockBean
    //private  CarRepository carRepository;

  
    @Test
    public void contextLoads() throws EntityNotFoundException
    {

    	CarDO carDO=defaultCarService.find((long) 102);
        Assert.assertEquals("2387287388", carDO.getLicense_plate());
    }

    
}
