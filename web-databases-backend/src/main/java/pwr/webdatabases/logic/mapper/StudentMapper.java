package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.logic.model.StudentLessonDetailsTo;
import pwr.webdatabases.logic.model.StudentNameTo;

@Mapper(uses = {GradeMapper.class, AbsenceMapper.class})
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentNameTo toNameTo(StudentEntity student);

    StudentLessonDetailsTo toLessonDetailsTo(StudentEntity student);
}
