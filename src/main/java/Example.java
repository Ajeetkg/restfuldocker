import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("restfuldocker")
public class Example {

    @Value( "${hello.value:World}" )
    private String greetings;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello " + greetings;
    }

}