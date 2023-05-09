package com.kbstar.admTest;

import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RemoveTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads(){
        try{
            service.remove("admin20");
            log.info("삭제 완료================================================================================");
        }catch (Exception e){
            log.info("시스템오류================================================================================");
        }
    }

}
