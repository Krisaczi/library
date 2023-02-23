package pl.ksiegarnia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ksiegarnia.database.IUserDao;
import pl.ksiegarnia.exceptions.UserValidationException;
import pl.ksiegarnia.model.User;
import pl.ksiegarnia.validators.UserVAlidator;

import static org.springframework.util.DigestUtils.*;

@Controller
public class AutenthicationController {

    @Autowired
    IUserDao userDao;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        try{
            UserVAlidator.validateLogin(login);
            UserVAlidator.validatePassword(password);
        } catch (UserValidationException e){
            e.printStackTrace();
            return "redirect:/login";
        }

       User user = this.userDao.getUserByLogin(login);
       if(user !=null && user.getPassword().equals(org.apache.commons.codec.digest.DigestUtils.md5Hex(password))) {

               return "redirect:/main";
           }

        return "redirect:/login";

    }
}
