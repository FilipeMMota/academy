package com.ctw.workstation.generalentities;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Deprecated
public class Identifier {
    @Schema(hidden = true)
    private String id;
    private String name;

    protected Identifier(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
