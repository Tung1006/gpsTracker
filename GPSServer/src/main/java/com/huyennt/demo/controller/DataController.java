package com.huyennt.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.huyennt.demo.common.Constants;
import com.huyennt.demo.common.ResponseBean;
import com.huyennt.demo.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.huyennt.demo.model.Data;
import com.huyennt.demo.repository.DataRepo;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	DataRepo dataRepo;

    @Autowired
    DataService service;

	@GetMapping("/datas")
	public ResponseEntity<List<Data>> getAllDatas(@RequestParam(required = false) String deviceId) {
		// khai bao mang luu du lieu datas
		List<Data> datas = new ArrayList<Data>();

		// ktra trong datas, neu co deviceId thi them vao mang
		// tai sao k co deviceId lai dung findAll?
		if (deviceId == null) {
			dataRepo.findAll().forEach(datas::add);
		} else {
			dataRepo.findByDeviceId(deviceId).forEach(datas::add);
		}
		// mang datas trong tra ve body rong, co datas tra ve ok
		if (datas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(datas, HttpStatus.OK);
		}
	}

	@GetMapping("/datas/{id}")
	public ResponseEntity<Data> getOneData(@PathVariable("id") Long id) {
		Optional<Data> data = dataRepo.findById(id);
		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/add")
    @Operation(summary = "[Thêm mới ]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody @Valid Data entity) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(service.add(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

	@PutMapping("/datas/{id}")
	public ResponseEntity<Data> updateData(@PathVariable("id") long id, @RequestBody Data data) {
		Optional<Data> dataBody = dataRepo.findById(id);

		if (dataBody.isPresent()) {
			Data _data = dataBody.get();
			_data.setDeviceId(data.getDeviceId());
			_data.setLatitude(data.getLatitude());
			_data.setLongtitude(data.getLongtitude());
			_data.setAltitude(data.getAltitude());
			_data.setDate(data.getDate());
			_data.setTime(data.getTime());
			_data.setSpeed(data.getSpeed());
			_data.setActive(data.getActive());
			return new ResponseEntity<>(dataRepo.save(_data), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/datas/{id}")
	public ResponseEntity<HttpStatus> deleteDatas(@PathVariable("id") long id) {
		dataRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/datas")
	public ResponseEntity<HttpStatus> deleteAllDatas() {
		dataRepo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
