package exercise.vigenere;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest
{

    VigenereCypher cypher = new VigenereCypher();

    String key = "encrypt";
    String text = "top secret";
    String encryptedTarget = "xbr jcrkig";
    String CIPHER_CHAR_SET = "abcdefghijklmnopqrstuvwxyz";

    @Test
    public void testSanity()
    {
        System.out.println("JUnit works");
    }

    @Test
    public void testEncrypt()
    {
        String encryptedString = cypher.encrypt(key, text, CIPHER_CHAR_SET);
        assertEquals(encryptedString, encryptedTarget);
    }

    @Test
    public void testDecrypt()
    {
        String decryptedString = cypher.decrypt(key, encryptedTarget, CIPHER_CHAR_SET);
        assertEquals(decryptedString, text);
    }

}
