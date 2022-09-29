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
        maxAllowedIncorrectTries=6;
        chooseSecretWord();
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
        secretWord = secretWord.append(wordList[(int) (Math.random()*20)]);
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
            numberOfIncorrectTries++;
        }
        return numOfOccur;
    }

    public boolean isGameOver(){
        if(hasLost()){
            isGameOver = true;
        }
        return isGameOver;
    }

    public boolean hasLost(){
        if(numberOfIncorrectTries >= maxAllowedIncorrectTries){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Hangman den = new Hangman();
        String harf;
        Scanner scan = new Scanner(System.in);
        System.out.println(den.secretWord);
        System.out.println(den.knownSoFar);
        harf = scan.nextLine();
        den.tryThis(harf);
        System.out.println(den.knownSoFar);
    }
}

