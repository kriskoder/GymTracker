package pl.coderslab.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

//
//    public void save(History history) {
//        historyRepository.save(history);
//    }

}
