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

    @Mapping(target = "name", source = "student.user.name")
    @Mapping(target = "surname", source = "student.user.surname")
    StudentNameTo toNameTo(StudentEntity student);

    @Mapping(target = "name", source = "student.user.name")
    @Mapping(target = "surname", source = "student.user.surname")
    StudentLessonDetailsTo toLessonDetailsTo(StudentEntity student);
}
