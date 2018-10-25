package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @Mock
    PetServiceMap petServiceMock;

    Long ownerId = 1L;
    String lastName = "Smith";

    String emptyLastName = "null";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerServiceMap = new OwnerServiceMap(petServiceMock);
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void saveExistringId() {
        Long id = 2L;
        Owner o2 = Owner.builder().id(id).build();

        Owner saved = ownerServiceMap.save(o2);

        assertEquals(id, saved.getId());
    }

    @Test
    void saveWithPets() {
        Pet returnPet = Pet.builder().id(1L).build();
        Set<Pet> pets = new HashSet<>();
        pets.add(Pet.builder().build());

        Owner o = ownerServiceMap.findById(ownerId);
        o.setPets(pets);

        when(petServiceMock.save(any(Pet.class))).thenReturn(returnPet);

        ownerServiceMap.save(o);

        verify(petServiceMock, times(1)).save(any());
    }

    @Test
    void saveNew() {
        Owner saved = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saved.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByIdEmpty() {
        Owner owner = ownerServiceMap.findById(-1L);
        assertNull(owner);
    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNoMatch() {

        Owner owner = ownerServiceMap.findByLastName(emptyLastName);
        assertNull(owner);
    }
}