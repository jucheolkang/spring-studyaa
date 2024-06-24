package com.example.study.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuUpdateDto {
    private Long price;
    private String name;

    @Builder
    public MenuUpdateDto(Long price, String name) {
        this.price = price;
        this.name = name;
    }
}
