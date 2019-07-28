import java.util.List;

class Main{
    public static void main(String[] args) {
        
        StringOperations stringOperations = new StringOperations();

        // System.out.println(stringOperations.revertString("Fonacier"));

        // List<String> suffiexes = stringOperations.getSuffixes("Johnny");
        // for (String s : suffiexes) {
        //     System.out.println(s);
        // }

        // System.out.println(stringOperations.longestCommonPrefix("y", "ohnny"));

        System.out.println(stringOperations.longestRepeatedSubstring("lasddafaqfadafaq"));
    }
}