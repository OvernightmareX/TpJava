package org.example.autres;

public class Pendu {
    private String mask = "";
    private int nbTry;
    private String wordToFind;

    public Pendu() {
    }

    public Pendu(int nbTry, String wordToFind) {
        this.nbTry = nbTry;
        this.wordToFind = wordToFind;

        for(int i =0; i<wordToFind.length();i++){
            mask += "*";
        }
    }

    public void testChar(char inputCharacter){

    }

    public void testWin(){

    }

    public String getMask() {
        return mask;
    }

    public int getNbTry() {
        return nbTry;
    }

    public String getWordToFind() {
        return wordToFind;
    }

}
