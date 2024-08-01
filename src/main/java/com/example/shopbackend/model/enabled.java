package com.example.shopbackend.model;

import jakarta.persistence.*;

@Entity
public class enabled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    public boolean enabledValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean isEnabledValue() {
        return enabledValue;
    }

    public void setEnabledValue(boolean enabledValue) {
        this.enabledValue = enabledValue;
    }

}
