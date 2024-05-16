/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.probahibernate;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.util.config.ConfigurationException;

/**
 *
 * @author usuario
 */
public class ProbaHibernate {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();

            Scanner scan = new Scanner(System.in);

            System.out.println("Introduce o nome:");
            String name = scan.nextLine();
            System.out.println("Introduce os apelidos:");
            String surname = scan.nextLine();
            System.out.println("Introduce o nome do xestor:");
            String managerName = scan.nextLine();
            System.out.println("Introduce os anos de experiencia do xestor:");
            int experienceYears = scan.nextInt();
            scan.nextLine();
            PersonalManager manager = new PersonalManager(managerName, experienceYears);
            session.beginTransaction();
            session.save(new Client(name, surname, manager));
            session.getTransaction().commit();

            List result = session.createQuery("from Client").list();
            for (Client c : (List<Client>) result) {
                System.out.println("Cliente: " + c.getName());
                if (c.getManager() != null) {
                    System.out.println("    Xestor: " + c.getManager().getName());
                }
            }

            // Código que executa as operacións coa BD con Hibernate
            session.close();
            sessionFactory.close();

        } catch (ConfigurationException e) {
            System.out.println("Erro nas operacións coa base de datos: " + e.getMessage());
            // O registry e eliminado pola SessionFactory, pero se non podemos
            // creala, eliminamolo explicitamente
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
