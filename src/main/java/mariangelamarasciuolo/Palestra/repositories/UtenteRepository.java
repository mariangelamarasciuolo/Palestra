package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.Utente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UtenteRepository extends PagingAndSortingRepository<Utente, Long> {
}
