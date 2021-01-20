package seehow.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import seehow.spring.petclinic.model.Owner;
import seehow.spring.petclinic.model.Vet;
import seehow.spring.petclinic.services.VetService;
import seehow.spring.petclinic.services.OwnerService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glename");
        owner1.setId(1L);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setId(2L);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Test");
        vet1.setLastName("1");
        vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Test");
        vet2.setLastName("2");
        vet2.setId(2L);
        vetService.save(vet2);
    }
}
