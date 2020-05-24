package test;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        InputStream in;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException exception) {
            // TODO Auto-generated catch block
            final String message = String.format("exception: '%2$s'.", exception);
            System.out.println(message);
            throw new RuntimeException(message, exception);
        }
        // 2:创建会话工厂(会话就是连接)
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3:获取会话对象(相当于jdbc当中的connection)
        SqlSession session = factory.openSession();

        String strName = "丁";
        List<User> lstUser = session.selectList("model.User.findUserByName",strName);
        for (User user:lstUser) {
            System.out.println(user);
        }
        session.close();
    }
}
