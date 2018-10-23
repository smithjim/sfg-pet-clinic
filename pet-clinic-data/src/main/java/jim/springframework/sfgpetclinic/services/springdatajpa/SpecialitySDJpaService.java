package jim.springframework.sfgpetclinic.services.springdatajpa;

import jim.springframework.sfgpetclinic.constants.SpringProfiles;
import jim.springframework.sfgpetclinic.model.Speciality;
import jim.springframework.sfgpetclinic.repositories.SpecialityRepository;
import jim.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile(SpringProfiles.SPRING_DATA_JPA)
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new TreeSet<>();
        specialityRepository.findAll().iterator().forEachRemaining(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }
}
