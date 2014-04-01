/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textchaining;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Walter
 */
public class TextAnalyzer {
    private Text text;
       
    public TextAnalyzer(String filename) throws IOException{
         text = new Text();
         text.fillFromFile(filename);
    }

    private LinkedList<String> longestChain(){
        text.setTreeOfPasses();
        int number = 0, max = text.getLists().get(number).size();
        for(int i = 1; i < text.getLists().size(); ++i){
            if(text.getLists().get(i).size() > max){
                max = text.getLists().get(i).size();
                number = i;
            }
        }
        return text.lists.get(number); 
    }
    
    @Override
    public String toString() {
        return Arrays.deepToString(longestChain().toArray());
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
    
    
}
