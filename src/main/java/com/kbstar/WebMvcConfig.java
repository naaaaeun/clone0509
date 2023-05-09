package com.kbstar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //리소스 폴더 외 다른 폴더-프로젝트 외부에 리소스 폴더 지정하여 스태틱과는 달리 실시간 반영 가능하도록.
    //application.properties에서 경로 지정함

    @Value("${imgdir}") //spring import
    String imgdir;
    @Value("${logdir}")
    String logdir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uimg/**").addResourceLocations(imgdir);
        registry.addResourceHandler("/logs/**").addResourceLocations(logdir);
    }

}

