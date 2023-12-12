package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.AbsenceEntity;
import pwr.webdatabases.logic.model.AbsenceTo;

import java.util.List;

@Mapper
public interface AbsenceMapper {

    AbsenceMapper INSTANCE = Mappers.getMapper(AbsenceMapper.class);

    AbsenceTo toTo(AbsenceEntity absence);
    AbsenceEntity toEntity(AbsenceTo absence);
    List<AbsenceTo> toToList(List<AbsenceEntity> absences);
}
