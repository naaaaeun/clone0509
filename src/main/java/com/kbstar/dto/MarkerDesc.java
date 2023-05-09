package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MarkerDesc {
    private int id;
    private int marker_id;
    private String item;
    private Double price;
    private String imgname;
}
