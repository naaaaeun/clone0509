package com.kbstar.custTest;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {

    @Autowired
    CustService service;

    @Test
    void contextLoads(){
        Cust cust =new Cust("id01","pwd10","김말숙");
        try{
            service.modify(cust);
            log.info("update 완료================================================================================");
        }catch (Exception e){
            log.info("시스템오류================================================================================");
        }
    }

}
