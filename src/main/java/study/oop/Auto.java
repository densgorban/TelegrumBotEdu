package study.oop;

import java.awt.*;

//super класс
public abstract class Auto implements Vehicle {
    protected String type;
    private Engine engine;
    private Transmission transmision;
    private Color color;

    //constructor
    public Auto(String type, Engine engine, Transmission transmission, Color color) {
        this.type = type;
        this.engine = engine;
        this.transmision = transmission;
        this.color = color;
    }

    @Override
    public abstract void voice();

}
