package com.kh.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.menu.model.service.MenuService;
import com.kh.menu.model.vo.Menu;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menus")
    public List<Menu> menus(HttpServletResponse response) {
        List<Menu> list = menuService.selectMenus();
        log.debug("list {}", list);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000");
        return list;
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/menu")
    public Map<String, Object> insertMenu(@RequestBody Menu menu) {
        log.debug("menu {}", menu);
        int result = menuService.insertMenu(menu);
        Map<String, Object> map = new HashMap<>();

        if (result > 0) {
            map.put("msg", "메뉴 등록 성공");
        } else {
            map.put("msg", "메뉴 등록 실패");
        }

        return map;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/searchMenu/type/{type}/taste/{taste}")
    public List<Menu> searchMenu(
        @PathVariable String type,
        @PathVariable String taste
    ) {
        log.debug("type = {}, taste = {}", type, taste);
        Map<String, Object> param = new HashMap<>();
        param.put("type", type);
        param.put("taste", taste);

        List<Menu> list = menuService.selectMenuList(param);
        return list;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/menu/{id}")
    public Menu selectOneMenu(@PathVariable int id) {
        return menuService.selectOneMenu(id);
    }

    @CrossOrigin(origins = {"*"})
    @PutMapping("/menu/{id}")
    public ResponseEntity<String> updateMenu(
        @PathVariable int id,
        @RequestBody Menu menu
    ) {
        menu.setId(id); // ID 설정
        int result = menuService.updateMenu(menu);
        if (result > 0) {
            return ResponseEntity.ok().body("수정성공");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
