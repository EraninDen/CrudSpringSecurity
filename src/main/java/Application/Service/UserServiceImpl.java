package Application.Service;

import Application.DAO.UserDao;
import Application.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public User findById(Long id){
        return userDao.findById(id);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User saveUser(User user){
        return userDao.saveUser(user);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }
}