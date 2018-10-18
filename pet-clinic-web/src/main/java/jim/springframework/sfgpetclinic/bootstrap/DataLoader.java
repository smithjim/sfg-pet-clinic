package jim.springframework.sfgpetclinic.bootstrap;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.model.PetType;
import jim.springframework.sfgpetclinic.model.Vet;
import jim.springframework.sfgpetclinic.services.OwnerService;
import jim.springframework.sfgpetclinic.services.PetService;
import jim.springframework.sfgpetclinic.services.PetTypeService;
import jim.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final  PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = createPetType("dog");
        PetType cat = createPetType("cat");
        petTypeService.save(dog);
        petTypeService.save(cat);

        Owner owner1 = createOwner("owner", "one");
        Owner owner2 = createOwner( "owner", "two");
        ownerService.save(owner1);
        ownerService.save(owner2);

        Vet vet1 = createVet( "vet", "one");
        Vet vet2 = createVet( "vet", "two");
        vetService.save(vet1);
        vetService.save(vet2);


    }

    private PetType createPetType(String name) {
        PetType petType = new PetType();
        petType.setName(name);
        return petType;
    }

    private Owner createOwner(String fname, String lname) {
        Owner o = new Owner();
        o.setFirstName(fname);
        o.setLastName(lname);
        return o;
    }

    private Vet createVet(String fname, String lname) {
        Vet v = new Vet();
        v.setFirstName(fname);
        v.setLastName(lname);
        return v;
    }
}
