package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.logic.model.LessonTo;

@Mapper(uses = AbstractMapper.class)
public interface LessonMapper extends GenericMapper<LessonEntity, LessonTo> {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);
}
