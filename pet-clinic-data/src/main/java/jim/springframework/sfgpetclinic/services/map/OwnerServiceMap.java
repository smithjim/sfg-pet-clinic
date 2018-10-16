package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.services.CrudService;
import jim.springframework.sfgpetclinic.services.map.AbstractMapService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
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
        return this.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
