/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textchaining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Text {
    
    private LinkedList<String> queuepool, copyOf;
    protected LinkedList<LinkedList<String>> lists;
    
    public Text(){
        queuepool = new LinkedList<>();
    };
    
    public Text(String[] text){
        queuepool = new LinkedList<>();
        for(int i = 0; i < text.length; ++i){
            queuepool.offer(text[i]);
        }
        lists = new LinkedList<>();
        
    }
    
    public void fillFromFile(String filename) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String line;
        int i = 0;
        while((line = reader.readLine()) != null){
            Scanner scanner = new Scanner(line);
            while(scanner.hasNext()){
                queuepool.offer(scanner.next());
                ++i;
            }
        }
        lists = new LinkedList<>();
        reader.close();
    }
    
    public Queue<String> alphaHash(LinkedList<String> queue){
        Queue<String> list = new LinkedList<>();
        for(String str: queue){
            if(str.matches("[a-zA-Z]{1,}[,.?!]")){
                str = str.substring(0, str.length() - 1);
            }
            list.offer(str);
        }
        return list;
    }
    
    public void setTreeOfPasses(){
        int i = 0;
        copyOf = (LinkedList<String>) queuepool.clone();
        while(i < copyOf.size()){
            lists.push(new LinkedList<String>()); 
            copyOf = (LinkedList<String>) queuepool.clone();
            addTreeNodes(copyOf.get(i));
            ++i;
        } 
        for(int j = 0 ; j < lists.size(); ++j){
            Collections.reverse(lists.get(j));
        }
    }
    
    private void addTreeNodes(String str){
        if(!lists.getFirst().contains(str)){
            for(int j = 0; j < copyOf.size(); ++j){ 
                if(str.toCharArray()[str.length()-1] == copyOf.get(j).toString().toCharArray()[0]){
                    if(lists.getFirst().isEmpty()){
                        lists.getFirst().push(str); 
                        addTreeNodes(copyOf.get(j));
                    } else if(lists.getFirst().indexOf(str) != lists.getFirst().size()-1 && !lists.getFirst().contains(str)){
                        lists.getFirst().push(str); 
                        addTreeNodes(copyOf.get(j));
                    } else {
                        lists.push(new LinkedList<>(lists.getFirst().subList(lists.getFirst().indexOf(str), lists.getFirst().size())));                      
                        addTreeNodes(copyOf.get(j));
                    }
                } else if(!lists.getFirst().contains(str)){
                    lists.getFirst().push(str); 
                }
            } 
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(String str: queuepool){
            sb.append(str).append(" ");
        }
        return sb.toString();
    }
    
    
    public Queue<String> getQueuepool() {
        return queuepool;
    }

    public void setQueuepool(LinkedList<String> queuepool) {
        this.queuepool = queuepool;
    }

    public LinkedList<LinkedList<String>> getLists() {
        return lists;
    }

    public void setLists(LinkedList<LinkedList<String>> lists) {
        this.lists = lists;
    }
    
    
}
