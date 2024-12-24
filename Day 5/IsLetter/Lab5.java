import letter.Str;

class Lab5 {
    public static void main(String[] args) {
        Str strObj = new Str();
        String s = "222rrr";
        String s2 = "rahma";
        System.out.println("Check s: " + s + "--> using method refernce: "+strObj.onlyAlphabet(s));  //method refernce
        System.out.println("Check s2: "+ s2 +"--> using method refernce: "+strObj.onlyAlphabet(s2));

        System.out.println("Check s: " + s +"--> using my own: " + strObj.isLetter(s));
        System.out.println("Check s2: "+ s +"--> using my own: " + strObj.isLetter(s2));

        
    }
}