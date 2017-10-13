package jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("datetime")
@Slf4j
public class DateTimeController {

    @GetMapping("/jsr310")
    public ResponseEntity<Dates> now() {

        log.info("GET now");
        Dates body = Dates.builder()//
                .localDate(LocalDate.now())//
                .localDateTime(LocalDateTime.now())//
                .localDateTimeUTC(LocalDateTime.now(ZoneOffset.UTC))//
                .offsetDateTime(OffsetDateTime.now())//
                .offsetDateTimeUTC(OffsetDateTime.now(ZoneOffset.UTC))//
                .build();
        return ResponseEntity.ok(body);
    }

    @PostMapping("/jsr310")
    public void now(@RequestBody Dates dates) {

        log.info("POST now {}", dates);
    }
}
