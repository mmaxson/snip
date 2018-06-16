package com.mmu.gen;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES {

    private static final String initVector = "encryptionIntVec";


    private static SecretKeySpec generateKey() {
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
        }
        keygen.init(256);
        byte[] key = keygen.generateKey().getEncoded();
        return new SecretKeySpec(key, "AES");
    }

    private static IvParameterSpec generateInitVector() {

        byte iv[] = new byte[16];

        SecureRandom secRandom = new SecureRandom();
        secRandom.nextBytes(iv);

        return new IvParameterSpec(iv);
    }

    public static String encrypt(SecretKeySpec key, IvParameterSpec iv, String value) {
        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(SecretKeySpec key, IvParameterSpec iv, String encrypted) {
        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        SecretKeySpec key = generateKey();
        IvParameterSpec iv = generateInitVector();

        System.out.println(encrypt(key, iv, "mark"));
        System.out.println(decrypt(key, iv, encrypt(key, iv, "mark")));

    }
}
