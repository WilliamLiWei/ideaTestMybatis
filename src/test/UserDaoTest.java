package test;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test1(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUserById(10));
    }

    @Test
    public void test2(){

        UserDao userDao=new UserDaoImpl();

        System.out.println(userDao.findUserByName("王"));
    }
}
