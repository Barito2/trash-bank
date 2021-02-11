package com.enigma.trashbank.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PagedList<T> {
    private List<T> list;
    private Integer currentPage;
    private Integer totalPage;
    private Integer size;
    private Long totalElement;


}
