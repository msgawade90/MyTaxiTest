package com.mytaxi.datatransferobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mytaxi.datatransferobject.DriverDTO.DriverDTOBuilder;

public class CarDTO {
	
	@JsonIgnore
	private long id;

	@NotNull(message = "License plate can not be null!")
	private String license_plate;

	@NotNull(message = "Seat count can not be null!")
	private int seat_count;

	@NotNull(message = "Convertible can not be null!")
	private int convertible;

	@NotNull(message = "Rating can not be null!")
	private double  rating;

	@NotNull(message = "Engine type can not be null!")
	private String engine_type;
	
	@NotNull(message = "Manufacturer can not be null!")
	private String manufacturer;
	
	@NotNull(message = "Selected can not be null!")
	private String selected;
	
	private Long driverId;


	public CarDTO(long id, String license_plate, int seat_count, int convertible, double rating, String engine_type,String manufacturer,String selected,Long driverId) {
		super();
		this.id = id;
		this.license_plate = license_plate;
		this.seat_count = seat_count;
		this.convertible = convertible;
		this.rating = rating;
		this.engine_type = engine_type;
		this.manufacturer=manufacturer;
		this.selected=selected;
		this.driverId=driverId;
	}
	
    public static CarDTOBuilder newBuilder()
    {
        return new CarDTOBuilder();
    }
    
    
    
	 public long getId() {
		return id;
	}



	public String getLicense_plate() {
		return license_plate;
	}

	

	public int getSeat_count() {
		return seat_count;
	}



	public int getConvertible() {
		return convertible;
	}



	public double getRating() {
		return rating;
	}



	public String getEngine_type() {
		return engine_type;
	}

	public String getManufacturer() {
		return manufacturer;
	}


	public String getSelected() {
		return selected;
	}




	public Long getDriverId() {
		return driverId;
	}






	public static class CarDTOBuilder
	    {
	      //  return new CarDTOBuilder();

			private long id;

			private String license_plate;

			private int seat_count;

			private int convertible;

			private double  rating;

			private String engine_type;
			
			private String manufacturer;
			
			private String selected;
			
			private Long driverId;


			
			public CarDTOBuilder setId(long id) {
				this.id = id;
				return this;
			}
			
			public CarDTOBuilder setLicense_plate(String license_plate) {
				this.license_plate = license_plate;
				return this;
			}
			
			public CarDTOBuilder setSeat_count(int seat_count) {
				this.seat_count = seat_count;
				return this;
			}
			
			public CarDTOBuilder setConvertible(int convertible) {
				this.convertible = convertible;
				return this;
			}
			
			public CarDTOBuilder setRating(double rating) {
				this.rating = rating;
				return this;
			}
			
			public CarDTOBuilder setEngine_type(String engine_type) {
				this.engine_type = engine_type;
				return this;
			}
			
			public CarDTOBuilder setManufacturer(String manufacturer) {
				this.manufacturer = manufacturer;
				return this;

			}
			
			public CarDTOBuilder setSelected(String selected) {
				this.selected = selected;
				return this;

			}
			
			public CarDTOBuilder setDriverId(Long driverId) {
				this.driverId = driverId;
				return this;
			}
			
		       public CarDTO createCarDTO()
		        {
		            return new CarDTO(id,license_plate,seat_count,convertible,rating,engine_type,manufacturer,selected,driverId);
		        }
	    }
	
	
}
