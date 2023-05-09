package com.kbstar.admTest;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads(){
        Adm obj =new Adm("admin20","pwd20",1);
        try{
            service.register(obj);
            log.info("register ok ================================================================================");
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                log.info("id 중복오류================================================================================");
            }else{
                log.info("시스템오류================================================================================");
                e.printStackTrace();
            }
        }
    }

}
