package org.marinfo.mapleinfobe.service;

import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.entity.CharacterOcidEntity;
import org.marinfo.mapleinfobe.nexon.service.NexonIdentifyService;
import org.marinfo.mapleinfobe.repository.CharacterOcidRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final CharacterOcidRepository characterOcidRepository;
    private final NexonIdentifyService nexonIdentifyService;

    public boolean refreshCharacterInfo(String characterName) {
        String ocid = nexonIdentifyService.getOcid(characterName);

        CharacterOcidEntity entity = CharacterOcidEntity.create(characterName, ocid);

        characterOcidRepository.deleteById(characterName);

        characterOcidRepository.save(entity);

        return true;
    }
}
