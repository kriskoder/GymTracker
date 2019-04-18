package pl.coderslab.app.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ExerciseConverter implements Converter<String, Exercise> {
    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public Exercise convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return exerciseRepository.findById(id).orElse(null);
    }
}
