package seehow.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seehow.spring.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
