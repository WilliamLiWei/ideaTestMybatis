package curd;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Service.UserService;
import ServiceImpl.UserServiceImpl;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test1() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUserById(10));

        System.out.println("--------------------------------");

        UserService us = new UserServiceImpl();
        System.out.println(us.findUserById(10));
    }

    @Test
    public void test2() {

        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.findUserByName("王"));
    }

    @Test
    public void test3() {

        UserService us = new UserServiceImpl();
        System.out.println(us.addUserByParameters("liwei", 20));
    }
}
