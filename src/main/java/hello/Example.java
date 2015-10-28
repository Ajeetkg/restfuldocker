package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@RestController
public class Example {

    @Value( "${hello.value:World}" )
    private String greetings;

    @RequestMapping("/example")
    String home() {
        return "Hello " + greetings;
    }

}