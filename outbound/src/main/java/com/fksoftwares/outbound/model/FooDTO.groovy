package com.fksoftwares.outbound.model

class FooDTO implements Serializable {
    String foo
    String bar

    FooDTO(String foo, String bar) {
        this.foo = foo
        this.bar = bar
    }

    protected FooDTO() {}

}