package com.huyennt.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.huyennt.demo.model.Data;


public interface DataRepo extends JpaRepository<Data, Long> {
	List<Data> findByActive(Boolean active);
	List<Data> findByDeviceId(String deviceId);
}
