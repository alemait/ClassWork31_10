package org.itstep;

public class Nested {
    public static void main(String[] args) {
        Person tom = new Person("Tom");
        tom.setAccount("qwerty");

        Math2.Factorial fact = Math2.getFactorial(6);
        System.out.printf("Факториал числа %d равен %d \n", fact.getKey(), fact.getResult());
    }
}

class Person{
    private String name;
    Person(String name){
        this.name = name;
    }

    //Вложенный класс объявлен в методе основного
    public void setAccount (String password){

        class Account{
            void display(){
                System.out.printf("Account Login: %s \t Password: %s \n", name, password);
            }
        }

        Account account = new Account();
        account.display();
    }
}

//Статический вложенный класс
class Math2{

    public static class Factorial{

        private int result;
        private int key;

        public Factorial(int result, int key){
            this.result=result;
            this.key = key;
        }

        public int getResult(){
            return result;
        }

        public int getKey(){
            return key;
        }
    }

    public static Factorial getFactorial(int key){
        int result=1;
        for (int i = 1; i <= key; i++)
            result *= i;
        return new Factorial(result, key);
    }
}