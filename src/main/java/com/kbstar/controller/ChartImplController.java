package com.kbstar.controller;

import com.kbstar.dto.Sales;
import com.kbstar.mapper.SalesMapper;
import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
@Slf4j
@RestController
public class ChartImplController {
    @Autowired
    SalesService service;

    @RequestMapping("/getdatasales")
    public Object getdatasales() throws Exception {
        List <Sales> list= null;
        try {
            list = service.getdatasales();
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        JSONArray jaM=new JSONArray();
        JSONArray jaF=new JSONArray();

        JSONObject jo = new JSONObject();

        for(Sales obj:list){
            if (obj.getGender().equals("M")) {
                jaM.add(obj.getPrice());
            }else{
                jaF.add(obj.getPrice());
            }
        }
        jo.put("Male",jaM);
        jo.put("Female",jaF);
        return jo;
    }

}
