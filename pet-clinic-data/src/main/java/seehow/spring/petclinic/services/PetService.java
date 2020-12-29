package seehow.spring.petclinic.services;

import seehow.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);

    Set<Pet> findAll();
}
