package pl.coderslab.app.dateFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static String formatDate(LocalDateTime dateToFormat){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateToFormat.format(formatter);
    }
}
