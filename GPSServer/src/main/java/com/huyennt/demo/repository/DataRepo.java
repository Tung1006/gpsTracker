package com.huyennt.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huyennt.demo.model.Data;

@Repository
public interface DataRepo extends JpaRepository<Data, Long> {
	List<Data> findByActive(Boolean active);
	List<Data> findByDeviceId(String deviceId);
}
