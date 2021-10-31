package org.itstep.progressions;

public class ArithmeticProgression extends Progression{

    private int diff = 1;

    public ArithmeticProgression(int initValue, int diff){
        this.initValue = initValue;
        this.diff = diff;
    }

    //Перегрузка конструктора
    public ArithmeticProgression(int initValue){
        this.initValue = initValue;
        this.diff = 1;
    }

    @Override
    public  int getNext() {
        if (index>0) elem+=diff;
        else elem = initValue;
        sum+=elem;
        index++;
        return elem;
    }

    @Override
    public int getSum() {
        return sum;
    }
}
