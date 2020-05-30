package Dao;

import model.User;

import java.util.List;

public interface UserDao {
    public User findUserById(int id);
    public List<User> findUserByName(String name);
}
