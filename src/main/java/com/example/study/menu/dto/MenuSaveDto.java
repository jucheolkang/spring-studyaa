package com.example.study.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuSaveDto {
    private Long price;
    private String name;

    @Builder
    public MenuSaveDto(Long price, String name) {
        this.price = price;
        this.name = name;
    }
}
