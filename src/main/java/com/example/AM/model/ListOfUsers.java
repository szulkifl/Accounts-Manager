package com.example.AM.model;


import com.example.AM.model.Exceptions.UserExistsException;
import com.example.AM.model.Exceptions.UserNotThereException;

import java.util.ArrayList;

public class ListOfUsers {

    private static ListOfUsers singleton;
    private ArrayList<User> users;

    // EFFECTS: creates a new ListOfUsers(), with an empty array of list of element type User
    private ListOfUsers() {
        users = new ArrayList<>();
    }

    // EFFECTS: if singleton is null, then creates a new instance of ListOfUsers or else returns singleton
    public static ListOfUsers getInstance() {
        if (singleton == null) {
            singleton = new ListOfUsers();
        }
        return singleton;
    }

    // MODIFIES: users
    // EFFECTS: adds given  user to the list of users
    public void addUser(User u) throws UserExistsException {
        for (User user : users) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new UserExistsException();
            } else {
                users.add(u);
            }
        }
    }

    public String getUserName(String username) {
        String answer = null;
        for (User user : users) {
            if (username.equals(user.getUsername()));
            answer = user.getUsername();
        }
        return answer;
    }

    public User getUser(String username) throws UserNotThereException {
        User user = null;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
               user = u;
            }
        }
        if (user == null) {
            throw new UserNotThereException();
        } else {
            return user;
        }
    }
}

