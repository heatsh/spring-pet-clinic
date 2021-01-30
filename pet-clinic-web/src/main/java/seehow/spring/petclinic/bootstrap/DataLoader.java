package seehow.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import seehow.spring.petclinic.model.Owner;
import seehow.spring.petclinic.model.Pet;
import seehow.spring.petclinic.model.PetType;
import seehow.spring.petclinic.model.Vet;
import seehow.spring.petclinic.services.PetTypeService;
import seehow.spring.petclinic.services.VetService;
import seehow.spring.petclinic.services.OwnerService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Road");
        owner1.setCity("city 1");
        owner1.setTelephone("12345678");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glename");
        owner2.setAddress("123 Road");
        owner2.setCity("city 1");
        owner2.setTelephone("12345678");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just cat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Test");
        vet1.setLastName("1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Test");
        vet2.setLastName("2");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Test");
        vet3.setLastName("3");
        vetService.save(vet3);
    }
}
