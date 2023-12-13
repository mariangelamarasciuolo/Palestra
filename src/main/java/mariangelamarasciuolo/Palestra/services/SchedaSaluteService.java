package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaSalute;
import mariangelamarasciuolo.Palestra.payloads.SchedaSaluteDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
import mariangelamarasciuolo.Palestra.repositories.SchedaSaluteRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchedaSaluteService {
    @Autowired
    private SchedaSaluteRepository schedaSaluteRepository;

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;


    public SchedaSalute saveSchedaSalute(SchedaSaluteDTO body) throws IOException {

        SchedaSalute newSchedaSalute = new SchedaSalute();
        newSchedaSalute.setDataSchedaSalute(body.dataSchedaSalute());
        newSchedaSalute.setPatologie(body.patologie());
        newSchedaSalute.setNote(body.note());
        newSchedaSalute.setSchedaPalestra(schedaPalestraRepository.findById(body.schedaPalestra_id()).get());
        return schedaSaluteRepository.save(newSchedaSalute);
    }
}
