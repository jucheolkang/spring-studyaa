package com.example.study.menu.service;

import com.example.study.menu.dto.MenuSaveDto;
import com.example.study.menu.dto.MenuUpdateDto;
import com.example.study.menu.dto.ResponseMenuDto;
import com.example.study.menu.entity.MenuEntity;
import com.example.study.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public Long saveMenu(MenuSaveDto menuSaveDto) {
        MenuEntity menuEntity = menuRepository.save(MenuEntity.builder()
                .name(menuSaveDto.getName())
                .price(menuSaveDto.getPrice())
                .build());
        return menuEntity.getMenuId();
    }

    @Transactional
    public void updateMenu(Long id, MenuUpdateDto menuUpdateDto) {
        MenuEntity menuEntity = findMenuById(id);
        menuEntity.update(menuUpdateDto.getPrice(), menuUpdateDto.getName());
    }

    @Transactional
    public void deleteMenu(Long id) {
        MenuEntity menuEntity = findMenuById(id);
        menuRepository.delete(menuEntity);
    }

    public List<ResponseMenuDto> findAllMenus() {
        List<MenuEntity> menuEntities = menuRepository.findAll();
        return menuEntities.stream()
                .map(menuEntity -> ResponseMenuDto.builder()
                        .menuId(menuEntity.getMenuId())
                        .price(menuEntity.getPrice())
                        .name(menuEntity.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public MenuEntity findMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id =" + id));
    }

}
