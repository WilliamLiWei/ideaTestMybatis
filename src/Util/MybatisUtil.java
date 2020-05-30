package Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;

    static {
        //1:获取核心配置文件的数据
        InputStream in;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
            //2:创建会话工厂(会话就是连接)
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }
}
