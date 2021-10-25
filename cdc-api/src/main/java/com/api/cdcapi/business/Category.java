package com.api.cdcapi.business;

import java.util.UUID;

public class Category {
    
    private UUID category_id;
    private String label;
    private Integer lower_value;
    private Integer higher_value;


    public Category() {
    }

    public Category(String label, Integer lower_value, Integer higher_value) {
        this.category_id = UUID.randomUUID();
        this.label = label;
        this.lower_value = lower_value;
        this.higher_value = higher_value;
    }

    public UUID getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLower_value() {
        return this.lower_value;
    }

    public void setLower_value(Integer lower_value) {
        this.lower_value = lower_value;
    }

    public Integer getHigher_value() {
        return this.higher_value;
    }

    public void setHigher_value(Integer higher_value) {
        this.higher_value = higher_value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.label).append(" (").append(this.lower_value).append("kg -> ").append(this.higher_value).append("kg)");
        return sb.toString();
    }
    
}
