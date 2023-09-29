package com.example.AM.model;

import java.util.ArrayList;


    public class ListOfAccounts {

        private ArrayList<Account> accounts;

        // EFFECTS: creates a new ListOfAccounts held, initiated as an empty list
        public ListOfAccounts() {
            accounts = new ArrayList<>();
        }

        // EFFECTS: returns all the accounts that are loan accounts only
        public ArrayList<Account> returnLoans() {
            ArrayList<Account> result = new ArrayList<>();

            for (Account a : accounts) {
                if (a instanceof Loans) {
                    result.add(a);
                }
            }
            return result;
        }

        // EFFECTS: returns all accounts that are savings accounts only
        public ArrayList<Account> returnSaving() {
            ArrayList<Account> result = new ArrayList<>();

            for (Account a : accounts) {
                if (a instanceof Savings) {
                    result.add(a);
                }
            }
            return result;
        }

        // EFFECTS: returns addition of raw amounts of all accounts
        // can be used for when user chooses all accounts and selected accounts raw total is needed
        public int findTotalRaw() {
            int result = 0;
            for (Account a : accounts) {
                result = result + a.getRawAmount();
            }
            return result;
        }

        // MODIFIES: accounts;
        // EFFECTS: adds given account to the list of accounts present
        public void addAccount(Account a) {
            accounts.add(a);
        }


    }


