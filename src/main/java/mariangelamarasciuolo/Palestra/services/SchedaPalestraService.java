package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import mariangelamarasciuolo.Palestra.payloads.SchedaPalestraDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchedaPalestraService {
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public SchedaPalestra saveSchedaPalestra(SchedaPalestraDTO body) throws IOException {

        SchedaPalestra newSchedaPalestra = new SchedaPalestra();
        newSchedaPalestra.setDataDiNascita(body.dataDiNascita());
        newSchedaPalestra.setSesso(body.sesso());
        newSchedaPalestra.setAltezza(body.altezza());
        newSchedaPalestra.setPeso(body.peso());
        newSchedaPalestra.setUtente(utenteRepository.findById(body.utente_id()).get());
        return schedaPalestraRepository.save(newSchedaPalestra);
    }
}
