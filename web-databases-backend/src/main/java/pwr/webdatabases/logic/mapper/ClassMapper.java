package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.ClassEntity;
import pwr.webdatabases.logic.model.ClassTo;

@Mapper(uses = AbstractMapper.class)
public interface ClassMapper extends GenericMapper<ClassEntity, ClassTo>{

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);
}
