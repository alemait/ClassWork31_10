package org.itstep.progressions;

public class Fibonacci extends Progression{

    private int initValue0 = 0;

    public Fibonacci(){
        this.initValue = 1;
    }

    @Override
    public  int getNext() {
        if (index==0) elem=initValue0;
        else if (index==1) elem=initValue;
        else {
            elem = initValue0+initValue;
            initValue0 = initValue;
            initValue = elem;
        }
        sum+=elem;
        index++;
        //System.out.printf("1:%d 2:%d 3:%d\n",initValue0,initValue,elem);
        return elem;
    }

    @Override
    public int getSum() {
        return sum;
    }
}