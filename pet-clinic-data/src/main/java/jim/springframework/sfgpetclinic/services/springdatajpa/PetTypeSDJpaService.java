package jim.springframework.sfgpetclinic.services.springdatajpa;

import jim.springframework.sfgpetclinic.model.PetType;
import jim.springframework.sfgpetclinic.repositories.PetRepository;
import jim.springframework.sfgpetclinic.repositories.PetTypeRepository;
import jim.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petRepository;

    public PetTypeSDJpaService(PetTypeRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void delete(PetType object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new TreeSet<>();
        petRepository.findAll().iterator().forEachRemaining(types::add);
        return types;
    }

    @Override
    public PetType findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petRepository.save(object);
    }
}
