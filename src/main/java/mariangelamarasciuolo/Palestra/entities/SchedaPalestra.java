package mariangelamarasciuolo.Palestra.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schede_palestra")
public class SchedaPalestra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDiNascita;
    private String sesso;
    private double altezza;
    private double peso;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
}