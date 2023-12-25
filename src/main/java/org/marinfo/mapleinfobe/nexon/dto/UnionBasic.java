package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UnionBasic {
    private String date;
    @JsonAlias({"union_level"})
    private Long unionLevel;
    @JsonAlias({"union_grade"})
    private String unionGrade;
}
