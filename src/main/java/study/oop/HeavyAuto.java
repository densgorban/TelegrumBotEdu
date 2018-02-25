package study.oop;

import java.awt.*;

//класс-потомок
public class HeavyAuto extends Auto{

    public HeavyAuto(String type, Engine engine, Transmission transmission, Color color) {
        super(type, engine, transmission, color);
    }

    @Override
    public void voice() {
        String outputMessage = "I'm the Heavy " + type;
        System.out.println(outputMessage);

    }
}
