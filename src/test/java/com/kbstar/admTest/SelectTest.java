package com.kbstar.admTest;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads(){
        List<Adm> list =null;
        try{
            list=service.get();
            for(Adm obj:list){
                log.info(obj.toString());
            }
            log.info("select ok ================================================================================");
        }catch (Exception e){
            log.info("시스템오류================================================================================");
        }
    }

}
