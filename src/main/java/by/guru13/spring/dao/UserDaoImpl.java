package by.guru13.spring.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import by.guru13.spring.entities.User;

/**
 * Класс реализует необходимые операции, связанные
 * с классом User для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
@Component("usersDao")
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDaoImpl() {

    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    /**
     * Сохраняет нового пользователя
     *
     * @param user новый пользователь
     * @return true если сохранение прошло успешно
     */
    @Transactional
    @Override
    public boolean create(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUsername());
        params.addValue("password", passwordEncoder.encode(user.getPassword()));
        params.addValue("email", user.getEmail());
        params.addValue("enabled", user.isEnabled());
        params.addValue("authority", user.getAuthority());

        jdbc.update("INSERT INTO users (username, password, email, enabled) VALUES " +
                "(:username, :password, :email, :enabled)", params);

        return jdbc.update("INSERT INTO authorities (username, authority) " +
                "VALUES (:username, :authority)", params) == 1;
    }

    /**
     * Проверяет, есть ли пользователь с данным именем
     *
     * @param username
     * @return true если такой пользователь есть
     */
    public boolean exists(String username) {

        return jdbc.queryForObject("SELECT count(*) FROM users WHERE username = :username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;
    }

    /**
     * Получает всех пользователей
     *
     * @return список пользователей
     */
    public List<User> getAllUsers() {

        return jdbc.query("select * from users, authorities where users.username=authorities.username",
                BeanPropertyRowMapper.newInstance(User.class));
    }
}
