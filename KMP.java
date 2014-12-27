/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class KMP {
    public static void KMP_match(String text, String pattern ){
        int lenPattern = pattern.length();
        int lenText = text.length();
        if(lenText > lenPattern){
            // create array for computing longest proper prefix = longest proper suffix
            int [] array = new int [lenPattern];
            computePI(pattern, array);
        
             int matchSoFar = 0;
             int index = 0;
             while (index < lenText){
                 // if there is a match , increment both index and MatchSoFar
                 if(text.charAt(index) == pattern.charAt(matchSoFar)){
                    index+= 1;
                    matchSoFar += 1;
                 }
                 // if match complete
                 if(matchSoFar == lenPattern){
                    System.out.println("Match starting at index "+ (index -lenPattern));
                    matchSoFar = array[matchSoFar-1];
                }
                 // if mismatch occurs 
                if(text.charAt(index) != pattern.charAt(matchSoFar)){
                    // until and unless there is a match keep on decrementing matchSoFar
                    if(matchSoFar != 0){
                        matchSoFar = array[matchSoFar-1];
                    }
                    else{
                        // there was complete mismatch , no proper suffix or proper prefix 
                        index += 1;
                    }
                 }
            
             }
        
         }
        else{
            System.out.println("pattern greater in size than the text itself :(");
        }
        
    }
    public static void computePI(String pattern, int [] array){
       int lenPat = pattern.length();
       // variable to keep track for match upto current index
       int matchSoFar = 0;
       // no proper prefix and proper suffix exist for single length string
       array[0] = matchSoFar;
       int index = 1;
       // compute array for i = 1 to string length -1 
       while (index < lenPat){
           // if there is a match , increment both the pointers
           if(pattern.charAt(index ) == pattern.charAt(matchSoFar)){
               matchSoFar += 1;
               array[index] = matchSoFar;
               index+= 1;
           }
           else{
               // if thereis complemety no proper prefix and proper suffix for the current position
               // if this is not the case then , after reducing matchSoFar , next iteration 
               // will enter into the matching if condition
               if(matchSoFar == 0){
                   array[index] = matchSoFar;
                   index += 1;
               }
               else{
                   // reduce the matchSoFar, to see if the previous matches give the proper suffix and proper prefix
                   matchSoFar = array[matchSoFar-1];
               }
               
           }
       }
       for(Integer x: array){
           System.out.print(x+" ");
       }
        System.out.println("");
    }
    public static void main(String [] args){
        String [] patternList = {"AABAACAABAA","ABCDE", "AAAAA", "AAABAAA", "AAACAAAAAC"};
        for (String pattern : patternList){
            int [] temp = new int [pattern.length()];
            computePI(pattern,temp);
        }
    }
}
