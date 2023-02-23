package pl.ksiegarnia.validators;

import pl.ksiegarnia.exceptions.UserValidationException;

public class UserVAlidator {
    public static void validateLogin(String login){
        if(login.contains(" ") || login.length() < 5){
            throw new UserValidationException();
        }
    }

    public static void validatePassword(String password){
        if(password.contains(" ") || password.length()<5){
            throw new UserValidationException();
        }
    }

}
