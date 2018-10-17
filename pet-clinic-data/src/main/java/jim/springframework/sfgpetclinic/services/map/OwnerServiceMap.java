package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.services.CrudService;
import jim.springframework.sfgpetclinic.services.OwnerService;
import jim.springframework.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastname) {
        //TODO implement.
        return null;
    }
}
