import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StringOperations {

    public String revertString(String text){

        // String --> O(N*N) StringBuilder --> O(N);
        int lengthOfText = text.length(); // O(1);
        StringBuilder reversedString = new StringBuilder();

        for(int i = lengthOfText - 1; i >= 0; i--){ // O(N)
            reversedString.append(text.charAt(i)); // O(1)      O(N) + O(1) = O(N)
        }

        return reversedString.toString();
    }

    public List<String> getPrefixes(String text){

        int lengthOfText = text.length();
        List<String> prefixesList = new ArrayList<>();

        // for (int i = lengthOfText - 1; i >= 0; i--) 
        for (int i = 0; i < lengthOfText + 1; i++) 
        {
            prefixesList.add(text.substring(0, i));
        }

        return prefixesList;
    }

    public List<String> getSuffixes(String text){

        int lengthOfText = text.length(); // O(1)
        List<String> suffixesList = new ArrayList<>();

        for (int i = 0; i < lengthOfText; i++)
        {
            suffixesList.add(text.substring(i, lengthOfText)); // O(1)
        }

        return suffixesList;
    }

    // note prefix only means it will only compare the first characters and if it is null then it will stop then return.
    public String longestCommonPrefix(String text1, String text2){

        int commonLength = Math.min(text1.length(), text2.length());

        for (int i = 0; i < commonLength; i++) {
            if(text2.charAt(i) != text1.charAt(i)){
                return text1.substring(0, i);
            }
        }
        System.out.println("debug test");
        return text1.substring(0, commonLength); // dummy
    }


    public String longestRepeatedSubstring(String text){

        // int lengthOfText = text.length();
        // List<String> suffixes = getSuffixes(text);
        // Collections.sort(suffixes); // the time complexity can be changed
        // String longestSubstring = "";

        // for (int i = 0; i < lengthOfText - 1; i++) {
            
        //     String tempString = longestCommonPrefix(suffixes.get(i), suffixes.get(i + 1));

        //     if( tempString.length() > longestSubstring.length() ){
        //         longestSubstring = tempString;
        //     }
        // }
        // return longestSubstring;

        
        int N = text.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = text.substring(i, N); // first form a substring 
        }

        Arrays.sort(suffixes); // second sort

        String lrs = "";
        for (int i = 0; i < N-1; i++) { // find the longest LCP among adjacent entries
            String temp = longestCommonPrefix(suffixes[i], suffixes[i+1]);
            if(temp.length() > lrs.length()){
                lrs = temp;
            }
        }

        return lrs;
        // https://www.coursera.org/lecture/cs-algorithms-theory-machines/longest-repeated-substring-hkJBt
        // at 10:19
    }

}