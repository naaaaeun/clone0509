package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.dto.ItemSearch;
import com.kbstar.dto.Marker;
import com.kbstar.dto.MarkerSearch;
import com.kbstar.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {
    String dir="item/";

    @Value("${uploadimgdir}")
    String imgdir;

    @Autowired
    ItemService service;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String imgname = mf.getOriginalFilename();
        item.setImgname(imgname);
        service.register(item);
        FileUploadUtil.saveFile(mf,imgdir);
        return "redirect:/item/all";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String imgname = mf.getOriginalFilename();
        if(imgname.equals("")||imgname==null){
            service.modify(item);
        }else{
            item.setImgname(imgname);
            service.modify(item);
            FileUploadUtil.saveFile(mf,imgdir);
        }
//        if(!imgname.equals("")|| imgname !=null){
//            item.setImgname(imgname);
//        }
//        service.modify(item);

        return "redirect:/item/detail?id="+item.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        service.remove(id);
        return "redirect:/item/all";
    }

    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Item> list=service.get();
        model.addAttribute("ilist", list);
        model.addAttribute("center", dir+"all");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, int id) throws Exception {
        Item item = null;
        try {
            item = service.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("gitem", item);
        model.addAttribute("center", dir+"detail");
        return "index";
    }

        @RequestMapping("/search")
        public String search(Model model, ItemSearch is) throws Exception {
            List<Item> list =service.search(is);
            model.addAttribute("ilist",list);
            model.addAttribute("ms",is);
            model.addAttribute("center",dir+"all");
            return "index";
        }
}
