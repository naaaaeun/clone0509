package com.kbstar.mapper;

import com.kbstar.dto.Adm;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository //스프링에서 사용할 레포지토리
@Mapper //마이바티스에서 사용할 매퍼
public interface AdmMapper extends KBMapper<String, Adm> {
}
