package jsr310;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Jsr310App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class Jsr310AppTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRestControllerNow() {

        ResponseEntity<JsonNode> forEntity = this.restTemplate.getForEntity("/datetime/jsr310", JsonNode.class);
        assertions(forEntity.getStatusCode(), forEntity.getBody());
    }

    @Test
    public void testRestEasyNow() {

        ResponseEntity<JsonNode> forEntity = this.restTemplate.getForEntity("/datetime-api/jsr310", JsonNode.class);
        assertions(forEntity.getStatusCode(), forEntity.getBody());
    }

    private void assertions(HttpStatus httpStatus, JsonNode jsonNode) {

        System.out.println(jsonNode);
        assertThat(StringUtils.startsWithIgnoreCase(jsonNode.get("localDate").textValue(), LocalDate.now().toString()))
                .isTrue();
        assertThat(
                StringUtils.startsWithIgnoreCase(jsonNode.get("localDateTime").textValue(), LocalDate.now().toString()))
                        .isTrue();
        assertThat(StringUtils.startsWithIgnoreCase(jsonNode.get("offsetDateTime").textValue(),
                LocalDate.now().toString())).isTrue();
        assertThat(httpStatus).isEqualTo(HttpStatus.OK);
    }
}
