package pl.ksiegarnia.validators;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import pl.ksiegarnia.exceptions.UserValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserVAlidator {


    public static void validateLogin(String login){
        String regex = "^[a-zA-Z0-9]{5,}$";

        if(!login.matches(regex)){
            throw new UserValidationException();
        }
    }

    public static void validatePassword(String password){
        String regex = "^[a-zA-Z0-9]{5,}$";
        if(!password.matches(regex)){
            throw new UserValidationException();
        }
    }

}
