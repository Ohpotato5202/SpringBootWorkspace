package com.kh.menu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.menu.model.dao.MenuDao;
import com.kh.menu.model.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> selectMenus() {
        return menuDao.selectMenus();
    }

    @Override
    public int insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    @Override
    public List<Menu> selectMenuList(Map<String, Object> param) {
        return menuDao.selectMenuList(param);
    }

    @Override
    public Menu selectOneMenu(int id) {
        return menuDao.selectOneMenu(id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

	@Override
	public int deleteMenu(int id) {
		return menuDao.deleteMenu(id);
	}
}
