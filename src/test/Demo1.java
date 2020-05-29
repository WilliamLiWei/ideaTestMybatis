package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.User;

public class Demo1 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        InputStream in;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException exception) {
            // TODO Auto-generated catch block
            final String message = String.format("exception: '%2$s'.", exception);
            System.out.println(message);
            throw new RuntimeException(message, exception);
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        int id = 1;
        User user = (User) session.selectOne("model.User.findUserById", id);
        System.out.println(user);
        session.close();
    }

}
