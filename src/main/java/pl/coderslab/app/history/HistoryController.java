package pl.coderslab.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.exercise.ExerciseService;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.training.TrainingService;
import pl.coderslab.app.user.User;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    TrainingService trainingService;


    @GetMapping("/progress/{id}")
    public String findProgress(Model model, HttpSession session, @PathVariable Long id) {
        User user = (User) session.getAttribute("userSession");
        model.addAttribute("progress", historyService.getExerciseHistory(user.getId(), id));
        model.addAttribute("max", historyService.getMaxRestult(user.getId(), id));
        model.addAttribute("min", historyService.getMinResult(user.getId(), id));
        model.addAttribute("exerciseName", exerciseService.getExerciseNameById(id));
        return "progress";
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
        return "userHistory";
    }
}
