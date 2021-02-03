package seehow.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seehow.spring.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
