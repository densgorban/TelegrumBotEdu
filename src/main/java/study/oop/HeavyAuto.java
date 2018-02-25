package study.oop;

import java.awt.*;

//класс-потомок
public class HeavyAuto extends Auto{

    public HeavyAuto(String type, Engine engine, Transmission transmission, Color color) {
        super(type, engine, transmission, color);
    }

    public HeavyAuto() {
        super("", new Engine(12f, Type.DIESEL), new Transmission(), Color.BLUE);
    }

    @Override
    public void voice() {
        String outputMessage = "I'm the Heavy " + type;
        System.out.println(outputMessage);
    }

    public void doSomething() throws Exception {
        throw new RuntimeException("Just for test from Heavy Auto");
    }

}
