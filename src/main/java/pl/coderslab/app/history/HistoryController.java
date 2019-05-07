package pl.coderslab.app.history;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.exercise.ExerciseService;
import pl.coderslab.app.training.TrainingService;
import pl.coderslab.app.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private  HistoryService historyService;
    private  ExerciseService exerciseService;
    private  TrainingService trainingService;

    public HistoryController(HistoryService historyService, ExerciseService exerciseService, TrainingService trainingService) {
        this.historyService = historyService;
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
    }

    @GetMapping("/progress/{id}")
    public String findProgress(Model model, HttpSession session, @PathVariable Long id) {
        User user = (User) session.getAttribute("userSession");
        model.addAttribute("progress", historyService.getExerciseHistory(user.getId(), id));
        model.addAttribute("max", historyService.getMaxRestult(user.getId(), id));
        model.addAttribute("min", historyService.getMinResult(user.getId(), id));
        model.addAttribute("exerciseName", exerciseService.getExerciseNameById(id));
        return "history/historyProgress";
    }

    @GetMapping("/{id}")
    private String userHistory(HttpSession session, Model model, @PathVariable Long id) {
        User user = (User) session.getAttribute("userSession");
        List<History> history = historyService.getUserHistory(user.getId(), id);
        if (history.isEmpty()) {
            return "redirect:../user";
        }
        model.addAttribute("trainingName", trainingService.getTrainingName(id));
        model.addAttribute("historyList", history);
        return "user/userHistory";
    }
}
