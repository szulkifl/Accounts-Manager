package com.example.AM.model;

public class Account {

    private String accountID;
    private String nameOfInstitution;
    private float percentageInvolved;
    private int rawAmount;

    public Account(String accountID, String nameOfInstitution, float percentageInvolved, int rawAmount) {
        this.accountID = accountID;
        this.nameOfInstitution = nameOfInstitution;
        this.percentageInvolved = percentageInvolved;
        this.rawAmount = rawAmount;
    }

    // EFFECTS: returns accountID of user
    public String getAccountID() {
        return accountID;
    }

    // EFFECTS: returns nameOfInstitution
    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    // EFFECTS: returns percentageInvolved
    public float getPercentageInvolved() {
        return percentageInvolved;
    }

    // EFFECTS: returns rawAmount
    public int getRawAmount() {
        return rawAmount;
    }

}
