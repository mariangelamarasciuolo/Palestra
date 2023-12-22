package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaEsercizi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedaEserciziRepository extends JpaRepository<SchedaEsercizi, Long> {
}
