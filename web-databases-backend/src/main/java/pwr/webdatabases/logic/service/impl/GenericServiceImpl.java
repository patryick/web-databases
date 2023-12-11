package pwr.webdatabases.logic.service.impl;

import pwr.webdatabases.data.model.AbstractEntity;
import pwr.webdatabases.data.repository.jpa.JpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.model.AbstractTo;
import pwr.webdatabases.logic.service.GenericService;

import java.util.List;


public abstract class GenericServiceImpl<T extends AbstractEntity, K extends AbstractTo> implements GenericService<K> {

    protected final JpaRepo <T> repo;
    protected final GenericMapper<T, K> mapper = getMapper();

    protected GenericServiceImpl(JpaRepo<T> repo) {
        this.repo = repo;
    }

    @Override
    public K findById(Long id) {
        if (null == id) {
            throw new RuntimeException();
        }

        return mapper.toTransferObject(repo.findById(id).orElse(null));
    }

    @Override
    public List<K> findAll() {
        return mapper.toTransferObjectList(repo.findAll());
    }

    @Override
    public K create(K object) {

        if (null == object) {
            throw new RuntimeException();
        }
        if (!existsInDb(object)) {
            throw new RuntimeException();
        }

        return mapper.toTransferObject(repo.save(mapper.toEntity(object)));
    }

    @Override
    public K update(K object) {

        if (null == object) {
            throw new RuntimeException(); //TODO exception for null
        }
        if (!repo.existsById(object.getId())) {
            throw new RuntimeException(); //TODO handle if object not found in db
        }

        return mapper.toTransferObject(repo.save(mapper.toEntity(object)));
    }

    @Override
    public void delete(K object) { //TODO delete by parameter -> which one?

        if (null == object) {
            throw new RuntimeException();
        }

        repo.deleteById(object.getId());
    }

    protected abstract GenericMapper<T, K> getMapper();
    protected abstract boolean existsInDb(K object);
}
