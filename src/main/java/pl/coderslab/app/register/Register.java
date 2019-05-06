package pl.coderslab.app.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class Register {

    private UserService userService;

    public Register(UserService userService ){
        this.userService = userService;
    }


    @GetMapping("")
    public String addUserStep1(@Valid Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("")
    public String addUserStep2(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User userToCheck = userService.findByEmail(user.getEmail());
        if(userToCheck != null){
            return "redirect:/register";
        }
        userService.createUser(user);
        return "redirect:login";
    }
}
