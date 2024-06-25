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

@RestController // rest api - url을 통해 값을 주고 받는다
@RequestMapping("/menu")// http://localhost:8080/menu
@RequiredArgsConstructor
public class MenuContorller {
    private final MenuService menuService;

    @PostMapping// http://localhost:8080/menu
    public Long menuSave(@RequestBody MenuSaveDto menuSaveDto) {
        return menuService.saveMenu(menuSaveDto); // saveMenu 메소드에 값 입력
    }
    // rest api 메소드는 5가지 get, post, delete, patch, put
    // get -> 값을 가져옴 - 화면 기준으로 말하는 거라서 서버는 데이터를 전송해줌
    // post -> 값을 입력함 - 서버에 값을 전송
    // delete -> 값 삭제 요청 - 서버에게 특정 데이터를 삭제하도록 함
    // patch, put -> 값 수정

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
