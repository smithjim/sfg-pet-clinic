package jim.springframework.sfgpetclinic.bootstrap;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.model.Pet;
import jim.springframework.sfgpetclinic.model.PetType;
import jim.springframework.sfgpetclinic.model.Vet;
import jim.springframework.sfgpetclinic.services.OwnerService;
import jim.springframework.sfgpetclinic.services.PetService;
import jim.springframework.sfgpetclinic.services.PetTypeService;
import jim.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        Owner owner1 = createOwner("owner", "one", "address1", "city1", "111-111");
        Pet pet1 = createPet("Russel", owner1, dog, LocalDate.of(1990, 1, 1));
        owner1.setPets(new HashSet<>(Arrays.asList(pet1)));

        Owner owner2 = createOwner( "owner", "two", "address2", "city1", "222-222");
        Pet pet2 = createPet("Catherine", owner2, cat, LocalDate.of(2010, 6, 7));
        owner2.setPets(new HashSet<>(Arrays.asList(pet2)));

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

    private Pet createPet(String name, Owner o, PetType pType, LocalDate date) {
        Pet p = new Pet();
        p.setName(name);
        p.setPetType(pType);
        p.setOwner(o);
        p.setBirthDate(date);
        return p;
    }

    private Owner createOwner(String fname, String lname, String address, String city, String telephone) {
        Owner o = new Owner();
        o.setFirstName(fname);
        o.setLastName(lname);
        o.setAddress(address);
        o.setCity(city);
        o.setTelephone(telephone);
        return o;
    }

    private Vet createVet(String fname, String lname) {
        Vet v = new Vet();
        v.setFirstName(fname);
        v.setLastName(lname);
        return v;
    }
}
