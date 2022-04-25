package com.company;

public class Virus {
    private final String name;
    private final int code;

    // Constructor
    public Virus(String pName, int pCode)
    {
        name = pName;
        code = pCode;
    }

    // Methods
    public void printVirus()
    {
        System.out.printf("\nVirus name: %s\n", name);
        System.out.printf("code: %d\n", code);
    }

    public int getCode()
    {
        return code;
    }
}
