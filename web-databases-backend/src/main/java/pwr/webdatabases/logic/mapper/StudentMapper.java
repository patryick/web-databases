package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.logic.model.StudentTo;

@Mapper(uses = AbstractMapper.class)
public interface StudentMapper extends GenericMapper<StudentEntity, StudentTo> {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
