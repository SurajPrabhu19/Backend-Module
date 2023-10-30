package com.scaler.inheritancedemo.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
@DiscriminatorValue(value = "1")
public class TA extends User {
    private double avgRating;
}
