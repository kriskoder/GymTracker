package pl.coderslab.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.training.TrainingRepository;
import pl.coderslab.app.exercise.Exercise;
import pl.coderslab.app.exercise.ExerciseRepository;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @GetMapping("/add")
    public String addRecordStep1(Model model, HttpSession session) {
        model.addAttribute("user", (User) session.getAttribute("userSession"));
        model.addAttribute("history", new History());
        return "historyAdd";
    }

    @PostMapping("/add")
    public String addRecordStep2(@ModelAttribute History history, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        history.setTraining((Training) session.getAttribute("training"));
        history.setUser(user);
        historyRepository.save(history);
        return "redirect:add";
    }

    @GetMapping("/progress/{id}")
    public String findProgress(Model model, HttpSession session, @PathVariable Long id){
        User user = (User)session.getAttribute("userSession");
        List<History> historyList = historyRepository.findProgress(user.getId(), id);

        model.addAttribute("progress", historyList);
        return "progress";
    }

    @ModelAttribute("userList")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @ModelAttribute("exerciseList")
    public List<Exercise> exerciseList() {
        return exerciseRepository.findAll();
    }

    @ModelAttribute("trainingList")
    public List<Training> trainingList(){
        return trainingRepository.findAll();
    }
}
