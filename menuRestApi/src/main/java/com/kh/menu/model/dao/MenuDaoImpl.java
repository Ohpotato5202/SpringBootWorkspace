package com.kh.menu.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.menu.model.vo.Menu;

@Repository
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<Menu> selectMenus() {
        return sqlSession.selectList("menu.selectMenus");
    }

    @Override
    public int insertMenu(Menu menu) {
        return sqlSession.insert("menu.insertMenu", menu);
    }

    @Override
    public List<Menu> selectMenuList(Map<String, Object> param) {
        return sqlSession.selectList("menu.selectMenuList", param);
    }

    @Override
    public Menu selectOneMenu(int id) {
        return sqlSession.selectOne("menu.selectOneMenu", id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return sqlSession.update("menu.updateMenu", menu);
    }

	@Override
	public int deleteMenu(int id) {
		return sqlSession.delete("menu.deleteMenu", id);
	}
}
	