package pl.coderslab.app.training;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.core.convert.converter.Converter;

public class TrainingConverter implements Converter<String, Training> {
    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public Training convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return trainingRepository.findById(id).orElse(null);
    }
}
