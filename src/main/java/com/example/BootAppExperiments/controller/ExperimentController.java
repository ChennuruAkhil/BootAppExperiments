package com.example.BootAppExperiments.controller;

import com.example.BootAppExperiments.dto.Branch;
import com.example.BootAppExperiments.dto.CollegeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Slf4j
@RestController
public class ExperimentController {

    @GetMapping("sample/Object/Iterator")
    public String objectIterator() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var branches = new ArrayList<Branch>();
        branches.add(Branch.CE);
        HashMap<String, Object> map = mapper.convertValue(new CollegeDto("GMR", "GMRIT", "JNTUK", branches), HashMap.class);
        for (Map.Entry<String, Object> field : map.entrySet()) {
            log.info(field.getKey() + " : " + field.getValue());
            log.info(mapper.writeValueAsString(field.getValue()).replace("\"", ""));
        }
        map.forEach((k, v) -> log.info(k + " : " + v));
        return mapper.writeValueAsString(map);
    }

}
