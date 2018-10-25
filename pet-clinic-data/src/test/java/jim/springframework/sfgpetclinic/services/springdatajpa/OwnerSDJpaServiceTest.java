package jim.springframework.sfgpetclinic.services.springdatajpa;

import jim.springframework.sfgpetclinic.model.Owner;
import jim.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    String lName = "Smith";
    Long id = 1L;
    Owner owner;

    @BeforeEach
    public void setUp() {
        owner = Owner.builder().id(1L).lastName(lName).build();
    }


    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner foundOwner = service.findByLastName(lName);
        assertEquals(lName, foundOwner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        verify(ownerRepository, times(1)).deleteById(any(Long.class));
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner found = service.findById(id);
        assertNotNull(found);
    }

    @Test
    void save() {

        Owner newOwner = Owner.builder().lastName(lName).build();
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);
        Owner saved = service.save(newOwner);
        assertNotNull(saved);
    }
}