package com.company.Task02;

import java.util.Comparator;
import java.util.LinkedList;

public class VolunteerTeam {
    Comparator<Volunteer> comparator;
    LinkedList<Volunteer> team;

    public VolunteerTeam(LinkedList team) {
        this.team = team;
    }

    public LinkedList<Volunteer> top10 (Comparator<Volunteer> comparator, int n) {
        this.comparator = comparator;
        LinkedList<Volunteer> sortedTeam = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Volunteer best = team.getFirst();
            for (Volunteer person :
                    team) {
                if (comparator.compare(person, best) < 0) {
                    best = person;
                }
            }
            team.remove(best);
            sortedTeam.add(best);
        }
        return sortedTeam;
    }

}
