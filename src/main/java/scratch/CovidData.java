package scratch;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CovidData {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ltla_name;
    private String ltla_code;
    private LocalDate start_date;
    private LocalDate end_date;
    private String dose;
    private String age;
    private int vaccines;
    private int population;
    private float percentage_vaccine;


    // Default Constructor
    public CovidData(String ltla_name, String ltla_code, LocalDate start_date, LocalDate end_date, String dose, String age, int vaccines, int population, double percentage_vaccine) {
    }

    public void setId(Long id) {
        this.id = id;
    }

}
