package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.logic.model.GradeTo;

@Mapper(uses = AbstractMapper.class)
public interface GradeMapper extends GenericMapper<GradeEntity, GradeTo> {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);
}
