package com.laurentiutanase.carmarketplacedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the booking application.
 */

public enum FuelTypeEnum {
    DIESEL("Diesel"),

    PETROL("Petrol"),

    ELECTRIC("Electric");

    private String value;

    FuelTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static FuelTypeEnum fromValue(String text) {
        for (FuelTypeEnum b : FuelTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
