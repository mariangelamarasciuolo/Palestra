package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaEsercizi;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.payloads.SchedaEserciziDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaEserciziRepository;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
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
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;

    public SchedaEsercizi saveSchedaEsercizi(SchedaEserciziDTO body) throws IOException {

        SchedaEsercizi newSchedaEsercizi = new SchedaEsercizi();
        newSchedaEsercizi.setDataSchedaEsercizi(body.dataSchedaEsercizi());
        newSchedaEsercizi.setNomeSchedaEsercizi(body.nomeSchedaEsercizi());
        newSchedaEsercizi.setDescrizione(body.descrizione());
        newSchedaEsercizi.setSchedaPalestra(schedaPalestraRepository.findById(body.schedaPalestra_id()).get());
        return schedaEserciziRepository.save(newSchedaEsercizi);
    }

    public SchedaEsercizi findByIdSchedaEsercizi(long idSchedaEsercizi) throws NotFoundException {
        return schedaEserciziRepository.findById(idSchedaEsercizi).orElseThrow(() -> new NotFoundException(idSchedaEsercizi));
    }

    public SchedaEsercizi updateSchedaEserciziById(long idSchedaEsercizi, SchedaEserciziDTO body) {
        SchedaEsercizi schedaEsercizi = schedaEserciziRepository.findById(idSchedaEsercizi).orElseThrow(() -> new RuntimeException("Scheda esercizi non trovata"));
        schedaEsercizi.setNomeSchedaEsercizi(body.nomeSchedaEsercizi());
        schedaEsercizi.setDataSchedaEsercizi(body.dataSchedaEsercizi());
        schedaEsercizi.setDescrizione(body.descrizione());
        return schedaEserciziRepository.save(schedaEsercizi);
    }

    public void deleteSchedaEserciziById(long id) {
        SchedaEsercizi schedaEsercizi = schedaEserciziRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        schedaEserciziRepository.delete(schedaEsercizi);
    }
}
