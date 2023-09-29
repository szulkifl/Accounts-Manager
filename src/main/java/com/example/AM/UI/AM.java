package com.example.AM.UI;

import com.example.AM.model.AuthenticationAlgorithm;
import com.example.AM.model.Exceptions.UserExistsException;
import com.example.AM.model.Exceptions.UserNotThereException;
import com.example.AM.model.ListOfUsers;

import java.util.Locale;
import java.util.Scanner;

public class AM {

    private Scanner input;
    private ListOfUsers users;

    public AM() {
        assert users != null;
        users = ListOfUsers.getInstance();
        runAccountsManager();
    }

    public void runAccountsManager() {
        boolean keepGoing = true;
        String command = null;

        init();
        while (keepGoing) {
          command = input.next();
          command = command.toLowerCase(Locale.ROOT);

          if (command.equals("q")) {
              keepGoing = false;
          } else {
              keepGoing = false;
          }
        }
    }

    public void init() {

        users = ListOfUsers.getInstance();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        System.out.println("Sign in");
        System.out.println("Sign up");
        String command = input.next();
        if (command.equals("Sign in")) {
            signIn();
        } else if (command.equals("Sign up")) {
            registerUser();
        }
    }

    // EFFECTS: creates a new Authentication algorithm for registration and registers user with given username and pass
    private void registerUser() {
        AuthenticationAlgorithm regAlg = new AuthenticationAlgorithm();
        System.out.println("Username:");
        String username = input.next();
        System.out.println("Password");
        String password = input.next();
        try {
            regAlg.registerUser(username, password);
        } catch (UserExistsException e) {
            System.out.println("User by the name of" + " " + username + " already exists");
        }
    }

    // EFFECTS: creates a new Authentication Algorithm for signing in and signs in the user with given username and
    // pass. If no user present by this name, then returns prompt
    private void signIn() {
        AuthenticationAlgorithm signALg = new AuthenticationAlgorithm();
        System.out.println("Username");
        String username = input.next();
        System.out.println("Password");
        String password = input.next();
        try {
            signALg.authenticate(username,password);
        } catch (UserNotThereException e) {
           System.out.println(username + " " + "not found");
        }
    }
}

