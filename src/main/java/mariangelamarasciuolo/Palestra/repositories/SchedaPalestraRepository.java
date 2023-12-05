package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchedaPalestraRepository extends PagingAndSortingRepository<SchedaPalestra, Long> {
}
