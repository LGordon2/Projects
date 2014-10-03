import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by lew on 10/3/14.
 */
public class NextPrime {
    private static SortedSet<Integer> primes;

    public static void main(String [] args){
        primes = new TreeSet<Integer>();

        while(prompt()){
            System.out.println(getNextPrime());
        }
    }

    private static boolean prompt() {
        System.out.print("Would you like the next prime number? (y/n): ");
        Scanner sc = new Scanner(System.in);
        String yesOrNo = sc.next();
        if(yesOrNo.equalsIgnoreCase("y")){
            return true;
        }else if(yesOrNo.equalsIgnoreCase("n")){
            return false;
        }else{
            System.out.println("Please enter y or n.");
            return prompt();
        }
    }

    private static Integer getNextPrime(){
        if(primes.size() == 0) {
            primes.add(2);
            return 2;
        }

        int i=primes.last();
        boolean found;
        while(true){
            found = false;
            for(Integer prime : primes){
                if(i % prime == 0){
                    found = true;
                    break;
                }
            }
            if(!found){
                primes.add(i);
                return i;
            }
            i++;
        }
    }
}
