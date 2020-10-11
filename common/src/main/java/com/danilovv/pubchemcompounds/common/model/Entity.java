package com.danilovv.pubchemcompounds.common.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Entity {
    private final String id;
    private final String name;
}
