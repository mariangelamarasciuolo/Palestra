package mariangelamarasciuolo.Palestra.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "schedaPalestra", cascade = CascadeType.ALL)
    private List<SchedaEsercizi> schedaEsercizi;

    @OneToMany(mappedBy = "schedaPalestra", cascade = CascadeType.ALL)
    private List<SchedaSalute> schedaSalute;

    @OneToOne(mappedBy = "schedaPalestra", cascade = CascadeType.ALL)
    private Iscrizione iscrizione;
}