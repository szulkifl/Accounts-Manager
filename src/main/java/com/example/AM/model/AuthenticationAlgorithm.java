package com.example.AM.model;


import com.example.AM.model.Exceptions.UserExistsException;
import com.example.AM.model.Exceptions.UserNotThereException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AuthenticationAlgorithm {




    // EFFECTS: creates a new instance of sign in/ sign up algorithm
    public AuthenticationAlgorithm() {}

    // Following part of code will create a salt and then a hashed password, then allocate that salt and hashed
    // password for that account

    // EFFECTS: represents a sign up mechanism
    public void registerUser(String username, String password) throws UserExistsException {
        String salt = generateSalt();
        String hashedPassword = createHashedPassword(password, salt);
        ListOfUsers users = ListOfUsers.getInstance();
        users.addUser(new User(username, hashedPassword, salt));
    }

    // EFFECTS: generates a salt for password
    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // EFFECTS: creates hashed password with given password and salt
    private static String createHashedPassword(String password, String salt) {
        int iterations = 2000;
        int lengthOfKey = 256;

        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        KeySpec spec = new PBEKeySpec(passwordChars, saltBytes,iterations,lengthOfKey);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // the following part will now focus on authentication; as in sign, in

    // EFFECTS: authenticates given password, by returning true if password is correct, false if it is incorrect
    public boolean authenticate(String userName,String givenPassword)
            throws UserNotThereException {
        ListOfUsers users = ListOfUsers.getInstance();
        User user = users.getUser(userName);
        String obtainedSalt = user.getSalt();
        String originalHashedPassword = user.getHashedPassword();
        String obtainedHashPassword = createHashedPassword(givenPassword,obtainedSalt);
        return originalHashedPassword.equals(obtainedHashPassword);
    }



}

