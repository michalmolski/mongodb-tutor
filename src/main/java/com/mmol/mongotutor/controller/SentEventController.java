package com.mmol.mongotutor.controller;

import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = "/api")
public class SentEventController {

    EventService eventService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> getEventsHistory(@RequestBody Event event)  {
        eventService.saveEvent(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/find")
    public ResponseEntity<String> getEventById(@RequestParam Long eventId)  {
        SentEventTable eventTable = eventService.getEvent(eventId);
        return ResponseEntity.ok(eventTable.toString());
    }

    @PutMapping(value = "/populate")
    public ResponseEntity<String> polupateMongoDb(@RequestParam Integer numberOfRecords)  {
        String response = eventService.saveRandomEvents(numberOfRecords);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/find-mongo")
    public ResponseEntity<?> getEventVoivodeshipFromMongo(@RequestParam String voivodeship)  {
        eventService.getEventByVoivodeMongo(voivodeship);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/find-pg")
    public ResponseEntity<?> getEventVoivodeshipFromPg(@RequestParam String voivodeship)  {
        eventService.getEventByVoivodePg(voivodeship);
        return ResponseEntity.ok().build();
    }
}
