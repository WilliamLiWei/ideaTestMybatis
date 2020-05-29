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

        String strName = "李";
        List<User> lstUser = session.selectList("model.User.findUserByName",strName);
        for (User user:lstUser) {
            System.out.println(user);
        }

        //插入数据
        User user=new User();
        user.setUsername("王大米");
        user.setAge(20);

        //使用Session插入一条记录
        session.insert("model.User.addUser", user);
        //提交事务
        session.commit();

        //使用Session更新一条记录
        session.update("model.User.updateUser", user);
        System.out.println(user);
        session.commit();

        //使用Session删除一条记录
        session.delete("deleteUser",user);
        session.commit();

        session.close();
    }
}
