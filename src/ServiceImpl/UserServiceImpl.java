package ServiceImpl;

import Dao.UserDao;
import Util.MybatisUtil;
import model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements Service.UserService {

    @Override
    public User findUserById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        UserDao ud = session.getMapper(UserDao.class);
        return ud.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        UserDao ud = session.getMapper(UserDao.class);
        return ud.findUserByName(name);
    }

    @Override
    public Boolean addUserByParameters(String username, int age) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        UserDao ud = session.getMapper(UserDao.class);
        Boolean bl =ud.addUserByParameters(username,age);
        if(bl) session.commit();
        return  bl;
    }
}
