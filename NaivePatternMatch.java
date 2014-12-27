/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class NaivePatternMatch {
    public static void main(String [] args){
        String text = "this is a good day , a holiday and I got all day to program";
        String [] patternList = {"obama","osama"," a","go","allda",""};
        for(String x : patternList){
            System.out.println(naive(text,x));
        }
    }
    public static int naive(String text, String pattern){
        int result = -1;
        int lenText = text.length();
        int lenPattern = pattern.length();
        if(lenPattern < lenText){
            int numIterations = lenText-lenPattern;
            for(int i = 0; i < numIterations; i++){
                int j = 0;
                for(; j < lenPattern;j++){
                    if(text.charAt(i+j) != pattern.charAt(j)){
                        break;
                    }
                  
                }
                if(j == lenPattern && lenPattern != 0){
                    result = i;
                    break;
                }
                
        }
      }
        return result;
    }
        
    
}
