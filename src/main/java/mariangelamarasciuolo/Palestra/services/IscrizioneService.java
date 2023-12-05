package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.repositories.IscrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IscrizioneService {
    @Autowired
    private IscrizioneRepository iscrizioneRepository;
}
