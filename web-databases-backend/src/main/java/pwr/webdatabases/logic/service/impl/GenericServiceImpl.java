package pwr.webdatabases.logic.service.impl;

import pwr.webdatabases.data.model.AbstractEntity;
import pwr.webdatabases.data.repository.jpa.JpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.model.AbstractTo;
import pwr.webdatabases.logic.service.GenericService;


public abstract class GenericServiceImpl<T extends AbstractEntity, K extends AbstractTo> implements GenericService<K> {

    private final JpaRepo <T> repo;
    private final GenericMapper<T, K> mapper = getMapper();

    protected GenericServiceImpl(JpaRepo<T> repo) {
        this.repo = repo;
    }

    public K create(K object) {

        if (null == object) {
            throw new RuntimeException();
        }
        if (!existsInDb(object)) {
            throw new RuntimeException();
        }

        return mapper.toTransferObject(repo.save(mapper.toEntity(object)));
    }

    public K update(K object) {

        if (null == object) {
            throw new RuntimeException(); //TODO exception for null
        }
        if (!repo.existsById(object.getId())) {
            throw new RuntimeException(); //TODO handle if object not found in db
        }

        return mapper.toTransferObject(repo.save(mapper.toEntity(object)));
    }

    public void delete(K object) { //TODO delete by parameter -> which one?

        if (null == object) {
            throw new RuntimeException();
        }

        repo.deleteById(object.getId());
    }

    protected abstract GenericMapper<T, K> getMapper();
    protected abstract boolean existsInDb(K object);
}
