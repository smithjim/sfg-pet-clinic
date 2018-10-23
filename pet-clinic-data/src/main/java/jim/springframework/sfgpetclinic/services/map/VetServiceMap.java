package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.constants.SpringProfiles;
import jim.springframework.sfgpetclinic.model.Speciality;
import jim.springframework.sfgpetclinic.model.Vet;
import jim.springframework.sfgpetclinic.services.CrudService;
import jim.springframework.sfgpetclinic.services.SpecialityService;
import jim.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({SpringProfiles.DEFAULT, SpringProfiles.MAP})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet v) {

        if (v != null) {
            if (v.getSpecialities() != null) {
                v.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }

            return super.save(v);
        }

        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
