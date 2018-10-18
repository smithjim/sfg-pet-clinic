package jim.springframework.sfgpetclinic.bootstrap;

import jim.springframework.sfgpetclinic.model.*;
import jim.springframework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final  PetTypeService petTypeService;

    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        boolean loaded = petTypeService.findAll().isEmpty();
        if (! loaded) {
            loadData();
        }

    }

    private void loadData() {
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

        Speciality radiology = createSpeciality("radiology");
        Speciality surgery = createSpeciality("surgery");
        Speciality dentistry = createSpeciality("dentistry");

        radiology = specialityService.save(radiology);
        surgery = specialityService.save(surgery);
        dentistry = specialityService.save(dentistry);


        Vet vet1 = createVet( "vet", "one", Arrays.asList(radiology));
        Vet vet2 = createVet( "vet", "two", Arrays.asList(surgery));
        vetService.save(vet1);
        vetService.save(vet2);
    }

    private Speciality createSpeciality(String description) {
        Speciality s = new Speciality();
        s.setDescription(description);
        return s;
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

    private Vet createVet(String fname, String lname, List<Speciality> specialityList) {
        Vet v = new Vet();
        v.setFirstName(fname);
        v.setLastName(lname);
        if (specialityList != null) {
            v.setSpecialities(new HashSet<>(specialityList));
        }

        return v;
    }
}
