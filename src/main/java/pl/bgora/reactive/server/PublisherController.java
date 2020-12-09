package pl.bgora.reactive.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

@RestController
public class PublisherController {

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Integer> getData() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        return Flux.fromIterable(list);
    }

}
