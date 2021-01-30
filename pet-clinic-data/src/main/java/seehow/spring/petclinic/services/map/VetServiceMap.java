package seehow.spring.petclinic.services.map;

import org.springframework.stereotype.Service;
import seehow.spring.petclinic.model.Speciality;
import seehow.spring.petclinic.model.Vet;
import seehow.spring.petclinic.services.SpecialityService;
import seehow.spring.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object == null) {
            return null;
        }
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality saved = specialityService.save(speciality);
                    speciality.setId(saved.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}