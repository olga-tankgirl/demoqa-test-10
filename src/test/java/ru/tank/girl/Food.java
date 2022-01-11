package ru.tank.girl;

public class Food {

    void eats(Boolean kurinost, Boolean golubinost) {
        String food;
        if (kurinost) {
            food = "sluggish";
        } else {
            food = "fresh";
        }
        food += " ";
        if (golubinost) {
            food += "trash";
        } else {
            food += "fruits";
        }
        System.out.println(" and eats " + food);
    }
}