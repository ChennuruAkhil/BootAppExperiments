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

    @GetMapping("difference/objects/reflection")
    public List<String> difference() throws IllegalAccessException {
        var branches = new ArrayList<Branch>();
        branches.add(Branch.CE);
        var branches2 = new ArrayList<Branch>();
        branches2.add(Branch.CE);
        branches2.add(Branch.CSE);
        var s1 = new CollegeDto("GMR", "GMRIT", "JNTUK", branches);
        var s2 = new CollegeDto("VIGNAN", "VIT", "JNTUK", branches2);
        objectTypeTest(s1,s2);
        List<String> changedProperties = new ArrayList<>();
        for (Field field : s1.getClass().getDeclaredFields()) {
            // You might want to set modifier to public first (if it is not public yet)
            field.setAccessible(true);
            Object value1 = field.get(s1);
            Object value2 = field.get(s2);
            if (value1 != null && value2 != null) {
                System.out.println(field.getName() + "=" + value1);
                System.out.println(field.getName() + "=" + value2);
                if (!Objects.equals(value1, value2)) {
                    changedProperties.add(field.getName());
                }
            }
        }
        return changedProperties;
    }

     public void objectTypeTest(Object a, Object b){
        log.info("#############"+a.getClass().getSimpleName());
        log.info(b.getClass().getSimpleName());
    }

}
