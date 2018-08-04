package com.jck.travel.flight.model.dto.util;


public class SearchableUtil<T> implements Searchable<T> {

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}
