package mariangelamarasciuolo.Palestra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schede_esercizi")
public class SchedaEsercizi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSchedaEsercizi;
    private String nomeSchedaEsercizi;
    private String descrizione;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "scheda_palestra_id")
    private SchedaPalestra schedaPalestra;

}
