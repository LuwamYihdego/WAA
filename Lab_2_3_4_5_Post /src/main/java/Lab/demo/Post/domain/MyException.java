package Lab.demo.Post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyException {
@Id
    LocalDate date;
    int time;
    String principle;
    String operation;
    String exceptionType;
}
