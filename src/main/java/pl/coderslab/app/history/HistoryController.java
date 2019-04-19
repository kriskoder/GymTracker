package pl.coderslab.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.training.TrainingRepository;
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



    @GetMapping("/progress/{id}")
    public String findProgress(Model model, HttpSession session, @PathVariable Long id){
        User user = (User)session.getAttribute("userSession");
        List<History> historyList = historyRepository.findHistoryByUserIdAndExerciseIdOrderByTrainingDesc(user.getId(), id);
        History history = historyRepository.findTopHistoryByUserIdAndExerciseIdOrderByWeightDesc(user.getId(), id);
        History history2 = historyRepository.findTopHistoryByUserIdAndExerciseIdOrderByWeightAsc(user.getId(), id);
        String exerciseName = exerciseRepository.findById(id).orElse(null).getName();
        model.addAttribute("progress", historyList);
        model.addAttribute("max", history);
        model.addAttribute("min", history2);
        model.addAttribute("exerciseName", exerciseName);
        return "progress";
    }

    @GetMapping("/{id}")
    private String userHistory(HttpSession session, Model model, @PathVariable Long id) {
        User user = (User) session.getAttribute("userSession");
        List<History> history = historyRepository.findHistoryByUserIdAndAndTrainingId(user.getId(), id);
        if(history.isEmpty()){
            return "redirect:../user";
        }
        Training training = trainingRepository.findById(id).orElse(null);
        model.addAttribute("trainingName", training.getName());
        model.addAttribute("historyList", history);
        model.addAttribute("user", user);
        return "userHistory";
    }


    @ModelAttribute("userList")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @ModelAttribute("trainingList")
    public List<Training> trainingList(){
        return trainingRepository.findAll();
    }
}
