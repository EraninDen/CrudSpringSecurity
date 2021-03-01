package Application.Service;

import Application.Model.User;

import java.util.List;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

    public User saveUser(User user);

    public void deleteById(Long id);

    public User update(User User);
}
