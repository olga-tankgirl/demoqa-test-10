package ru.tank.girl;

public class Main {
    public static void main(String[] args) {

        Food food = new Food();

        Bird kurica = new Bird();
        kurica.vid = "hen";
        kurica.kurinost = true;
        kurica.golubinost = false;
        kurica.behavior();
        food.eats(kurica.kurinost, kurica.golubinost);

        Bird pigeon = new Bird();
        pigeon.vid = "pigeon";
        pigeon.kurinost = false;
        pigeon.golubinost = true;
        pigeon.behavior();
        food.eats(pigeon.kurinost, pigeon.golubinost);

        Bird toucan = new Bird();
        toucan.vid = "toucan";
        toucan.kurinost = false;
        toucan.golubinost = false;
        toucan.behavior();
        food.eats(toucan.kurinost, toucan.golubinost);

        Bird human = new Bird();
        human.vid = "human";
        human.kurinost = true;
        human.golubinost = true;
        human.behavior();
        food.eats(human.kurinost, human.golubinost);

    }
}