package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.dto.Marker;
import com.kbstar.dto.MarkerSearch;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/marker")
public class MarkerController {
    String dir="marker/";

    @Value("${uploadimgdir}")
    String imgdir;

    @Autowired
    MarkerService service;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Marker marker) throws Exception {
        MultipartFile mf=marker.getImgfile();
        String img = mf.getOriginalFilename();
        marker.setImg(img);
        FileUploadUtil.saveFile(mf,imgdir);
        service.register(marker);
        return "redirect:/marker/all";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Marker> list=service.get();
        model.addAttribute("mlist", list);
        model.addAttribute("center", dir+"all");
        return "index";
        }
        @RequestMapping("/detail")
        public String detail(Model model, int id) throws Exception {
            Marker marker = null;
            try {
                marker = service.get(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            model.addAttribute("marker", marker);
            model.addAttribute("center", dir+"detail");
            return "index";
        }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Marker marker) throws Exception {
        MultipartFile mf = marker.getImgfile();
        String new_img = mf.getOriginalFilename();
        if(new_img.equals("")||new_img==null){
            service.modify(marker);
        }else{
            marker.setImg(new_img);
            service.modify(marker);
            FileUploadUtil.saveFile(mf,imgdir);
        }

        return "redirect:/marker/detail?id="+marker.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        service.remove(id);
        return "redirect:/marker/all";
    }
    @RequestMapping("/search")
    public String search(Model model, MarkerSearch ms) throws Exception {
        if(ms.getLoc().isEmpty()){
            ms.setLoc(null);
        }
        if(ms.getTitle().isEmpty()){
            ms.setTitle(null);
        }
        List<Marker> list =service.search(ms);
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir+"all");
        return "index";
    }
}
