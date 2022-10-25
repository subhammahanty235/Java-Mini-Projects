import java.util.Random;
import java.util.Scanner;
class Game{
    public int number;
    public int inputnum;
    public int number_of_guesses;
    Game(){
        Random rand = new Random();
        int num = rand.nextInt(100);
        this.number = num;

    }
    public int getnumberofguesses(){
        return number_of_guesses;
    }
    public void setnumberofguesses(int n){
        this.number_of_guesses = n;
    }

    int takenumberinput(){
        System.out.println("Guess the number");
        Scanner sc = new Scanner(System.in);
        inputnum = sc.nextInt();
        return inputnum;
    }

    boolean isnumcorrect(int num){
        System.out.println("The number is"+number);
        number_of_guesses++;
        if(num == number){
            System.out.format("Yes you have guessed correctly , the number was %d and no of attempts needed is %d " , number,number_of_guesses);
            return true;
        }
        else if(num<number){
            System.out.println("Too Low!!!!");
        }
        else if(num>number){
            System.out.println("Too high!!!!");
        }
        return false;
    }

    

}
public class number_guessing {
    public static void main(String[]args) {
        boolean b = false;
        Game g = new Game();
        while(!b){
        int gn = g.takenumberinput();
        b = g.isnumcorrect(gn);
        System.out.println(b);

        }

    }
}
