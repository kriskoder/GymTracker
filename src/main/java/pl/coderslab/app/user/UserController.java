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

    private TrainingService trainingService;

    public UserController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @RequestMapping("")
    public String userHome(Model model, HttpSession session) {
        final int MAX_TRAINING_NUMBER = 3;
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("lastTrainings", trainingService.getLastTrainingsByUserIdLimitMaxTrainingNumber(user.getId(), MAX_TRAINING_NUMBER));
        return "userHome";
    }
}