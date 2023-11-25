package pwr.webdatabases.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.webdatabases.data.model.AbstractEntity;

public interface JpaRepo <T extends AbstractEntity> extends JpaRepository <T, Long> {
}
