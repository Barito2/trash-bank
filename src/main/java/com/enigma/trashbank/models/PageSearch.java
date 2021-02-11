package com.enigma.trashbank.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;

@Getter
@Setter
@NoArgsConstructor
public class PageSearch {

    private Integer page = 1;

    @Max(100)
    private Integer size = 10;

    private Sort.Direction sort = Sort.Direction.ASC;

}
