package Application.DAO;

import Application.Model.MyUser;

import java.util.List;

public interface UserDao {

    public MyUser findById(Long id);

    public MyUser findByName(String username);

    public List<MyUser> findAll();

    public MyUser saveUser(MyUser myUser);

    public void deleteById(Long id);

    public MyUser update(MyUser myUser);
}
