package com.example.votandat_20115031_01.backend.enums;

import javax.management.relation.Role;

public enum Roles {
    ADMINSTRATION(1),
    MANAGER(2),
    STAFF(3),
    EXCUTIVE(4);
    int value;
    Roles(int value){
        this.value = value;
    }

}
