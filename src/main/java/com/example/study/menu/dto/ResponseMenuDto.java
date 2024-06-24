package com.example.study.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseMenuDto {
    private Long menuId;
    private Long price;
    private String name;

    @Builder
    public ResponseMenuDto(Long menuId, Long price, String name) {
        this.menuId = menuId;
        this.price = price;
        this.name = name;
    }
}
