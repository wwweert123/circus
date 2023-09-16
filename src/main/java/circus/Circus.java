package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("number of animals in the array: " + animals.length);
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        System.out.println("Size of animal array list: " + animalArrayList.size());
        Elephant andy = new Elephant("Andy");
        animalArrayList.add(andy);
        Tiger sherKhan = new Tiger("Sher Khan");
        animalArrayList.add(sherKhan);
        Duck louie = new Duck("Louie");
        Duck dewey = new Duck("Dewey");
        Parrot birdie = new Parrot("Birdie");
        animalArrayList.add(louie);
        animalArrayList.add(dewey);
        animalArrayList.add(birdie);
        System.out.println("number of animals in the array: " + animalArrayList.size());

        System.out.println("Before sorting ...");
        printAllAnimals(animalArrayList);

        System.out.println("Louie is at:" + animalArrayList.indexOf(louie));

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After sorting ...");
        printAllAnimals(animalArrayList);


        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Donald");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Dolly");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
