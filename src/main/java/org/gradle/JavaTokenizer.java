package org.gradle;

import static org.eclipse.jdt.internal.compiler.parser.TerminalTokens.TokenNameEOF;

import java.util.ArrayList;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.parser.Scanner;

public class JavaTokenizer
{
    private Scanner              scanner          = new Scanner();

    private ArrayList<JavaToken> javaTokens       = new ArrayList<JavaToken>();

    private ArrayList<Integer>   tokenTypes       = new ArrayList<Integer>();

    private ArrayList<String>    tokenExpressions = new ArrayList<String>();

    public JavaTokenizer(String source) throws InvalidInputException
    {
        scanner.recordLineSeparator = true;
        scanner.sourceLevel = ClassFileConstants.JDK1_8;
        scanner.setSource(source.toCharArray());
    }

    public ArrayList<JavaToken> tokenize() throws InvalidInputException
    {
        int tokenType;
        String tokenExpression;

        while ((tokenType = scanner.getNextToken()) != TokenNameEOF)
        {
            tokenExpression = scanner.getCurrentTokenString();
            JavaToken _javatoken = new JavaToken(tokenType, tokenExpression);
            javaTokens.add(_javatoken);
        }

        storeTypesAndExpressions();
        //showAll();
        return javaTokens;
    }

    private void storeTypesAndExpressions()
    {
        for (int i = 0; i < javaTokens.size(); i++)
        {
            JavaToken _javaToken = javaTokens.get(i);
            this.tokenTypes.add(_javaToken.getTokenType());
            this.tokenExpressions.add(_javaToken.getTokenExpression());
        }
    }

    private void showAll()
    {
        for (int i = 0; i < javaTokens.size(); i++)
        {
            JavaToken _javaToken = javaTokens.get(i);
            String tokenDesc = String.format("%5d | %s",
                    _javaToken.getTokenType(), _javaToken.getTokenExpression());
            System.out.println(tokenDesc);
        }
    }

    public ArrayList<JavaToken> getJavaTokens()
    {
        return javaTokens;
    }

    public ArrayList<Integer> getTokenTypes()
    {
        return tokenTypes;
    }

    public ArrayList<String> getTokenExpressions()
    {
        return tokenExpressions;
    }
}
