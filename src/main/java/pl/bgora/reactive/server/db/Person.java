package pl.bgora.reactive.server.db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Person {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private List<Vacation> vacations;
}
