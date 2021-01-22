package pl.bgora.reactive.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.bgora.reactive.server.db.Person;
import pl.bgora.reactive.server.db.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PublisherController {

    private final PersonRepository personRepository;

    public PublisherController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Integer> getData() {
        return Flux.range(1, 1024);
    }

    @PostMapping(value = "/person")
    public Mono<Person> addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping(value="/person/{id}")
    public Mono<Person> getONe(@PathVariable String id){
        return personRepository.findById(id);
    }

    @GetMapping(value="/sync/person/{id}")
    public Person getONeSync(@PathVariable String id){
        return personRepository.findById(id).block();
    }

    @GetMapping(value="person")
    public Flux<Person> getAll(){
        return personRepository.findAll();
    }
}
