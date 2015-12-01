package by.guru13.spring.service;

import by.guru13.spring.entities.User;

import java.util.List;

/**
 * Интерфейс содержит необходимые операции, связанные
 * с классом User для работы с базой данных
 * <p>
 *
 * @author Alexey Guryanchyck
 */
public interface UserService {

    void create(User user);

    boolean exists(String username);

    List<User> getAllUsers();

}
