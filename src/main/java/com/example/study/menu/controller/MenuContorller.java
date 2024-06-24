package com.example.study.menu.controller;

import com.example.study.menu.dto.MenuSaveDto;

import com.example.study.menu.dto.MenuUpdateDto;
import com.example.study.menu.dto.ResponseMenuDto;
import com.example.study.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuContorller {
    private final MenuService menuService;

    @PostMapping
    public Long menuSave(@RequestBody MenuSaveDto menuSaveDto) {
        return menuService.saveMenu(menuSaveDto);
    }

    @PatchMapping("/{id}")
    public void menuUpdate(@PathVariable Long id, @RequestBody MenuUpdateDto menuUpdateDto) {
        menuService.updateMenu(id, menuUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void menuDelete(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }

    @GetMapping()
    public List<ResponseMenuDto> menuFindAll() {
        return menuService.findAllMenus();
    }
}
