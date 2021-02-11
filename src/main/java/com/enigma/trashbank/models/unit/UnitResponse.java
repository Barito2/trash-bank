package com.enigma.trashbank.models.unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UnitResponse {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 10)
    private String code;

    @NotBlank
    @Size(min = 1, max = 10)
    private String description;
}
