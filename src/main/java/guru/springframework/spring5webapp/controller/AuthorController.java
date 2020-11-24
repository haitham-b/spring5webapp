package guru.springframework.spring5webapp.controller;


import guru.springframework.spring5webapp.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());
        return "authorList";
    }
}
