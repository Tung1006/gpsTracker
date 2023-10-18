package com.huyennt.demo.service;

import com.huyennt.demo.model.Data;
import com.huyennt.demo.repository.DataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class DataService {

    private final Logger log = LoggerFactory.getLogger(DataService.class);
    @Autowired
    DataRepo repository;

    public long add(Data entity) {
        entity.setDate(new Date());

        long id = repository.save(
                entity
        ).getId();

        try {
            log.info("add", "RescueTeam", entity);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }

        return id;
    }
    
    public long findbyid(long id) {
    	Data entityData = repository.getOne(id);
    	System.out.println(entityData + "hahahahahha");
    	
    	if(entityData==null)
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "khong tim thay");
    	
    	
    	return entityData.getId();
    }
    
    public Data update(Data entity) {
    	//tim kiem co ban ghi hay khong
    	
    	findbyid(entity.getId());
    	//neu khong thi canh bao
    	
    	// neu co thi update
    	return repository.save(entity);
    }
    
    public List<Data> findall(){
    	return repository.findAll();
    }

}
