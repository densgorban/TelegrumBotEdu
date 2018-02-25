package study.oop;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Auto ford = new LightAuto(
                "Ford Focus",
                new Engine(1.8f,Type.DIESEL),
                new Transmission(),
                Color.BLACK);
        Auto audi = new HeavyAuto(
                "Audi",
                new Engine(1.8f,Type.DIESEL),
                new Transmission(),
                Color.BLUE);
        Auto lanos = new LightAuto(
                "Lanos",
                new Engine(1.4f,Type.GASOLINE),
                new Transmission(),
                Color.CYAN);
        //List, Set, Map (Queue, Dequeue)
        List<Auto> listAuto = new LinkedList<>();


        listAuto.add(ford);
        listAuto.add(audi);
        listAuto.add(lanos);
        listAuto.add(new HeavyAuto("Heavy Opel", new Engine(10.2f, Type.DIESEL), new Transmission(), Color.WHITE));
        listAuto.add(new LightAuto("Oka", new Engine(0.8f, Type.GASOLINE), new Transmission(), Color.WHITE));

        for (Auto auto: listAuto){
            auto.voice();
        }
    }

}

