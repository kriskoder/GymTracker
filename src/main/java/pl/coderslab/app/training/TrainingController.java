package pl.coderslab.app.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.exercise.Exercise;
import pl.coderslab.app.exercise.ExerciseService;
import pl.coderslab.app.history.History;
import pl.coderslab.app.history.HistoryService;
import pl.coderslab.app.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/training")
@SessionAttributes("training")
public class TrainingController {

    private HistoryService historyService;
    private ExerciseService exerciseService;
    private TrainingService trainingService;

    public TrainingController(HistoryService historyService, ExerciseService exerciseService, TrainingService trainingService) {
        this.historyService = historyService;
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
    }

    @RequestMapping("")
    public String userHome(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        model.addAttribute("lastTrainings", trainingService.getAllUserTrainings(user.getId()));
        return "history/historyList";
    }

    @GetMapping("/add")
    public String addRecordStep1(Model model) {
        model.addAttribute("history", new History());
        return "history/historyAdd";
    }

    @PostMapping("/add")
    public String addRecordStep2(@ModelAttribute History history, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        Training training = (Training) session.getAttribute("training");
        historyService.create(history, training, user);
        return "redirect:add";
    }

    @PostMapping("/create")
    public String createTrainingStep1(Model model, @RequestParam("trainingName") String name, HttpSession session) {
        Training training = trainingService.create((User) session.getAttribute("userSession"), name);
        model.addAttribute("training", training);
        return "redirect:add";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainingById(@PathVariable Long id){
        historyService.deleteHistoryByTraining(id);
        return "redirect:/training";
    }

    @ModelAttribute("exerciseList")
    public List<Exercise> exerciseList() {
        return exerciseService.findAll();
    }
}
