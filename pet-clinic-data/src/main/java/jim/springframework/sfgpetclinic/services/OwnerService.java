package jim.springframework.sfgpetclinic.services;

import jim.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastname);

}
