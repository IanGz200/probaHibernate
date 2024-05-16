/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.probahibernate;

/**
 * -Comenta la clase-
 * @author IanGz
 */
public class PersonalManager {
    
    private int id, experienceYears;
    private String name;
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public PersonalManager(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }
    
    public PersonalManager() {
    }

}
