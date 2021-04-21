package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @Autowired
    private TimeEntryRepository timeEntryRepository;



    @PostMapping()
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntryRepository.create(timeEntry));
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId,@RequestBody TimeEntry timeEntry) {
        TimeEntry timeEnt=timeEntryRepository.update(timeEntryId,timeEntry);
        if(timeEnt==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(timeEnt);
    }
    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry=timeEntryRepository.find(timeEntryId);
        if(timeEntry==null)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(timeEntry);
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(timeEntryRepository.list());
    }
}
