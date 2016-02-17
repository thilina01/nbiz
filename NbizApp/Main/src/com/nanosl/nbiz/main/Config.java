package com.nanosl.nbiz.main;

import java.io.Serializable;

public class Config implements Serializable {

    public String server = "Default";
    public String database = "Default";
    private String username = "Default";
    private String password = "Default";
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

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
