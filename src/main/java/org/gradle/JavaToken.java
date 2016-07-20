package org.gradle;

public class JavaToken
{
    private int    tokenType;

    private String tokenExpression;

    public JavaToken(int tokenType, String tokenExpression)
    {
        this.tokenType = tokenType;
        this.tokenExpression = tokenExpression;
    }

    protected int getTokenType()
    {
        return tokenType;
    }

    protected void setTokenType(int tokenType)
    {
        this.tokenType = tokenType;
    }

    protected String getTokenExpression()
    {
        return tokenExpression;
    }

    protected void setTokenExpression(String tokenExpression)
    {
        this.tokenExpression = tokenExpression;
    }

}
