package org.itstep.progressions;

public class GeometricProgression extends Progression{

    private int denominator = 1;

    public GeometricProgression(int initValue, int denominator){
        this.initValue = initValue;
        this.denominator = denominator;
    }

    @Override
    public  int getNext() {
        if (index>0) elem*=denominator;
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