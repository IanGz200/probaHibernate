/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.probahibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.util.config.ConfigurationException;

/**
 * -Comenta la clase-
 *
 * @author IanGz
 */
public class Client {

    private int id;
    private String name, surname;
    private PersonalManager manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Client(String name, String surname, PersonalManager manager) {
        this.name = name;
        this.surname = surname;
        this.manager = manager;
        if (manager != null) {
            manager.setClient(this);
        }
    }

    public PersonalManager getManager() {
        return manager;
    }

    public void setManager(PersonalManager manager) {
        if (manager != null) {
            manager.setClient(this);
        }
        this.manager = manager;
    }

    public Client() {
    }

}
