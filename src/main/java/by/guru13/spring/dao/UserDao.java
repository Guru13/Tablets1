package by.guru13.spring.dao;

import by.guru13.spring.entities.User;

import java.util.List;

/**
 * Интерфейс содержит необходимые операции, связанные
 * с классом User для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
public interface UserDao {
    /**
     * Сохраняет нового пользователя
     *
     * @param user новый пользователь
     * @return true если сохранение прошло успешно
     */
    boolean create(User user);

    /**
     * Проверяет, есть ли пользователь с данным именем
     *
     * @param username
     * @return true если такой пользователь есть
     */
    boolean exists(String username);

    /**
     * Получает всех пользователей
     *
     * @return список пользователей
     */
    List<User> getAllUsers();
}
