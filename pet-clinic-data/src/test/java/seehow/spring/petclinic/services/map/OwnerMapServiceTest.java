package seehow.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seehow.spring.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerId, ownerMapService.findById(ownerId).getId());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        String lastName = "smith";
        assertNull(ownerMapService.findByLastName(lastName));

        Owner smith = new Owner();
        smith.setLastName(lastName);
        ownerMapService.save(smith);
        assertNotNull(ownerMapService.findByLastName(lastName));
    }
}