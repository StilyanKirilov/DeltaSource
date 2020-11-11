import java.util.ArrayDeque;

public class DeltaSource {
    public static void main(String[] args) {
        String expression1 = "ACABbBbaca";
        String expression2 = "AabB";
        String expression3 = "BCAcaB";
        System.out.println(isValidExpression(expression1));
        System.out.println(isValidExpression(expression2));
        System.out.println(isValidExpression(expression3));
    }

    private static boolean isValidExpression(String expression) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        if (expression == null || expression.length() < 2) {
            // Checking if the given string is not null or less than 2 characters
            return false;
        }

        for (int i = 0; i < expression.length(); i++) {
            char currentLetter = expression.charAt(i);
            if (currentLetter >= 65 && currentLetter <= 67) { // Checking if the letter is A, B or C

                stack.push(currentLetter);

            } else if (!stack.isEmpty() && currentLetter >= 97 && currentLetter <= 99) { // If its not capital A, B or C
                                                                                         // im checking if the letter is not lowercase(a,b or c)
                Character lastUpperCase = stack.peek();

                if (lastUpperCase + 32 == currentLetter) {
                    stack.pop();
                } else {
                    /* if the letter is lowercase and its not our last Uppercase
                       letter then the expression is not valid and we return false */
                    return false;
                }
            } else {
                // if the letter is something other than A,B,C or a,b,c were returning false because its not valid
                return false;
            }
        }

        return true;
    }

//  AaBb - true
//  BCAacb - true
//  BCcAab - true
//  ACABbBbaca - true
//  AabB - false
//  BCAcaB - false
}
