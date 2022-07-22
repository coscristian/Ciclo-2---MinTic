package com.cristian.desarrollo.dto;

public class Departments {
    private Integer id;
    private String name;
    private Integer location;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLocation() {
        return location;
    }
    public void setLocation(Integer location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%d %n", id, name, location);
    }

}
