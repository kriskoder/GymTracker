package pl.coderslab.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.training.TrainingRepository;
import pl.coderslab.app.history.HistoryRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("user")
@SessionAttributes({"userSession", "training"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @RequestMapping("")
    public String userHome(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        List<Training> trainingList = trainingRepository.findFirst3ByUserIdOrderByCreatedDesc(user.getId());
        model.addAttribute("lastTrainings", trainingList);
        return "userHome";
    }


}