package com.example.AM.model;

public class User {

    private String username;
    private String hashedPassword;
    private String salt;

    private ListOfAccounts accounts;

    // EFFECTS: creates a new User with given username, hashedPassword and salt, and an empty list of accounts
    public User(String username, String hashedPassword, String salt) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.accounts = new ListOfAccounts();
    }

    // MODIFIES: accounts
    // EFFECTS: adds given account to the users list of accounts
    public void addAccountToUser(Account a) {
        accounts.addAccount(a);
    }

    // EFFECTS: returns username of given user
    public String getUsername() {
        return username;
    }

    // EFFECTS: returns hashedPassword
    public String getHashedPassword() {
        return hashedPassword;
    }

    // EFFECTS; returns salt allocated to this particular account;
    public String getSalt() {
        return salt;
    }
}
