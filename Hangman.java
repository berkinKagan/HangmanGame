/**
 * Hangman
 */
public class Hangman {

    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private StringBuffer knownSoFar;

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
