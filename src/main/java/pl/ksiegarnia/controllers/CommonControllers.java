package pl.ksiegarnia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ksiegarnia.database.IBookDAO;
import pl.ksiegarnia.model.Book;

import java.util.List;

@Controller
public class CommonControllers {

    @Autowired
    IBookDAO bookDao;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {

        return "redirect:/";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main2(Model model){
        List<Book> books = this.bookDao.getBooks();
        model.addAttribute("books", books);
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String main(Model model, @RequestParam String pattern) {

        List<Book> books = this.bookDao.getBooksByPattern(pattern);
        model.addAttribute("books", books);

        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }
}
