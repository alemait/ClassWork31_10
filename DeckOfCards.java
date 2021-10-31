package org.itstep;
import java.util.ArrayList;

public class DeckOfCards {
    public static void main(String[] args) {        
        Deck deck = new Deck();
        //int[] deck2 = deck.shuffle(); 
        //for (int i=0; i<deck2.length; i++) System.out.print(deck2[i]+" ");
        //deck.printDeck(deck.shuffle());
        deck.printDeck(deck.getCurrDeck());
        deck.shuffle();
        deck.printDeck(deck.getCurrDeck());
        deck.sort();
        deck.printDeck(deck.getCurrDeck());
        //deck.firstLast6();
        int[] cards = deck.giveOut(2);
        Permute permute= new Permute();
        permute.permute(cards);        
        for (int i=0; i<permute.getArrays().size(); i++){
            deck.printDeck(permute.getArrays().get(i));
            //System.out.println(Arrays.toString(permute.getArrays().get(i)));
        }
    }
}

class Deck{        
    public static final String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
    public static final String[] ranges = {"6","7","8","9","10","Jack","Queen","King","Ace"};
    public static final String[] signs = {"\u2666","\u2665","\u2660","\u2663" };
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final int countSuits = suits.length;
    private final int countRanges = ranges.length;
    private int[] initDeck;
    private int[] currDeck;
    
    Deck(){
        initDeck = new int[countSuits*countRanges];
        for (int i = 0; i<initDeck.length; i++) initDeck[i] = i;
        currDeck = new int[initDeck.length];
        System.arraycopy( this.initDeck, 0, this.currDeck, 0, initDeck.length);
    }
    
    public void printDeck(int[] deck){  
        System.out.print(ANSI_RESET);
        System.out.print(deck.length+": ");
        for (int i=0; i<deck.length; i++){
            int indSuit = deck[i]/countRanges;
            int indRange = deck[i]%countRanges;
            if (indSuit<2){
                    System.out.print(ANSI_RED);
                }
            else System.out.print(ANSI_RESET);
                System.out.printf("%s%s ", signs[indSuit], ranges[indRange]);            
    }        
        System.out.print("\n");
}
        
     public void shuffle(){        
        System.arraycopy(this.initDeck, 0, currDeck, 0, initDeck.length);
        for (int i=0; i<currDeck.length; i++) {
            int rand = (int) Math.round(Math.random()*(initDeck.length-1));
            int temp = currDeck[i];
            currDeck[i] = currDeck[rand];
            currDeck[rand] = temp;
        }        
}
     //It is needed!
     public void sort(){
         for (int i=0; i<currDeck.length; i++)
             for (int j=i+1; j<currDeck.length; j++)
                 if (currDeck[i]>currDeck[j]) Permute.swap(currDeck, i, j);
     }

     public void firstLast6(){
         int[] deck;
         do{
            deck = giveOut(3);
            printDeck(deck);
            //System.out.println(currDeck[0]+" "+currDeck[0]%countRanges);
         }
         while((deck[0]%countRanges)!=0);         
     }
     
     public  int[] giveOut(int count){
         //Take a new deck
         if ((this.currDeck.length-count)<0) 
         {
            this.currDeck = this.initDeck; 
         }    
         int[] deck = new int[count];
         System.arraycopy( this.currDeck, 0, deck, 0, deck.length);     
         int[] newDeck = new int[this.currDeck.length-count];
         System.arraycopy( this.currDeck, count, newDeck, 0, this.currDeck.length-count);         
         this.currDeck = newDeck;
         return deck;
     }
     
    public int[] getDeck() {
        return initDeck;
}

    public int[] getCurrDeck() {
        return currDeck;
    }
}

class Permute{    
    
    private final ArrayList<int[]> arrays;
    
    Permute(){
        arrays = new ArrayList<int[]>();
    }
    
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public void permute(int[] arr) {
        permute(arr, 0, arr.length - 1);
    }

    /**
     * print permutations of array
     * 
     * @param arr
     *            original int array,
     * @param i
     *            start index
     * @param n
     *            end index
     */
    private void permute(int[] arr, int i, int n) {        
        if (i == n){
            int[] tempArr = new int[arr.length];
            System.arraycopy(arr, 0, tempArr, 0, arr.length);
            arrays.add(tempArr);
        }
            //System.out.println(Arrays.toString(arr));
        else {
            for (int j = i; j <= n; j++) {
                swap(arr, i, j);
                permute(arr, i + 1, n);
                swap(arr, i, j); // backtrack
            }
        }
    }
    
    public ArrayList<int[]> getArrays() {
        return arrays;
    }
}