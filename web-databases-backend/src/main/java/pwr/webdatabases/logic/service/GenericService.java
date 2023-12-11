package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.AbstractTo;

import java.util.List;

public interface GenericService<K extends AbstractTo> {

    public K findById(Long id);
    public List<K> findAll();
    public K create(K object);
    public K update(K object);
    public void delete(K object);
}
