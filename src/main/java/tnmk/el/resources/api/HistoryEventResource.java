package tnmk.el.resources.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.service.historyevent.HistoryEventService;
import tnmk.el.service.historyevent.model.HistoryEvent;

import java.util.List;

@RestController
public class HistoryEventResource {

    private final HistoryEventService historyEventService;

    @Autowired
    public HistoryEventResource(HistoryEventService historyEventService) {this.historyEventService = historyEventService;}

    @RequestMapping(value = "/history-events", method = RequestMethod.GET)
    public List<HistoryEvent> getHistoryEvents() {
        return historyEventService.findAll();
    }

    @RequestMapping(value = "/history-events", method = RequestMethod.POST)
    public HistoryEvent save(HistoryEvent historyEvent) {
        return historyEventService.save(historyEvent);
    }
}