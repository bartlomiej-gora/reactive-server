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

    @GetMapping(value = "/data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getData() {
        List<String> list = List.of("Adam", "Bartek", "Patryk", "Kamil", "Krzysztof", "Patryk");
        return Flux.fromIterable(list).delayElements(Duration.of(2, SECONDS));
    }

}
