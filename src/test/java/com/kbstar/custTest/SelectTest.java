package com.kbstar.custTest;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectTest {

    @Autowired
    CustService service;

    @Test
    void contextLoads(){
        List<Cust> list =null;
        try{
            list=service.get();
            for(Cust obj:list){
                log.info(obj.toString());
            }
            log.info("select ok ================================================================================");
        }catch (Exception e){
            log.info("시스템오류================================================================================");
        }
    }

}
