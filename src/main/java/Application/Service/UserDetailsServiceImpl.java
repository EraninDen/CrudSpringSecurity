package Application.Service;

import Application.DAO.UserDao;

import Application.Model.MyUser;
import Application.Model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userDao.findByName(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : myUser.getRoleSet()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            return new User(myUser.getUsername(), myUser.getPassword(), myUser.getAuthorities());
        }
        return new User(myUser.getUsername(),myUser.getPassword(), grantedAuthorities);
    }
}
