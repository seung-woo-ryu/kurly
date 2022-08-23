package com.kurly.demo.user.domain;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_USER("USER"), ROLE_DELIVERY_MAN("ROLE_DELIVERY_MAN");
    private final String value;
    Role(String value) {
        this.value = value;
    }

}
