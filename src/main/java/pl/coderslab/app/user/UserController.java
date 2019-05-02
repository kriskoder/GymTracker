package pl.coderslab.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.training.TrainingService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    TrainingService trainingService;

    @RequestMapping("")
    public String userHome(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("lastTrainings", trainingService.getLast3TrainingsByUserId(user.getId()));
        return "userHome";
    }
}