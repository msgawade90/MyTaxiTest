package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "license_plate", columnNames = {"license_plate"})
)
public class CarDO {

	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now(); 

	@Column(nullable = false)
	@NotNull(message = "License plate can not be null!")
	private String license_plate;

	@Column(nullable = false)
	@NotNull(message = "Seat count can not be null!")
	private int seat_count;

	@Column(nullable = false)
	@NotNull(message = "Convertible can not be null!")
	private int convertible;

	@Column(nullable = false)
	@NotNull(message = "Rating can not be null!")
	private double  rating;

	@Column(nullable = false)
	@NotNull(message = "Engine type can not be null!")
	private String engine_type;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private DriverDO driver;
	
	@Column(nullable = false)
	@NotNull(message = "Manufacturer can not be null!")
	private String manufacturer;
	
	 @Column(nullable = false)
	 private Boolean deleted = false;
	 
	 @Column(nullable = false)
     @NotNull(message = "Selected can not be null!")
	 private String selected;

	 @Column
	 private Long driverId;
	 
	
	public CarDO()
	{
		
	}
	
	public CarDO(String license_plate, int seat_count, int convertible,
			double rating, String engine_type,String manufacturer,String selected,Long driverId) {
		super();
		this.license_plate = license_plate;
		this.seat_count = seat_count;
		this.convertible = convertible;
		this.rating = rating;
		this.engine_type = engine_type;
		this.manufacturer=manufacturer;
		this.selected=selected;
		this.driverId=driverId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}

	public int getConvertible() {
		return convertible;
	}

	public void setConvertible(int convertible) {
		this.convertible = convertible;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public DriverDO getDriver() {
		return driver;
	}

	public void setDriver(DriverDO driver) {
		this.driver = driver;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	
	
	
	
}
