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

@Service // @Entity처럼 @Service는 이 클래스가 service로 동작한다는 의미
@RequiredArgsConstructor // 생성자를 대신 만들어줌(생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션)
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    // 데이터베이스의 데이터를 조작하는 부분에 사용 -> 저장, 삭제, 수정 기능에 사용(조회에는 필요x)
    public Long saveMenu(MenuSaveDto menuSaveDto) {
        MenuEntity menuEntity = menuRepository.save(MenuEntity.builder()
                .name(menuSaveDto.getName())
                // .name() 괄호에 들어가는 값은 menuSaveDto에서 @getter 어노테이션으로 가져온 값
                .price(menuSaveDto.getPrice())
                .build());
        return menuEntity.getMenuId();
        // 위 리턴 값은 개발자가 프로젝트에 따라서 정의함
    }

    public int add(int a, int b) {
        int c = a+b;
        return c;
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
