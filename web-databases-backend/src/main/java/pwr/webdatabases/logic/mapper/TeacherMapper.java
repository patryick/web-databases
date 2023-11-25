package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.logic.model.TeacherTo;

@Mapper(uses = AbstractMapper.class)
public interface TeacherMapper extends GenericMapper<TeacherEntity, TeacherTo> {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
}
