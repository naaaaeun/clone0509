package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Marker {
    private int id;
    private String title;
    private String target;
    private double lat;
    private double lng;
    private String img;
    private String loc;

    private MultipartFile imgfile;

    public Marker(int i, String 치킨집, String url, double v, double v1, String image, String s) {
    }
}
