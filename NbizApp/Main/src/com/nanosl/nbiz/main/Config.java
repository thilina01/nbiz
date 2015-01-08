package com.nanosl.nbiz.main;

import java.io.Serializable;

public class Config implements Serializable {

    public String server = "Default";
    public String database = "Default";
    private String name = "Default";

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void describe() {
        System.out.println("Configuration data: [" + name + " - " + server + " - " + database + "]");
    }

    @Override
    public String toString() {
        return name;
    }

}
