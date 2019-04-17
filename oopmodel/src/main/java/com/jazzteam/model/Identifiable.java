package com.jazzteam.model;

abstract public class Identifiable {
    protected int id;

    public Identifiable() {
        this.id = getNextId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Index for the object's ID
     */
    protected static int index = 0;

    /**
     * Return next ID
     * @return int
     */
    protected static int getNextId() {
        return ++index;
    }
}
