package seehow.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seehow.spring.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
