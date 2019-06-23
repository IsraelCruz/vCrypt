package exercise.vigenere;

import java.util.*;

public class App
{
    // public static final String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";
    // public static final int CIPHER_LENGTH = CIPHER_CHAR_SET.length();
    // public static HashMap<Character, Integer> cipherCharactersPositions = new HashMap<>();

    public static void main(String args[])
    {
        if (args.length != 3)
        {
            System.out.println("Exact 3 parameters required - [action] [key] [target]");
            System.exit(1);
        }

        String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";

        String action, key, target;
        action = args[0];
        key = args[1];
        target = args[2];

        VigenereCypher cypher = new VigenereCypher();
        CopyDirectory copyDirectory = new CopyDirectory();

        if ("encrypt".equalsIgnoreCase(action))
        {
            System.out.println("encrypt [" + key + "], [" + target + "]");
            System.out.println(cypher.encrypt(key, target, CIPHER_CHAR_SET));
        }
        else if ("decrypt".equalsIgnoreCase(action))
        {
            System.out.println("decrypt [" + key + "], [" + target + "]");
            System.out.println(cypher.decrypt(key, target, CIPHER_CHAR_SET));
        }
        else if ("encryptDir".equalsIgnoreCase(action))
        {
            System.out.println("encryptDir [" + key + "], [" + target + "]");
            copyDirectory.copyFolder(target, key, true, CIPHER_CHAR_SET);
        }
        else if ("decryptDir".equalsIgnoreCase(action))
        {
            System.out.println("decryptDir [" + key + "], [" + target + "]");
            copyDirectory.copyFolder(target, key, false, CIPHER_CHAR_SET);
        }
        else
        {
            System.out.println("action [" + action + "] not implemented");
        }
    }
}
