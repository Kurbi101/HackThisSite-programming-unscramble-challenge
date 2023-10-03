import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class unscramble {  
    
    public static void main(String[] args) throws Exception {
        List<String> parsedWordList = parseWordList("scrambledWordList.txt");
        List<String> parsedInputWordList = parseWordList("inputWordList.txt");
        System.out.println(getAnswer(parsedWordList, parsedInputWordList));
    }

    public static List<String> parseWordList(String adress){
        List<String> words = new ArrayList<String>();
        try  
            {  
        File file=new File(adress);   
        Scanner sc = new Scanner(file);      
        while (sc.hasNextLine())  {
            words.add((sc.nextLine()));
        }         
        
            } catch(Exception e) {
                System.out.println("Oops" + e.getMessage());
            }
        return (words);
            
    }
    
    public static List<String> sortStringsByASCII(List<String> inputList) {
        List<String> sortedStrings = new ArrayList<>();

        for (String str : inputList) {
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length - 1; i++) {
                for (int j = i + 1; j < charArray.length; j++) {
                    if (charArray[i] > charArray[j]) {
                        char temp = charArray[i];
                        charArray[i] = charArray[j];
                        charArray[j] = temp;
                    }
                }
            }
            sortedStrings.add(new String(charArray));
        }

        return sortedStrings;
    }
    public static String sortStringByASCII(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] > charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        return new String(charArray);
    }

    public static String getAnswer(List<String> inputList, List<String> scrambledInput){
        String answer = "";
        for(String str : scrambledInput){
            for(String x : inputList){
                if(sortStringByASCII(str).equals(sortStringByASCII(x))){
                    
                    answer += x + ",";
                    break;
                }
            }
        }
        answer = answer.substring(0, answer.length()-1);
        return answer; 
    }
}








    
    

