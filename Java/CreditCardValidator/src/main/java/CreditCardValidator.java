/**
 * Created by lew on 9/25/14.
 */
public class CreditCardValidator {
    public static void main(String [] args){
        String ccNumber = "5148-6250-9443-9581";
        System.out.println(String.format("Credit card number %s is valid? %b", ccNumber, creditCardValidator(ccNumber.replaceAll("-",""))));
    }

    //Luhn Formula:

    private static boolean creditCardValidator(String ccNumber){
        //Drop the last digit from the number. The last digit is what we want to check against
        Integer checkDigit = Character.getNumericValue(ccNumber.charAt(ccNumber.length() - 1));

        //Reverse the numbers
        //Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
        //Add all the numbers together
        StringBuffer buf = new StringBuffer(ccNumber.substring(0, ccNumber.length()-1));
        buf.reverse();
        Integer sum = 0;
        for(int i=0; i<buf.length(); i++){
            int number = Character.getNumericValue(buf.charAt(i));
            if((i+1) % 2 == 1) {
                number *= 2;
                if(number > 9)
                    number -= 9;
            }

            sum += number;
        }
        //The check digit (the last number of the card) is the amount that you would need to add to get a multiple of 10 (Modulo 10)
        return (sum + checkDigit) % 10 == 0;
    }

}
