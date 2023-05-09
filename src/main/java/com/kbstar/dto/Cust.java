package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cust {
    @Size(min=4, max=10, message="ID는 최소 4개 최대 10 입니다.")
    @NotEmpty
    private String id;

    @Size(min=5, max=10, message="PWD는 최소 5개 최대 10 입니다.")
    @NotEmpty
    private String pwd;

    @NotEmpty
    private String name;
}