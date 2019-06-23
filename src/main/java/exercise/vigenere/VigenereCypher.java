package exercise.vigenere;

import java.util.*;

public class VigenereCypher
{
    String CIPHER_CHAR_SET;
    int CIPHER_LENGTH;
    HashMap<Character, Integer> cipherCharactersPositions = new HashMap<>();;

    private void createCharacterSet(String characters)
    {
        CIPHER_CHAR_SET = characters;
        CIPHER_LENGTH = characters.length();

        for(int i = 0; i < CIPHER_CHAR_SET.length(); i++)
        {
            cipherCharactersPositions.put(CIPHER_CHAR_SET.charAt(i), i);
        }
    }

    public String encrypt(String key, String text, String characters)
    {
        createCharacterSet(characters);

        int skips = 0;
        String sb = "";

        for(int i = 0 ; i < text.length(); i++)
        {
            if(cipherCharactersPositions.containsKey(text.charAt(i)))
            {

                int shift = (cipherCharactersPositions.get(text.charAt(i)) +
                             cipherCharactersPositions.get(key.charAt((i - skips) % key.length())));

                sb += CIPHER_CHAR_SET.charAt(shift % CIPHER_LENGTH);
            }
            else
            {
                skips++;
                sb += (text.charAt(i));
            }
        }
        return sb;
    }

    public String decrypt(String key, String text, String characters)
    {
        createCharacterSet(characters);

        String sb = "";
        int skips = 0;

        for(int i = 0 ; i < text.length(); i++)
        {
            if(cipherCharactersPositions.containsKey(text.charAt(i)))
            {
                int shift = (cipherCharactersPositions.get(text.charAt(i)) -
                             cipherCharactersPositions.get(key.charAt((i - skips) % key.length())) + CIPHER_LENGTH);
                sb += CIPHER_CHAR_SET.charAt(shift % CIPHER_LENGTH);
            }
            else
            {
                skips++;
                sb += (text.charAt(i));

            }
        }
        return sb;
    }
}