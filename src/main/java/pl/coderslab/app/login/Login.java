package pl.coderslab.app.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;

@Controller
@RequestMapping("/login")
@SessionAttributes("userSession")
public class Login {

    private UserService userService;

    public Login(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public String loginStep1() {
        return "login";
    }

    @PostMapping
    public String loginStep2(@RequestParam("userEmail") String email, @RequestParam("userPassword") String password, Model model) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return "login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            model.addAttribute("userSession", user);
            return "redirect:/user";
        }
        return "login";
    }
}
