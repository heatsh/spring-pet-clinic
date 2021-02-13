package seehow.spring.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import seehow.spring.petclinic.model.Owner;
import seehow.spring.petclinic.repositories.OwnerRepository;
import seehow.spring.petclinic.repositories.PetRepository;
import seehow.spring.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(new Owner());
        owners.add(new Owner());
        when(ownerRepository.findAll()).thenReturn(owners);
        assertEquals(2, ownerSDJpaService.findAll().size());
    }

    @Test
    void findById() {
        Long ownerId = 1L;

        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(new Owner()));

        assertNull(ownerSDJpaService.findById(10L));
        assertNotNull(ownerSDJpaService.findById(ownerId));
        verify(ownerRepository).findById(ownerId);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(new Owner());
        assertNotNull(ownerSDJpaService.save(new Owner()));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(new Owner());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        Long id = 2L;
        ownerSDJpaService.deleteById(id);
        verify(ownerRepository).deleteById(id);
    }

    @Test
    void findByLastName() {
        String lastName = "smith";

        when(ownerRepository.findByLastName(any())).thenReturn(null);
        when(ownerRepository.findByLastName(lastName)).thenReturn(new Owner());

        assertNull(ownerSDJpaService.findByLastName("unknown"));
        verify(ownerRepository).findByLastName("unknown");

        assertNotNull(ownerSDJpaService.findByLastName(lastName));
        verify(ownerRepository).findByLastName(lastName);
    }
}