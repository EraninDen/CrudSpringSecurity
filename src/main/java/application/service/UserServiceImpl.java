package application.service;

import application.dao.UserDao;
import application.model.MyUser;
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


    public MyUser findById(Long id){
        return userDao.findById(id);
    }

    @Override
    public MyUser findByName(String username) {
        return userDao.findByName(username);
    }

    public List<MyUser> findAll(){
        return userDao.findAll();
    }

    public MyUser saveUser(MyUser myUser){
        return userDao.saveUser(myUser);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    @Override
    public MyUser update(MyUser myUser) {
        return userDao.update(myUser);
    }
}