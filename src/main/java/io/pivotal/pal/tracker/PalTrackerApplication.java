package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class PalTrackerApplication {


    private Map<Long, TimeEntry> timeEntryMap=new HashMap<>();



    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public TimeEntryRepository getTimeEntryRepository()
    {
        /*return new TimeEntryRepository() {
            @Override
            public TimeEntry create(TimeEntry timeEntry) {
                 timeEntry=new TimeEntry(1L,123L,456L,LocalDate.parse("2017-01-08"), 8);
                timeEntryMap.put(Long.valueOf(1),timeEntry);
                 return timeEntry;
            }

            @Override
            public TimeEntry find(long id) {
                return timeEntryMap.get(Long.valueOf(id));
            }

            @Override
            public List<TimeEntry> list() {

           return  timeEntryMap.values().stream().collect(Collectors.toList());


            }

            @Override
            public TimeEntry update(long id, TimeEntry timeEntry) {
                timeEntryMap.put(Long.valueOf(id),timeEntry);
                return timeEntryMap.get(Long.valueOf(id));
            }

            @Override
            public void delete(long id) {
                timeEntryMap.remove(Long.valueOf(id));

            }
        };*/
        return new InMemoryTimeEntryRepository();
    }
}
