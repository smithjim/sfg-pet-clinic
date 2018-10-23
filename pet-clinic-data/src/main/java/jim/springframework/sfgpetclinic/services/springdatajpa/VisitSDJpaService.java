package jim.springframework.sfgpetclinic.services.springdatajpa;

import jim.springframework.sfgpetclinic.constants.SpringProfiles;
import jim.springframework.sfgpetclinic.model.Visit;
import jim.springframework.sfgpetclinic.repositories.VisitRepository;
import jim.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile(SpringProfiles.SPRING_DATA_JPA)
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new TreeSet<>();
        visitRepository.findAll().iterator().forEachRemaining(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }
}
