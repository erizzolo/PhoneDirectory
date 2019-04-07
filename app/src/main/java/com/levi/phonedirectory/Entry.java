package com.levi.phonedirectory;

import java.io.Serializable;

public class Entry implements Serializable {

    private String name;
    private String number;

    public Entry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean equalsByName(Entry e) {
        if (this == e) return true;
        if (e == null) return false;
        return getName().equals(e.getName());
    }

    public boolean equalsByNumber(Entry e) {
        if (this == e) return true;
        if (e == null) return false;
        return getNumber().equals(e.getNumber());
    }

}
