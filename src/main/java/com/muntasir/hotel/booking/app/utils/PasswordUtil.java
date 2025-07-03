package com.muntasir.hotel.booking.app.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class PasswordUtil {
    
    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 16;
    
    public String hashPassword(String password) {
        try {
            // Generate salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            
            // Hash password with salt
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Combine salt and hash
            byte[] saltAndHash = new byte[SALT_LENGTH + hashedPassword.length];
            System.arraycopy(salt, 0, saltAndHash, 0, SALT_LENGTH);
            System.arraycopy(hashedPassword, 0, saltAndHash, SALT_LENGTH, hashedPassword.length);
            
            return Base64.getEncoder().encodeToString(saltAndHash);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    public boolean verifyPassword(String password, String hashedPassword) {
        try {
            // Decode the stored hash
            byte[] saltAndHash = Base64.getDecoder().decode(hashedPassword);
            
            // Extract salt
            byte[] salt = new byte[SALT_LENGTH];
            System.arraycopy(saltAndHash, 0, salt, 0, SALT_LENGTH);
            
            // Hash the input password with the same salt
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedInputPassword = md.digest(password.getBytes());
            
            // Extract the original hash
            byte[] originalHash = new byte[saltAndHash.length - SALT_LENGTH];
            System.arraycopy(saltAndHash, SALT_LENGTH, originalHash, 0, originalHash.length);
            
            // Compare hashes
            return MessageDigest.isEqual(hashedInputPassword, originalHash);
            
        } catch (Exception e) {
            return false;
        }
    }
}