/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textchaining;

import java.io.IOException;

/**
 *
 * @author Walter
 */
public class TextChaining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\user\\Documents\\NetBeansProjects\\textChaining\\src\\textchaining\\INPUT";
        String MORE = "C:\\Users\\user\\Documents\\NetBeansProjects\\textChaining\\src\\textchaining\\MORE";
        
        TextAnalyzer ta = new TextAnalyzer(filename);
        System.out.println(ta);
        ChainsDisplayer cd = new ChainsDisplayer(ta);
        System.out.println(cd);
        
        /*Text text = new Text();
        text.fillFromFile(filename);
        text.setTreeOfPasses();*/
        
    }   
}
