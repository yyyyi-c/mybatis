package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    private InputStream in;
    private SqlSession session;
    private IUserDao dao;
    private IAccountDao iAccountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        dao = session.getMapper(IUserDao.class);
        iAccountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUsername("%王%");
        user.setAddress("%北京%");

        List<User> users = dao.findByUser(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(56);
        ids.add(59);
        vo.setIds(ids);
        List<User> users = dao.findByIds(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindAll() {

        List<User> users = iAccountDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
