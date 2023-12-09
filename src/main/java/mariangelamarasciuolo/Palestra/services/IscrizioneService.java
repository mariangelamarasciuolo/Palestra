package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.Enum.Abbonamento;
import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import mariangelamarasciuolo.Palestra.payloads.IscrizioneDTO;
import mariangelamarasciuolo.Palestra.repositories.IscrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IscrizioneService {
    @Autowired
    private IscrizioneRepository iscrizioneRepository;

    public Iscrizione saveIscrizione(IscrizioneDTO body) throws IOException {
        Iscrizione newIscrizione = new Iscrizione();
        newIscrizione.setDataIscrizione(body.dataIscrizione());
        newIscrizione.setDataScadenza(body.dataScadenza());
        newIscrizione.setPagamentoEffettuato(body.pagamentoEffettuato());
        newIscrizione.setAbbonamento(Abbonamento.ANNUALE);

        return iscrizioneRepository.save(newIscrizione);
    }
}
