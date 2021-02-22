package seehow.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seehow.spring.petclinic.model.Owner;
import seehow.spring.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {
    PetMapService petMapService;
    Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(1L).build());
        petMapService.save(Pet.builder().id(2L).build());
    }

    @Test
    void findAll() {
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(petId, petMapService.findById(petId).getId());
    }

    @Test
    void save() {
        Long id = 3L;
        Pet newPet = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(newPet);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        assertEquals(1, petMapService.findAll().size());
    }
}