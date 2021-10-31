package org.itstep.progressions;

/*
— Итак, каков прогресс в вашей работе?  — Всё сделано в лучших российских традициях!  — То есть?  — Даже не начинал, но очень утомился.
— До чего дошел прогресс! Скачал прикола ради программу "Для очистки монитора от пыли". Запустил. Появляется серый экран,
на котором крупными черными буквами надпись: ПРОТРИ ЭКРАН!
Кнопки выхода нет, диспетчер задач не работает короче не знаю как выйти...
— И как ты вышел? ))
— Вообщем решил протереть-таки экран, и только тогда заметил маленькую серую кнопочку "Выход"! Идеальная программа!
 */
public class Progressions {
    public static void main(String[] args) {
        ArithmeticProgression arithProg = new ArithmeticProgression(1,1);
        arithProg.getNext();
        System.out.println(arithProg.getSum());
        arithProg.getNext();
        System.out.println(arithProg.getSum());

        for (int i=0; i<5; i++) 
            System.out.print(arithProg.getNext()+" ");
        System.out.println();
        System.out.printf("Sum: %d\n",arithProg.getSum());
        
        GeometricProgression geomProg = new GeometricProgression(1,2);
        for (int i=0; i<5; i++) 
            System.out.print(geomProg.getNext()+" ");
        System.out.println();
        System.out.printf("Sum: %d\n",geomProg.getSum());
        
        Fibonacci fibonacci = new Fibonacci();
        for (int i=0; i<10; i++) 
            System.out.print(fibonacci.getNext()+" ");
        System.out.println();
        System.out.printf("Sum: %d\n",fibonacci.getSum());
    }
}

//Класс прогрессия
abstract class Progression{
protected int initValue = 0;
protected int index = 0;
protected int elem = 0;
protected int sum = 0;

//Получить следующий элемент прогрессии
abstract int getNext();

//Подсчитать сумму элементов
public int getSum(){
    return sum;
}
}
