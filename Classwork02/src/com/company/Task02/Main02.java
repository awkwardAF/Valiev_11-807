package com.company.Task02;

import java.util.Comparator;
import java.util.LinkedList;

public class Main02 {
    public static void main(String[] args) {
        Volunteer v1 = new Volunteer(1, "John", 5);
        Volunteer v2 = new Volunteer(2, "Alex", 10);
        Volunteer v3 = new Volunteer(3, "Bread", 3);
        LinkedList<Volunteer> vols = new LinkedList<Volunteer>();
        vols.add(v1);
        vols.add(v2);
        vols.add(v3);
        VolunteerTeam team = new VolunteerTeam(vols);
        // для проверки
        for (Volunteer person :
                team.top10(new ByNameComparator(), 3)) {
            System.out.println(person.getName());
        };
    }
}
