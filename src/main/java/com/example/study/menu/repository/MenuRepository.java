package com.example.study.menu.repository;

import com.example.study.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    //1. 원래 sql 문법 데이터 주고 받음 -> 불편 -> 2. jpa로 클래스 바로 sql 변환 -> 불편 -> 3. spring data jap로 기존 jpa에서 불편한거 해결
}
