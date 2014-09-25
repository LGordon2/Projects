import java.util.*;
import java.util.logging.Logger;

/**
 * Created by lew on 9/25/14.
 */
public class PrimeFactorization {

    private static final Logger log = Logger.getLogger(PrimeFactorization.class.toString());

    public static void main(String [] args){
        Long number = 1679L;
        Set<Long> allPrimes = findPrimeFactorizations(number);
        List<Long> allPrimesSorted = new ArrayList<>(allPrimes);
        Collections.sort(allPrimesSorted);
        System.out.println(String.format("Prime factors for %d: %s", number, allPrimesSorted));
    }

    /**
     * Have the user enter a number and find all Prime Factors (if there are any) and display them.
     * @param number
     * @return All prime factors (if there are any)
     */
    public static Set<Long> findPrimeFactorizations(Long number){
        Set<Long> foundPrimes = new HashSet<>();
        Set<Long> primeFactorizations = new HashSet<>();
        Long nextPrime;

        for(long i=1L; i<number; i++){
            nextPrime = findNextPrime(foundPrimes, i);
            if(nextPrime == -1L){
                return primeFactorizations;
            }

            if(number % nextPrime == 0){
                primeFactorizations.add(nextPrime);
                primeFactorizations.addAll(findPrimeFactorizations(number / nextPrime));
                return primeFactorizations;
            }

            foundPrimes.add(nextPrime);
        }
        return primeFactorizations;
    }

    private static Long findNextPrime(Set<Long> foundPrimes, Long number) {
        if(foundPrimes.size() == 0){
            return 2L;
        }
        while(!isPrime(foundPrimes, number)){
            number++;
        }
        return number;
    }
    private static boolean isPrime(Set<Long> foundPrimes, Long number){
        for(Long prime : foundPrimes){
            if(number % prime == 0){
                return false;
            }
        }
        return true;
    }
}
