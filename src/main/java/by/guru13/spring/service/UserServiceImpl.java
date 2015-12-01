package by.guru13.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import by.guru13.spring.dao.UserDao;
import by.guru13.spring.entities.User;

/**
 * Класс реализует необходимые операции, связанные
 * с классом User для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
@Service("usersService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public boolean exists(String username) {

        return userDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}
