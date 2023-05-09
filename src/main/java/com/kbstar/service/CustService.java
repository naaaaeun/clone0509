package com.kbstar.service;

import com.kbstar.dto.Cust;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.CustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j //로그를 위한 어노테이션.
@Service
public class CustService implements KBService<String, Cust> {
    @Autowired
    CustMapper mapper;
    @Override
    public void register(Cust cust) throws Exception {
        mapper.insert(cust);
        log.info("send mail....register complete "+cust.getId());
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);

    }

    @Override
    public void modify(Cust cust) throws Exception {
        mapper.update(cust);

    }

    @Override
    public Cust get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List get() throws Exception {

        return mapper.selectall();
    }
}
