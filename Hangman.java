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
    private StringBuffer knownSoFar = new StringBuffer();
    private String[] wordList = new String[20];

    
    public Hangman() throws FileNotFoundException {
        maxAllowedIncorrectTries=6;
        chooseSecretWord();
    }
    
    /**
     * it initializes words array from the text file including superhero names and chooses random word from the array
     * @return secret word (as stringbuffer)
     * @throws FileNotFoundException
     */   
    private StringBuffer chooseSecretWord() throws FileNotFoundException {        
        Scanner fileScan = new Scanner(new File("hangman_Words_List.txt"));
        int i = 0;        
        while (fileScan.hasNext()) {
            wordList[i]=fileScan.nextLine();
            i++;
        }
        secretWord = secretWord.append(wordList[(int) (Math.random()*20)]);        
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
}
