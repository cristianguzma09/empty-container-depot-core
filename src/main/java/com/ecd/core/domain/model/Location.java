package com.ecd.core.domain.model;


import java.util.Objects;

public class Location {

    private final Long id;
    private final String name;
    private final String code;

    public Location(Long id, String name, String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Location code is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Location name is required");
        }

        this.id = id;
        this.name = name.trim();
        this.code = code.trim();

    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }

    /*------------ Identity-------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return  Objects.equals(code, location.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
