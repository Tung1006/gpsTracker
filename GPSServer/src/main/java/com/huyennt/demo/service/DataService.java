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

}
