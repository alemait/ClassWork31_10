package org.itstep;

import java.util.ArrayList;
import java.util.List;

public class FuncInterface {
    public static void main(String[] args) {
        Button button = new Button();
        /*
        Lamp lamp = new Lamp();
        button.add(lamp);
         */
        button.add(new Lamp());
        button.add(new WasherMachine());
        button.switchOn();
    }
}

//Электрическая кнопка
class Button {
    boolean state = false; //Состояние выключателя
    List<SwitchableOn> consumers = new ArrayList<>();

    public void switchOn() {
        state = true;
        System.out.println("The button is on");
        /*
        for (SwitchableOn consumer : consumers)
            if (consumer != null) consumer.switchOn();
         */
        consumers.stream().forEach(SwitchableOn::switchOn);
    }

    public void switchOff() {
        state = false;
        System.out.println("The button is off");
    }

    public void add(SwitchableOn consumer) {
        consumers.add(consumer);
    }
}

//Лампа
class Lamp implements SwitchableOn {
    @Override
    public void switchOn() {
        System.out.println("The lamp is turn on");
    }
}

//
class WasherMachine implements SwitchableOn {
    @Override
    public void switchOn() {
        System.out.println("The washer machine is turn on");
    }
}

//Включается от электрического выключателя
@FunctionalInterface
interface SwitchableOn {
    void switchOn();
}