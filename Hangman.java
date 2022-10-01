import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hangman
 */
public class Hangman {

    private StringBuffer secretWord = new StringBuffer();
    private StringBuffer allLetters = new StringBuffer();
    private StringBuffer usedLetters = new StringBuffer();
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private StringBuffer knownSoFar;
    private String[] wordList = new String[20];
    private boolean isGameOver = false;

    
    Hangman() throws FileNotFoundException {
        this.maxAllowedIncorrectTries=6;
        chooseSecretWord();
        this.numberOfIncorrectTries = 0;
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);

        System.out.println("The word is:");
        System.out.println(this.getKnownSoFar() + "\n");

        while(!this.isGameOver()) {
            System.out.println("Enter a (1) letter or (2) the word to guess");
            int choice = input.nextInt();
            while(choice<1 || choice>2) {
                choice = input.nextInt();
            }
            if(choice == 1) {
                System.out.println("Enter a letter:");
                String ch = input.next();

                System.out.println("The letter has occurred " + this.tryThis(ch) + " times.");
                System.out.println();
                System.out.println("Known so far is:");
                System.out.println(this.getKnownSoFar());
    
            }
            else if(choice == 2) {
                System.out.println("Enter your guess:");
                String guess = input.next();
                if(this.tryThisWord(guess)) {
                    break;
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
    /**
     * it initializes words array from the text file including superhero names and chooses random word from the array
     * @return secret word (as stringbuffer)
     * @throws FileNotFoundException
     */   
    private StringBuffer chooseSecretWord() throws FileNotFoundException {
        File hangmanFile = new File("wordList.txt");
        Scanner fileScan = new Scanner(hangmanFile);
        int i = 0;        
        while (fileScan.hasNext()) {
            wordList[i]=fileScan.nextLine();
            i++;
        }
        secretWord = secretWord.append(wordList[(int) (Math.random()*21)]);
        this.knownSoFar = new StringBuffer(secretWord.length());
        for(int j = 0; j < secretWord.length(); j++){
            this.knownSoFar = this.knownSoFar.append("*");
        }       
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
    
    public StringBuffer getKnownSoFar(){
        return knownSoFar;
    }
    

    public int tryThis(String letter){
        int numOfOccur = 0;
        letter = letter.toUpperCase();
        usedLetters = usedLetters.append(letter + ",");
        String secretLetter;
        for(int i = 0; i < secretWord.length(); i++){
            secretLetter = Character.toString(secretWord.charAt(i));
            if(secretLetter.equals(letter)){
                knownSoFar = knownSoFar.deleteCharAt(i);
                knownSoFar = knownSoFar.insert(i, secretLetter);
                numOfOccur++;
            }
        }
        
        if(numOfOccur == 0){
            this.numberOfIncorrectTries++;
        }
        return numOfOccur;
    }
    public boolean tryThisWord(String word){
        String secret = this.secretWord.toString();
        if(word.equalsIgnoreCase(secret)){
            isGameOver = true;
            return true;
        }
        else{
            this.numberOfIncorrectTries++;
            return false;
        }
    }

    public boolean isGameOver(){
        return numberOfIncorrectTries >= maxAllowedIncorrectTries || this.secretWord.toString().equals(this.knownSoFar.toString()); 
    }

    public boolean hasLost(){
        return numberOfIncorrectTries >= maxAllowedIncorrectTries;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Hangman den = new Hangman();
        /*String harf;
        Scanner scan = new Scanner(System.in);
        System.out.println(den.secretWord);
        System.out.println(den.knownSoFar);
        harf = scan.nextLine();
        den.tryThis(harf);
        System.out.println(den.numberOfIncorrectTries);
        
        System.out.println(den.knownSoFar);*/
        den.playGame();
        
    }
}

