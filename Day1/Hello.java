class Hello {
    public static void main(String args[]) {
        System.out.println("Hello my instructor ..");
        print();
        
        int len = args.length;
        for (int i = 0; i < len; i++) {
            System.out.println("args arguments: " + args[i] + " ");
        }

        if (len == 0) {
            System.out.println("No arguments");
            return;
        }

        print();
        
        int iterations = -1;
        for (int i = 0; i < len; i++) {
            int convertInt = validateNumber(args[i]);
            
            // if the number is valid and positive 
            if (convertInt > 0) {
                iterations = convertInt;
                System.out.println("Number of iterations is: " + iterations);
              
                for (int j = 1; j <= iterations; j++) {
                    System.out.println("string: " + args[j]);  
                }
                break; 
            } else{
                System.out.println("Skip argument " + args[i] + " (not a valid positive number ...)");
                break;
            }
        }
    }

   
    public static int validateNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;  
        }
    }
    public static void print() {
        System.out.println("--------------------------------------------------");
    }
}

