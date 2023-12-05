package mariangelamarasciuolo.Palestra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mariangelamarasciuolo.Palestra.Enum.Ruolo;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    private SchedaAnagrafica schedaAnagrafica;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    private SchedaPalestra schedaPalestra;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<SchedaEsercizi> schedeEsercizi;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Iscrizione> iscrizioni;

    public Utente(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }

}
