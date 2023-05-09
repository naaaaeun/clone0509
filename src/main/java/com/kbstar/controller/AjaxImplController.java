package com.kbstar.controller;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//일반적인 컨트롤러는 화면을 반환. ajax는 일부만 반환할 것임. 따라서 어노테이션도 다름.
@RestController
public class AjaxImplController {
    @Autowired
    AdmService admService;
    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception {
        int result =0;
        Adm adm=admService.get(id);
        if(adm!=null){
            result++;
        }
        return result;
    }
}
