package org.gradle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jdt.core.compiler.InvalidInputException;

public class Main
{

    public static void main(String[] args) throws IOException,
            InvalidInputException
    {
        // store keywords (token types and expressions)
        String source = String.join(
                "\r\n",
                Files.readAllLines(Paths.get("src/main/resources/org/gradle/keyword_java.csv")));

        JavaTokenizer keywords = new JavaTokenizer(source);
        keywords.tokenize();
        // showTokens(keywords);

        // tokenize source code
        source = String.join(
                "\r\n",
                Files.readAllLines(Paths.get("src/main/resources/org/gradle/Insertion.java")));

        JavaTokenizer codeOfInterest = new JavaTokenizer(source);
        codeOfInterest.tokenize();
        // showTokens(codeOfInterest);

        // match appeared token type of tokenized code with keywords
        Integer[] numberOfAppearance = new Integer[keywords.getTokenTypes().size()];
        Arrays.fill(numberOfAppearance, 0);

        // store token type into array list  
        ArrayList<Integer> keywordTypes = keywords.getTokenTypes();
        ArrayList<Integer> tokenTypes = codeOfInterest.getTokenTypes();

        int index;
        for (int i = 0; i < tokenTypes.size(); i++)
        {
            if ((index = keywordTypes.indexOf(tokenTypes.get(i))) != -1)
            {
                numberOfAppearance[index]++;
            }
        }

        // output result as a CSV file
        for (int i = 0; i < numberOfAppearance.length; i++)
        {
            String tokenDesc = String.format("%10s | %3d",
                    keywords.getTokenExpressions().get(i),
                    numberOfAppearance[i]);
            System.out.println(tokenDesc);
        }

    }

    // print function for debug
    private static void showTokens(JavaTokenizer javaTokenizer)
    {
        for (int i = 0; i < javaTokenizer.getTokenTypes().size(); i++)
        {
            String tokenDesc = String.format("%5d | %s",
                    javaTokenizer.getTokenTypes().get(i),
                    javaTokenizer.getTokenExpressions().get(i));
            System.out.println(tokenDesc);
        }
    }
}
