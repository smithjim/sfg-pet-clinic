package jim.springframework.sfgpetclinic.services.springdatajpa;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.repositories.OwnerRepository;
import jim.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastname) {
        return ownerRepository.findByLastName(lastname);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owner = new TreeSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(owner::add);
        return owner;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }
}
