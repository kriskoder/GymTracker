package pl.coderslab.app.exercise;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("exercise")
public class ExerciseController {
    
   private  ExerciseService exerciseService;
   
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    private String addExerciseStep1(Model model){
        model.addAttribute("exercise", new Exercise());
        return "exerciseAdd";
    }

    @PostMapping("/add")
    private String addExerciseStep2(@ModelAttribute @Valid Exercise exercise, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "exerciseAdd";
        }
        exerciseService.create(exercise);
        return "exerciseAdd";
    }

    @RequestMapping("/list")
    public String exerciseList(Model model){
        model.addAttribute("exerciseList", exerciseService.findAll());
        return "exerciseList";
    }
}
