package com.company.StacksAndQueues;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class BalancedBrackets {

    // TODO: 2/1/2022 GET CLASS SOLUTION AND EXAMINE CODE

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        if (s.length() % 2 != 0) {
            return "NO";
        }

        Stack<String> bracketStack = new Stack<>();

        HashSet<String> bracketRef = new HashSet<>();
        bracketRef.add("()");
        bracketRef.add("[]");
        bracketRef.add("{}");

        for (int i = 0; i < s.length(); i++) {
            bracketStack.push(s.substring(i, i + 1));
        }

        while (bracketStack.size() > 1) {
            if (!bracketRef.contains(bracketStack.firstElement() + bracketStack.peek())) {
                if (bracketRef.contains(bracketStack.get(bracketStack.size() - 2) + bracketStack.peek())) {
//                    System.out.println(bracketStack.get(bracketStack.size() - 2) + bracketStack.peek());
                    bracketStack.remove(bracketStack.size() - 2);
                    bracketStack.pop();
                } else if (bracketRef.contains(bracketStack.firstElement() + bracketStack.get(1))) {
//                    System.out.println(bracketStack.firstElement() + bracketStack.get(1));
                    bracketStack.remove(bracketStack.firstElement());
                    bracketStack.remove(bracketStack.get(1));
                } else {
                    return "NO";
                }
            } else {
                bracketStack.pop();
                bracketStack.remove(bracketStack.firstElement());
//                System.out.println(bracketStack);
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
//        System.out.println(isBalanced("{[(])}")); //Should return NO
//        System.out.println(isBalanced("{[()]}")); //Should return YES
//        System.out.println(isBalanced("{{[[(())]]}}"));//should return YES

//        System.out.println(isBalanced("{(([])[])[]}")); //should return YES

//        System.out.println(isBalanced("{(([)[])[]]}")); //should return NO
//
        System.out.println(isBalanced("{(([])[])[]}[]")); //should return YES


    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

}