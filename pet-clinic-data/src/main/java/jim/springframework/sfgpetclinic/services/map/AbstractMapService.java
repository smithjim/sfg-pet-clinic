package jim.springframework.sfgpetclinic.services.map;

import jim.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return this.map.get(id);
    }

    T save(T object) {
        if (object == null) {
            throw new RuntimeException("Saved Object cannot be null");
        }

        if (object.getId() == null) {
            object.setId(this.getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long id;
        if (map.isEmpty()) {
            id = 1L;
        } else {
            id = Collections.max(map.keySet()) + 1L;
        }
        return id;
    }

}
