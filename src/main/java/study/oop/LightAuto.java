package study.oop;

import java.awt.*;

//child class
public class LightAuto extends Auto{
    public LightAuto(String type, Engine engine, Transmission transmission, Color color) {
        super(type, engine, transmission, color);
    }

    @Override
    public void voice() {
        String outputMessage = "I'm the Light" + type;
        System.out.println(outputMessage);
    }
}
