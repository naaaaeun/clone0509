package com.kbstar.controller;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    @Value("${adminserver}")
    String adminServer;

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private BCryptPasswordEncoder encoder; //로그인 시 pwd 암호화를 위한 변수 선언.

    @Autowired
    AdmService admService;

    @RequestMapping("/")
        public String main(Model model) {
            model.addAttribute("adminserver", adminServer);
        return "index";
    }

    @RequestMapping("/charts")
    public String charts(Model model){
        model.addAttribute("center", "charts");
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/logoutimpl")
    public String logoutimpl(HttpSession session){
        if(session !=null){
            session.invalidate(); //세션 끊을게요.
        }
        return "redirect:/";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        Adm adm=null;
        String nextPage="loginfail";
        try {
            adm = admService.get(id);
            if(adm !=null && encoder.matches(pwd,adm.getPwd())){
                nextPage=null;
                session.setMaxInactiveInterval(100000); //100초간 세션 유지할게요.
                session.setAttribute("loginadm", adm);

                //세션과 모델 모두 달러 사인으로 꺼낼 수 있어요.
            }
        }catch (Exception e){
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 하세요");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Adm adm, HttpSession session) throws Exception {  //변수 너무 많은 경우에는 이렇게! 담아서 한번에 보내자.
        try {
            adm.setPwd(encoder.encode(adm.getPwd()));
            admService.register(adm);
            session.setMaxInactiveInterval(100000);
            session.setAttribute("loginadm", adm);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("가입불가");
        }
        model.addAttribute("radm", adm);
        return "index";
    }

    @RequestMapping("/tables")
    public String tables(Model model){
        model.addAttribute("center", "tables");
        return "index";
    }
    @RequestMapping("/livechart")
    public String livechart(Model model) {
        model.addAttribute("adminserver", adminServer);
        model.addAttribute("center", "livechart");
        return "index";
    }
    @RequestMapping("/websocket")
    public String websocket(Model model){
        model.addAttribute("adminserver", adminServer);
        model.addAttribute("center", "websocket");
        return "index";
    }

}
