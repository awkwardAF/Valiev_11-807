package com.company.Task02;

import java.util.Comparator;

public class ByIdComparator implements Comparator<Volunteer> {

    @Override
    public int compare(Volunteer o1, Volunteer o2) {
        return o1.getId() - o2.getId();
    }
}
