package seehow.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seehow.spring.petclinic.model.Owner;

public interface OnwerRepository extends CrudRepository<Owner, Long> {
}
