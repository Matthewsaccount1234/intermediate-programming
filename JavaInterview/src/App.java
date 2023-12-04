import java.util.Scanner; 

public static class App {

    
    public static void main(String[] args) throws Exception {
        Scanner name_input = new Scanner(System.in);
        System.out.println("What is your name");
        String name = name_input.nextLine();
        System.out.println("Hello " + name);
        
        Scanner ice_input = new Scanner(System.in);
        System.out.println("What is your favorite flavor of ice cream");
        String ice_cream = ice_input.nextLine();
        if (ice_cream.length() > 7) {
            System.out.println("I like " + ice_cream + " too");
        }
        else {
            System.out.println( "I don't like " + ice_cream);
        }
       

    }
}
