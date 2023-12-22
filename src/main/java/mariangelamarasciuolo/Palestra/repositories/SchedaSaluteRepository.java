package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaSalute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedaSaluteRepository extends JpaRepository<SchedaSalute, Long> {
}
