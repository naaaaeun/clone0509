package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Slf4j // log
@Controller
@RequestMapping("/cust")
public class CustController {

    String dir = "cust/";

    @Autowired
    CustService custService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping("/add")
    public String add(Model model) throws Exception {
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, String id) throws Exception {
        Cust cust=custService.get(id);
        model.addAttribute("custinfo", cust);
        model.addAttribute("center", dir+"detail");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Cust> list = null;
        list = custService.get();
        model.addAttribute("clist", list);
        model.addAttribute("center", dir+"all");
        return "index";
    }

    @RequestMapping("/addimpl")
    //@Validated. Cust DTO 만들 때 넣었던 제약사항들을 체크하겠다는 뜻
    public String addimpl(Model model, @Validated Cust cust, Errors erros) throws Exception {

        if(erros.hasErrors()){
            List<ObjectError> es=erros.getAllErrors();
            String msg="";
            for(ObjectError e:es){
                msg+="<h4>";
                msg+=e.getDefaultMessage();
                msg+="</h4>";
            }
            throw new Exception(msg);
        }
        cust.setPwd(encoder.encode(cust.getPwd()));
        custService.register(cust);

        return "redirect:/cust/all";
    }
    @RequestMapping("/updateimpl")
    //@Validated. Cust DTO 만들 때 넣었던 제약사항들을 체크하겠다는 뜻
    public String updateimpl(Model model, @Validated Cust cust, Errors erros) throws Exception {
        if(erros.hasErrors()){
            List<ObjectError> es=erros.getAllErrors();
            String msg="";
            for(ObjectError e:es){
                msg+="<h4>";
                msg+=e.getDefaultMessage();
                msg+="</h4>";
            }
            throw new Exception(msg);
        }
        cust.setPwd(encoder.encode(cust.getPwd()));
        custService.modify(cust);

        return "redirect:/cust/detail?id="+cust.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(String id) throws Exception {
        custService.remove(id);

        return "redirect:/cust/all";
    }


}