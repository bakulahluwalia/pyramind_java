/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramiddriver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author ahluwaliab8511
 */
public class Pyramid {
    static int intInputdigit, intInputLines;
    static List<Integer> first = new ArrayList<Integer>(50); 
    public static void read() {
        Scanner sc = new Scanner(System.in);        
        while (true) {
            System.out.println("Please enter a positive single digit Number:");
            String input = sc.next();            
            try {
                intInputdigit = Integer.parseInt(input); 
                if(intInputdigit < 1 || intInputdigit > 9){                
                continue;                
                }                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input is not a single digit positive number, Please Enter a valid number");                
            }
        }
        while (true) {
            System.out.println("Please enter the number of lines in the pyramid:");
            String lines = sc.next();
            try {
                intInputLines = Integer.parseInt(lines);                
                break;
            } catch (NumberFormatException e){
                System.out.println("Input is not a number, Please Enter a valid number");             
            }
        }        
    }
    
    public static void printPyramid() {        
        int meta = 0;
        int skipped, inc = 0;        
        int c = 5;
		boolean foundDuplicateRow = false;
        first.add(intInputdigit);
        for (int j=0; j < 5; j++){
            System.out.print(" ");
        }
        System.out.println(intInputdigit);
        for(int k = 0; k < intInputLines-1; k++){
            for (int j=0; j < c-1; j++)
            {
                System.out.print(" ");
            }
            c = c - 1;            
            
            if(intInputdigit == 1 && inc >= 1){
                System.out.print(" ");
                if(inc >= 3 && inc < 8){
                    System.out.print(" ");                    
                }  
            }
            if(intInputdigit == 2 && inc >= 2){
                System.out.print(" ");
                if(inc >= 4 && inc < 7){
                    System.out.print(" ");                    
                }  
            }
            if(intInputdigit == 3 && inc >= 2){
                System.out.print(" ");
                if(inc >= 3 && inc < 8){
                    System.out.print(" ");                    
                }  
            }
            if((intInputdigit == 4) ){
                if(inc == 2){
                    System.out.print(" ");                    
                }                
                if(inc == 3){
                    System.out.print(" ");                    
                }    
            }
            if(intInputdigit >= 5 && inc >= 2 && inc < 6){
                System.out.print(" ");
            }
            List<Integer> second = new ArrayList<Integer>(10);
            skipped = 0;
            for (Integer data : first) {
                meta = getcount(first,data);
                if(meta > 1){
                        if(meta-1 != skipped){
                                skipped++;
                        continue;
                        }
                }
                second.add(meta);
                if(data > 0){
                    System.out.print(meta + " " + data+ "");
                    if(meta > 1){
                        skipped = 0;
                    }
                }
            }
            System.out.println("");
            if(foundDuplicateRow == true){
            break;
            }
            Set<Integer> checkValues = new HashSet<Integer>(first);
            if(checkValues.contains(1) && checkValues.contains(2) && checkValues.contains(3) && checkValues.contains(4) && checkValues.contains(5) && checkValues.contains(6) && checkValues.contains(7) && checkValues.contains(8) && checkValues.contains(9)){
            break;
            }
            List<Integer> duplicateCheck = new ArrayList<Integer>(50); 
            duplicateCheck = first;            
            first = concat(first, second);                        
            first.sort(null);
            if(duplicateCheck.equals(first)){
                foundDuplicateRow = true;
            }            
            inc++;
        } 
            
    }
    
    public static void printDigits() {
        Set<Integer> uniqueValues = new HashSet<Integer>(first);
        System.out.print("The Digits ");
        System.out.print(uniqueValues.toString().replace("[","").replace("]",""));                
        System.out.print(" were used."); 
    }
    static List<Integer> concat(List<Integer> x, List<Integer> y) {
        List<Integer> result = new ArrayList<Integer>(10);
        int value = 0;
        int number = 0;
        Integer[] arr = new Integer[x.size()];
        arr = x.toArray(arr);
        for (Integer count : y) {
            if(count != 0){   
                if(count == 1 || count == 2){
                    result.add(count);
                }
                value = value+count;
                number = arr[value-1];
                if(count > 2){
                        arr[0] = arr[count];
                        result.add(count);
                        result.add(number);
                }
                else{

                        result.add(number);
                }
            }
        }
        return result;   
    }

    static int getcount(List<Integer> x, int newItem){        
        int count = 0;
        for(int m = 0; m < x.size(); m++){
            if(x.get(m) == newItem){                    
                    count++;                
                }                
        }
        return count;
    }
}

 
