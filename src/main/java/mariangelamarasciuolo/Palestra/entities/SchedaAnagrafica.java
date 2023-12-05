package mariangelamarasciuolo.Palestra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schede_anagrafiche")
public class SchedaAnagrafica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String indirizzo;
    private String citta;
    private String cap;
    private String nazionalita;
    private String telefonoFisso;
    private String telefonoMobile;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
}
