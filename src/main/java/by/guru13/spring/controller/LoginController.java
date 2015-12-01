package by.guru13.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.guru13.spring.entities.User;
import by.guru13.spring.service.UserService;

/**
 * Класс-контроллер для работы с пользователем. Создание, авторизация, аутентификация, выход.
 * <p>
 *
 * @author Alexey Guryanchyck
 */
@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUsersService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUsersService() {
        return userService;
    }

    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
    }

    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/newaccount")
    public String showNewAccount(Model model) {
        model.addAttribute("user", new User());
        return "newaccount";
    }

    @RequestMapping("/loggedout")
    public String showLoggedOut() {

        return "loggedout";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String createAccount(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "newaccount";
        }
        user.setAuthority("ROLE_USER");
        user.setEnabled(true);

        if (userService.exists(user.getUsername())) {

            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        try {
            userService.create(user);
        } catch (DuplicateKeyException ex) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        return "accountcreated";
    }
}