package tnmk.el.service.historyevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tnmk.el.service.historyevent.model.HistoryEvent;

import java.util.List;

/**
 * @author khoi.tran on 9/20/16.
 */
@Service
public class HistoryEventService {
    private final HistoryEventRepository historyEventRepository;

    @Autowired
    public HistoryEventService(HistoryEventRepository historyEventRepository) {this.historyEventRepository = historyEventRepository;}

    public HistoryEvent save(HistoryEvent historyEvent) {
        return historyEventRepository.save(historyEvent);
    }

    public List<HistoryEvent> findAll() {
        return historyEventRepository.findAll();
    }
}
