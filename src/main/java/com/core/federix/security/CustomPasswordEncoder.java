package com.core.federix.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.util.Formatter;

public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return encryptSHA1(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encryptSHA1(charSequence.toString()).equals(s);
    }

    public static String encryptSHA1(String string) {
        String sha1 = null;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
            return sha1;
        } catch (Exception var3) {
            return null;
        }
    }

    private static String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        byte[] var2 = hash;
        int var3 = hash.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            formatter.format("%02x", b);
        }

        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
