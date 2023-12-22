package mariangelamarasciuolo.Palestra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schede_salute")
public class SchedaSalute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSchedaSalute;
    private String patologie;
    private String note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "scheda_palestra_id")
    private SchedaPalestra schedaPalestra;
}

