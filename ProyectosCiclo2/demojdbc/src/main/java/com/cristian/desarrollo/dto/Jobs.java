package com.cristian.desarrollo.dto;

import java.util.List;

public class Jobs {
    private Integer id;
    private String title;
    private Double minSalary;
    private Double MaxSalary;
    
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Double getMinSalary() {
        return minSalary;
    }
    public Double getMaxSalary() {
        return MaxSalary;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }
    public void setMaxSalary(Double maxSalary) {
        MaxSalary = maxSalary;
    }
    
    @Override
    public String toString() {
        return "Jobs [MaxSalary=" + MaxSalary + ", id=" + id + ", minSalary=" + minSalary + ", title=" + title + "]";
    }

    
}