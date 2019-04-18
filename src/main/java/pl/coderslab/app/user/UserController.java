package pl.coderslab.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.training.TrainingRepository;
import pl.coderslab.app.history.History;
import pl.coderslab.app.history.HistoryRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @RequestMapping("/{id}")
    public String userHome(@PathVariable Long id, Model model) {
        User user = userService.findUserbyId(id);
        List<Training> trainingList = trainingRepository.findAllByUserIdOrderByCreatedDesc(user.getId());
        model.addAttribute("lastTrainings", trainingList);
        model.addAttribute("userSession", user);
        return "userHome";
    }

    @GetMapping("/add")
    public String addUserStep1(Model model) {
        model.addAttribute("user", new User());
        return "userAdd";
    }

    @PostMapping("/add")
    public String addUserStep2(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userAdd";
        }
        userService.createUser(user);
        return "userAdd";
    }

    @GetMapping("/history/{id}")
    private String userHistory(HttpSession session, Model model, @PathVariable Long id) {
        User user = (User) session.getAttribute("userSession");
        List<History> history = historyRepository.findAllByTrainingId(id);
        Training training = trainingRepository.findById(id).orElse(null);
        model.addAttribute("trainingName", training.getName());
        model.addAttribute("historyList", history);
        model.addAttribute("user", user);
        return "userHistory";
    }

    @GetMapping("/record")
    public String addRecord() {
        return "redirect:../history/add";
    }

    @PostMapping("/training")
    public String createTrainingStep1(Model model, @RequestParam("trainingName") String name, HttpSession session) {
        Training training = new Training();
        training.setUser((User) session.getAttribute("userSession"));
        training.setName(name);
        model.addAttribute("training", training);
        trainingRepository.save(training);
        return "redirect:../history/add";
    }
}