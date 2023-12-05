package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IscrizioneRepository extends PagingAndSortingRepository<Iscrizione, Long> {
}
