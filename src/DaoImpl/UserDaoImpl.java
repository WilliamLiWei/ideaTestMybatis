package DaoImpl;
import Dao.UserDao;
import Util.MybatisUtil;
import model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserById(int id) {
        //实现通过ID来查询user对象
        SqlSession session = MybatisUtil.getFactory().openSession();
        User user;
        user = session.selectOne("model.User.findUserById",id);
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        /**
         * 获取该接口的代理实现类的对象
         * mybatis会提供一个代理实现类，代理实现类也重写了该接口UserDao的所有方法，
         * 在findUserByName方法内部
         * 1：通过getMapper(UserDao.class)获取到该接口对应的mappper.xml
         * 2：读取并加载该mapper.xml
         * 3：当你调用代理类的方法时，会从mappper.xml中找到对应的statenment，进行输入参数和输出参数的映射执行
         * 总结:mybatis是基于动态代理来实现(cglib.jar)
         */
        SqlSession session = MybatisUtil.getFactory().openSession();
        UserDao ud = session.getMapper(UserDao.class);
        return ud.findUserByName(name);
    }
}
