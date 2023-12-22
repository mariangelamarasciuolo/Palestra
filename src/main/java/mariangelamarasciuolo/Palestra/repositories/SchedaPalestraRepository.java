package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedaPalestraRepository extends JpaRepository<SchedaPalestra, Long> {
}
