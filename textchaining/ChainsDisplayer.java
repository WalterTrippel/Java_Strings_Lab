/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textchaining;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Walter
 */
public class ChainsDisplayer {
    private LinkedList<LinkedList<String>> lists;
    
    public ChainsDisplayer(TextAnalyzer ta){
        this.lists = ta.getText().lists;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("\nAll chains :\n\n");
        while(!lists.isEmpty()){
            sb.append(Arrays.deepToString(lists.pop().toArray())).append("\n");
        }
        return sb.toString();
    }
    
    
}
