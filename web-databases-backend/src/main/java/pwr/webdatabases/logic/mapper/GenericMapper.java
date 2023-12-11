package pwr.webdatabases.logic.mapper;

import pwr.webdatabases.data.model.AbstractEntity;
import pwr.webdatabases.logic.model.AbstractTo;

import java.util.List;

public interface GenericMapper<T extends AbstractEntity, K extends AbstractTo> {

    K toTransferObject(T abstractEntity);
    T toEntity(K abstractTo);
    default List<T> toEntityList(List<K> list) {
        return list.stream()
            .map(this::toEntity)
            .toList();
    }
    default List<K> toTransferObjectList(List<T> list) {
        return list.stream()
            .map(this::toTransferObject)
            .toList();
    }
}
