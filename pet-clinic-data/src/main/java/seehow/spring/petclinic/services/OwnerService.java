package seehow.spring.petclinic.services;

import seehow.spring.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
