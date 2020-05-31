package Service;

import model.User;

import java.util.List;

public interface UserService {
    public User findUserById(int id);
    public List<User> findUserByName(String name);
    public Boolean addUserByParameters(String username, int age);
}
