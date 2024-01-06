package org.marinfo.mapleinfobe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "CharacterOcid")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterOcidEntity {
    @Id
    private String characterName;
    @NotBlank
    private String ocid;

    public static CharacterOcidEntity create(String characterName, String ocid) {
        return CharacterOcidEntity.builder()
                .characterName(characterName)
                .ocid(ocid)
                .build();
    }
}
