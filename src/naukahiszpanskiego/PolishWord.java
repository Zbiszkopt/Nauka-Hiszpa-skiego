/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naukahiszpanskiego;

/**
 *
 * @author Zbyszek
 */
public class PolishWord {
    private String word;
    private String translation;
    
    public PolishWord(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }
    
    public PolishWord(String translation) {
        this.translation = translation;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public String getTranslation() {
        return translation;
    }
    @Override
    public String toString() {
        return word;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
