package pwr.webdatabases.logic.mapper;

import pwr.webdatabases.data.model.AbstractEntity;
import pwr.webdatabases.logic.model.AbstractTo;

public interface GenericMapper<T extends AbstractEntity, K extends AbstractTo> {

    K toTransferObject(T abstractEntity);
    T toEntity(K abstractTo);
}
