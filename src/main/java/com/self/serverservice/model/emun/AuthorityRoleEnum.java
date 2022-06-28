package com.self.serverservice.model.emun;

public enum AuthorityRoleEnum {
    ADMIN("admin"),
    USER("user"),
    ANONYMOUS("anonymous");

    private String role;

    AuthorityRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
