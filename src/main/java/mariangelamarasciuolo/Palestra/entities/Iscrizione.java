package mariangelamarasciuolo.Palestra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mariangelamarasciuolo.Palestra.Enum.Abbonamento;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "iscrizioni")
public class Iscrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_iscrizione")
    private LocalDate dataIscrizione;
    @Column(name = "data_Scadenza")
    private LocalDate dataScadenza;
    @Column(name = "pagamento_effettuato")
    private boolean pagamentoEffettuato;

    @Enumerated(EnumType.STRING)
    private Abbonamento abbonamento;

    @ManyToOne
    @JoinColumn(name = "scheda_palestra_id")
    private SchedaPalestra schedaPalestra;


    public Iscrizione(LocalDate dataIscrizione, LocalDate dataScadenza, boolean pagamentoEffettuato) {
        this.dataIscrizione = dataIscrizione;
        this.dataScadenza = dataScadenza;
        this.pagamentoEffettuato = pagamentoEffettuato;
    }

    public Iscrizione() {
        
    }
}
