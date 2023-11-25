package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.AbstractTo;

public interface GenericService<K extends AbstractTo> {

    public K create(K object);
    public K update(K object);
    public void delete(K object);
}
