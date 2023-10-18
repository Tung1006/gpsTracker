package com.huyennt.demo.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name = "datas")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String deviceId;
	private String longtitude;
	private String latitude;
	private String altitude;
	private Date date;
	private Time time;
	private String speed;
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Data() {

	}

	public Data(String deviceId, String latitude, String longtitude, String altitude, Date date, Time time,
			String speed, Boolean active) {
		this.deviceId = deviceId;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.altitude = altitude;
		this.date = date;
		this.time = time;
		this.speed = speed;
		this.active = active;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
