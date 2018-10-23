package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.model.Pet;
import jim.springframework.sfgpetclinic.services.CrudService;
import jim.springframework.sfgpetclinic.services.PetService;
import jim.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    private final PetTypeService petTypeService;

    public PetServiceMap(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        if (pet != null) {
            if (pet.getPetType() != null) {
                if (pet.getPetType().getId() == null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }
            } else {
                throw new RuntimeException("PetType is required");
            }

            return super.save(pet);
        }

        return null;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
