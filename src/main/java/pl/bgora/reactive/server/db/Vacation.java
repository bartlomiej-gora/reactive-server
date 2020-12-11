package pl.bgora.reactive.server.db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Vacation {

    @Id
    private String id;

    private Integer totalVacation;

    private Integer usedVacation;
}

