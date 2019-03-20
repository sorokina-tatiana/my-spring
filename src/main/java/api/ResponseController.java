package api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResponseController {

    private static final String templateGoodbye = "Goodbye, %s!";
    private static final String templateGreeting = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/goodbye")
    public Response goodbye(@RequestParam(value = "name", defaultValue = "pretty" ) String name, @RequestParam(value = "surname", defaultValue = "World" ) String surname) {
        return new Response(counter.incrementAndGet(),
                String.format(templateGoodbye, name + " " + surname));
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Response greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Response(counter.incrementAndGet(),
                String.format(templateGreeting, name));
    }
}
