package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.constants.SpringProfiles;
import jim.springframework.sfgpetclinic.model.Visit;
import jim.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({SpringProfiles.DEFAULT, SpringProfiles.MAP})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null
            || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }
}
