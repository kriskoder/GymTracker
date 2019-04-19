package pl.coderslab.app.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.exercise.Exercise;
import pl.coderslab.app.exercise.ExerciseRepository;
import pl.coderslab.app.history.History;
import pl.coderslab.app.history.HistoryRepository;
import pl.coderslab.app.user.User;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/training")
@SessionAttributes("training")
public class TrainingController {
    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    ExerciseRepository exerciseRepository;
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

    @PostMapping("/create")
    public String createTrainingStep1(Model model, @RequestParam("trainingName") String name, HttpSession session) {
        Training training = new Training();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String created = LocalDateTime.now().format(formatter);
        training.setUser((User)session.getAttribute("userSession"));
        training.setName(name);
        training.setCreated(created);
        trainingRepository.save(training);
        model.addAttribute("training", training);
        return "redirect:add";
    }

    @ModelAttribute("exerciseList")
    public List<Exercise> exerciseList() {
        return exerciseRepository.findAll();
    }
}
