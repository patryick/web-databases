package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import pwr.webdatabases.data.model.ClassEntity;
import pwr.webdatabases.logic.model.ClassTo;

@Mapper
public interface AbstractMapper extends GenericMapper<ClassEntity, ClassTo> {
}
