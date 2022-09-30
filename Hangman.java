import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private String[] wordList = new String[20]; 
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private final int MAX_INCORRECT_TRIES = 6;

    public Hangman() throws FileNotFoundException {
        secretWord = chooseSecretWord();
        maxAllowedIncorrectTries = MAX_INCORRECT_TRIES;
        initKnownSoFar();
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);

        System.out.println("The word is:");
        System.out.println(this.getKnownSoFar() + "\n");

        while(!this.isGameOver()) {
            System.out.println("Enter a (1)letter or (2)the word to guess");
            int choice = input.nextInt();
            while(choice<1 || choice>2) {
                choice = input.nextInt();
            }
            if(choice == 1) {
                System.out.println("Enter a letter:");
                char ch = input.next().charAt(0);

                System.out.println("The letter has occurred " + this.tryThis(ch) + " times.");
                System.out.println("Known so far is:");
                this.revealKnownLetters(ch);
                System.out.println(this.getKnownSoFar());
    
                if(this.tryThis(ch) == 0) {
                    this.incrementNumberOfIncorrectTries();
                }
            }
            else if(choice == 2) {
                System.out.println("Enter your guess:");
                String guess = input.next();
                if(this.tryThis(guess) == 0) {
                    this.incrementNumberOfIncorrectTries();
                }
                else {
                    //kelimenin tamamı denencek
                }
            }
        }
        if(this.hasLost()) {
            System.out.println("You Lost!");
        }
        else{
            System.out.println("You Won!");
        }
        input.close();
    }

    public void initKnownSoFar() {
        this.knownSoFar = new StringBuffer();
        for(int i=0; i<this.secretWord.length(); i++) {
            this.knownSoFar = this.knownSoFar.append("_");
        }
    }

    public void revealKnownLetters(char ch) {
        for(int i=0; i<this.secretWord.length(); i++) {
            if(this.secretWord.charAt(i) == ch) {
                this.knownSoFar.setCharAt(i, ch);
            }
        }
    }

    public int tryThis(String str) {
        if(this.secretWord.toString().equals(this.knownSoFar.toString())) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int tryThis(char ch) {
        int count = 0;
        for(int i=0; i<this.secretWord.length(); i++) {
            if(this.secretWord.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public boolean isGameOver() {
        return numberOfIncorrectTries > MAX_INCORRECT_TRIES || this.secretWord.toString().equals(this.knownSoFar.toString()); 
    }

    public boolean hasLost() {
        return numberOfIncorrectTries > MAX_INCORRECT_TRIES;
    }

    public void incrementNumberOfIncorrectTries() {
        this.numberOfIncorrectTries++;
    }

    private StringBuffer chooseSecretWord() throws FileNotFoundException {
        secretWord = new StringBuffer();
        Scanner fileScan = new Scanner(new File("hangman_Words_List.txt"));
        int i = 0;        
        while (fileScan.hasNext()) {
            wordList[i]=fileScan.nextLine();
            i++;
        }
        secretWord = secretWord.append(wordList[(int) (Math.random()*21)]);        
        fileScan.close();
        return secretWord;
    }

    public StringBuffer getAllLetters() {
        return allLetters;
    }

    public StringBuffer getUsedLetters() {
        return usedLetters;
    }

    public int getNumOfIncorrectTries() {
        return numberOfIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries() {
        return maxAllowedIncorrectTries;
    }    

    public StringBuffer getKnownSoFar() {
        return knownSoFar;
    }

    public void setUsedLetters(char ch) {
        usedLetters = this.usedLetters.append(ch);
    }
}
