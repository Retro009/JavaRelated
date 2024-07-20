package StreamsAndLambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;
    private double salary;
    private String department;
    private LocalDate hiringDate;
}
