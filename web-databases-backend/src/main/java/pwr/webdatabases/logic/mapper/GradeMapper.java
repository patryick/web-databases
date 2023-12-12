package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.logic.model.GradeTo;

import java.util.List;

@Mapper
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    GradeTo toTo(GradeEntity grade);
    List<GradeTo> toToList(List<GradeEntity> grades);
}
