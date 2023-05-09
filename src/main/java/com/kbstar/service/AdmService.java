package com.kbstar.service;

import com.kbstar.dto.Adm;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.AdmMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j //로그를 위한 어노테이션.
@Service
public class AdmService implements KBService<String, Adm> {
    /**
     * @param adm
     * @throws Exception
     */
    @Autowired
    AdmMapper mapper;
    @Override
    public void register(Adm adm) throws Exception {
        mapper.insert(adm);
    }

    /**
     * @param s
     * @throws Exception
     */
    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    /**
     * @param adm
     * @throws Exception
     */
    @Override
    public void modify(Adm adm) throws Exception {
        mapper.update(adm);
    }

    /**
     * @param s
     * @return
     * @throws Exception
     */
    @Override
    public Adm get(String s) throws Exception {
        Adm adm=null;
        adm=mapper.select(s);
        return adm;
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List get() throws Exception {
        List<Adm> list=mapper.selectall();
        return list;
    }
}
