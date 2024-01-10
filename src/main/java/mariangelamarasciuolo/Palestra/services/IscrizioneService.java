package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.Enum.Abbonamento;
import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.payloads.IscrizioneDTO;
import mariangelamarasciuolo.Palestra.repositories.IscrizioneRepository;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class IscrizioneService {
    @Autowired
    private IscrizioneRepository iscrizioneRepository;
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;

    public Iscrizione saveIscrizione(IscrizioneDTO body) throws IOException {
        System.out.println("prima service");
        Iscrizione newIscrizione = new Iscrizione();
        newIscrizione.setDataIscrizione(LocalDate.now());
        if (body.abbonamento().equals("MENSILE")) {
            newIscrizione.setDataScadenza(LocalDate.now().plusMonths(1));
        } else if (body.abbonamento().equals("SEMESTRALE")) {
            newIscrizione.setDataScadenza(LocalDate.now().plusMonths(6));
        } else if (body.abbonamento().equals("ANNUALE")) {
            newIscrizione.setDataScadenza(LocalDate.now().plusYears(1));
        } else {
            throw new BadRequestException("Non c'è nessun abbonamento");
        }

        newIscrizione.setPagamentoEffettuato(body.pagamentoEffettuato());
        newIscrizione.setSchedaPalestra(schedaPalestraRepository.findById(body.schedaPalestra_id()).get());
        newIscrizione.setAbbonamento(Abbonamento.valueOf(body.abbonamento()));
        System.out.println("dopo service");
        return iscrizioneRepository.save(newIscrizione);
    }

    public Iscrizione findByIdIscrizione(long idIscrizione) throws NotFoundException {
        return iscrizioneRepository.findById(idIscrizione).orElseThrow(() -> new NotFoundException(idIscrizione));
    }

    public List<Iscrizione> findByUtenteId(long idUtente) {
        return iscrizioneRepository.findByUtenteId(idUtente);
    }

    public Iscrizione updateIscrizioneById(long idIscrizione, IscrizioneDTO body) {
        Iscrizione iscrizione = iscrizioneRepository.findById(idIscrizione).orElseThrow(() -> new RuntimeException("Iscrizione non trovata"));
        iscrizione.setDataIscrizione(LocalDate.now());
        if (body.abbonamento().equals("MENSILE")) {
            iscrizione.setDataScadenza(LocalDate.now().plusMonths(1));
        } else if (body.abbonamento().equals("SEMESTRALE")) {
            iscrizione.setDataScadenza(LocalDate.now().plusMonths(6));
        } else if (body.abbonamento().equals("ANNUALE")) {
            iscrizione.setDataScadenza(LocalDate.now().plusYears(1));
        } else {
            throw new BadRequestException("Non c'è nessun abbonamento");
        }


        iscrizione.setAbbonamento(Abbonamento.valueOf(body.abbonamento()));
        iscrizione.setPagamentoEffettuato(body.pagamentoEffettuato());
        return iscrizioneRepository.save(iscrizione);
    }

    public void deleteIscrizioneById(long idIscrizione) {
        Iscrizione iscrizione = iscrizioneRepository.findById(idIscrizione).orElseThrow(() -> new NotFoundException(idIscrizione));
        iscrizioneRepository.delete(iscrizione);
    }
}
