package jsr310;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return (jacksonObjectMapperBuilder) -> {
            jacksonObjectMapperBuilder//
                    .findModulesViaServiceLoader(true)//
                    .indentOutput(true)//
                    .modules(new JavaTimeModule(), new Jdk8Module())//
                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);//
        };
    }
}
