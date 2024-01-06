package org.marinfo.mapleinfobe.repository;

import org.marinfo.mapleinfobe.entity.CharacterOcidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterOcidRepository extends JpaRepository<CharacterOcidEntity, String> {
    Optional<CharacterOcidEntity> findByCharacterName(String characterName);
}
