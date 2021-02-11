package com.enigma.trashbank.models.unit;

import com.enigma.trashbank.models.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitSearch extends PageSearch {

    private String code;
    private String description;
}
