package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaEsercizi;
import mariangelamarasciuolo.Palestra.payloads.SchedaEserciziDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaEserciziRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchedaEserciziService {
    @Autowired
    private SchedaEserciziRepository schedaEserciziRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public SchedaEsercizi saveSchedaEsercizi(SchedaEserciziDTO body) throws IOException {

        SchedaEsercizi newSchedaEsercizi = new SchedaEsercizi();
        newSchedaEsercizi.setDataSchedaEsercizi(body.dataSchedaEsercizi());
        newSchedaEsercizi.setNomeSchedaEsercizi(body.nomeSchedaEsercizi());
        newSchedaEsercizi.setDescrizione(body.descrizione());
        //newSchedaEsercizi.setUtente(utenteRepository.findById(body.utente_id()).get());
        return schedaEserciziRepository.save(newSchedaEsercizi);
    }
}
