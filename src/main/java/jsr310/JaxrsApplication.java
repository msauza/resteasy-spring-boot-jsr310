package jsr310;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/datetime-api")
public class JaxrsApplication extends Application {
}
