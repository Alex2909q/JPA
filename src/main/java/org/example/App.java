package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class App {

    static EntityManagerFactory ef;
    static EntityManager em;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ef = Persistence.createEntityManagerFactory("JPA");
            em = ef.createEntityManager();
            System.out.println("1. add new order");
            System.out.println("2. sort add new order");
            System.out.println("3. show only with sales");
            System.out.println("4. show weight less the 1kg"+System.lineSeparator());
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    String check = "yes";
                    while (check.equals("yes")) {
                        addOrder(sc);
                        System.out.println("Do you want add new client?" + System.lineSeparator());
                        check = sc.nextLine();
                    }
                    break;
                case "2":
                    sort();
                    break;
                case "3":
                    saleNnull();
                    break;
                case "4":
                    less1Kg();
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            ef.close();
        }
    }

    public static void addOrder(Scanner sc) {
        System.out.println("enter name");
        String name = sc.nextLine();

        System.out.println("enter price");
        int price = Integer.parseInt(sc.nextLine());

        System.out.println("enter weight");
        double weight = Double.parseDouble(sc.nextLine());

        System.out.println("enter sale");
        String sale = sc.nextLine();

        em.getTransaction().begin();
        try {
            Menu menu = new Menu(name, price, weight, sale);
            em.persist(menu);
            em.getTransaction().commit();
            System.out.println(menu.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sort() {
        TypedQuery<Menu> otherquery = em.createQuery(
                "SELECT x FROM Menu x ORDER BY x.price ASC", Menu.class);

        List<Menu> menuL = otherquery.getResultList();
        for (Menu menu1 : menuL) {
            System.out.println(menu1 + System.lineSeparator());
        }
    }

    public static void saleNnull() {
        TypedQuery<Menu> otherquery = em.createQuery(
                "SELECT x FROM Menu x WHERE x.sale IS NOT NULL", Menu.class);

        List<Menu> menuL2 = otherquery.getResultList();
        for (Menu menu2 : menuL2) {
            System.out.println(menu2 + System.lineSeparator());
        }
    }

    public static void less1Kg() {
        TypedQuery<Menu> otherquery = em.createQuery(
                "SELECT x FROM Menu x WHERE x.weight <1", Menu.class);

        List<Menu> menuL3 = otherquery.getResultList();
        for (Menu menu3 : menuL3) {
            System.out.println(menu3 + System.lineSeparator());
        }
    }
}