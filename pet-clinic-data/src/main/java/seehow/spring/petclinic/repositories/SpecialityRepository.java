package seehow.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import seehow.spring.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
