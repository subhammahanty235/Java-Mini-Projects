import java.util.Random;
import java.util.Scanner;
class Words{
    private String[]randomwords = {"animal" , "happiness" , "indefinite", "steady", "birthday","extreme","right","properties","ceremony","beneath","infrmation","students","employee"};
    private String selectedword;
    Random rand = new Random();
    private char[] letters;

    Words(){
        int randnum = rand.nextInt(randomwords.length);
        selectedword = randomwords[randnum];
        letters = new char[selectedword.length()];
    }
    public String toString(){
        // String word = "";
        // letters[2] = 'a';
        StringBuilder text = new StringBuilder();

        for(char letter : letters){
            text.append(letter=='\u0000'?'-':letter);
            text.append(' ');
            // if(letter=='\u0000'){
            //     text.append('-');
            // }
            // else{
            //     text.append(letter);
            // }
            // text.append(' ');
        }
        return text.toString();
    }
    public boolean isGuessRight(){
        for(char letter: letters){
            if(letter == '\u0000'){
                return false;
            }
        }
        return true;
    }
    public boolean guess(char l){
        boolean guessedright = false;
        for(int i =0;i<selectedword.length();i++){
            if(l == selectedword.charAt(i)){
                letters[i] = l;
                guessedright = true;
                // break;
            }
        }
        return guessedright;
    }
}

class Guess_Word{
    private boolean play = true;
    private int maxguesses = 10;
    private String userguess ;
    Scanner sc = new Scanner(System.in);
    private Words randomword = new Words();

    public void start(){
        do{
            showword();
            getinput();
            checkinput();
        }while(play);
    }
    void showword(){
        System.out.format("You Have %d chances left to guess the correct word\n" , maxguesses);
        System.out.println(randomword);

    }
    void getinput(){
        System.out.println("Enter a letter to guess the world");
        userguess = sc.nextLine();
    }
    void checkinput(){
        boolean checkguess = randomword.guess(userguess.charAt(0));
        if(checkguess){
            if(randomword.isGuessRight()){
                System.out.println("Congrats! You won");
                play=false;
            }
        }
        else{
            maxguesses--;
            if(maxguesses==0){
                System.out.println("You Lose The Game");
                play=false;
            }
        }
        
    }

    public void end(){
        sc.close();
    }
    
}
public class guess_the_word {
    public static void main(String[]args) {
        Guess_Word game = new Guess_Word();
        game.start();
    }
}
