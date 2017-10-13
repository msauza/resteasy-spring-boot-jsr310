package jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Path("/jsr310")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Service
@Slf4j
public class DateTimeService {

    @GET
    public Dates now() {
        log.info("GET now");
        Dates dates = Dates.builder()//
                .localDate(LocalDate.now())//
                .localDateTime(LocalDateTime.now())//
                .localDateTimeUTC(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime())//
                .offsetDateTime(OffsetDateTime.now())//
                .offsetDateTimeUTC(ZonedDateTime.now(ZoneOffset.UTC).toOffsetDateTime())//
                .build();
        return dates;
    }

    @POST
    public void now(Dates dates) {

        log.info("POST now {}", dates);
    }
}