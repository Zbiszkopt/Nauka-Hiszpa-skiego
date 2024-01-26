/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naukahiszpanskiego;

/**
 *
 * @author Zbyszek
 */
public class SpanishWord {
        private String word;
        
    public SpanishWord(String word) {
        this.word = word;
    }   


    public String getWord() {
        return word;
    }

@Override
    public String toString() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }



}
