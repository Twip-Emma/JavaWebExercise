import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {
    ApplicationContext ct = new AnnotationConfigApplicationContext(Config.class);
}
