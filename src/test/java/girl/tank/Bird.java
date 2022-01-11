package girl.tank;

public class Bird {
    String vid;
    Boolean kurinost;
    Boolean golubinost;

    void behavior() {
        String behaves;
        if (kurinost) {
            behaves = "crazy";
        } else {
            behaves = "polite";
        }
        behaves += " and ";
        if (golubinost) {
            behaves += "dumb";
        } else {
            behaves += "clever";
        }
        System.out.print("The " + vid + " behaves " + behaves);
    }
}