Vigenère cipher
---------------
A Vigenère cipher is a polyalphabetic substitution cipher.  It is done by choosing the rotating substitution mappings with the given encryption **key** and a **source character set**. Any characters outside of the source character set will be copied as-is.

To illustrate how it works, consider the following example where the key is **"encrypt"** and the source character set is the lowercase alphabet letters **[a-z]**. In this example, we will encrypt the input string **"top secret"**.

The characters in the encryption key, "encrypt", determines the sequence of character mappings.  Each mapping in the sequence is calculated with the characters from the encryption key by shifting the character set to the character of the key to produce the mapping from the input character to the cipher character. 

```text
                     Source Character Set
 key   a b c d e f g h i j k l m n o p q r s t u v w x y z        Mapping
-----  ---------------------------------------------------       ---------
  e    e f g h i j k l m n o p q r s t u v w x y z a b c d  -->   t -> x
  n    n o p q r s t u v w x z y a b c d e f g h i j k l m  -->   o -> b
  c    c d e f g h i j k l m n o p q r s t u v w x z y a b  -->   p -> r
  r    r s t u v w x z y a b c d e f g h i j k l m n o p q  -->   s -> j
  y    y z a b c d e f g h i j k l m n o p q r s t u v w x  -->   e -> c
  p    p q r s t u v w x y z a b c d e f g h i j k l m n o  -->   c -> r
  t    t u v w x y z a b c d e f g h i j k l m n o p q r s  -->   r -> k
 
 *** rotate the mapping back to the first character of the key here ***
  
  e    e f g h i j k l m n o p q r s t u v w x y z a b c d  -->   e -> i
  n    n o p q r s t u v w x z y a b c d e f g h i j k l m  -->   t -> g
   
 *** encryption ends ***

```

Usage - 

[action] [key] [target].

* [action]: case insensitive values of either *encrypt*, *decrypt*, *encryptDir*, or *decryptDir*
* [key]: string of any character sequence to be used as the Vigenère encrypt key
* [target]: 
     * For *encrypt* / *decrypt* actions: the value is the input text to be processed.  
     * For *encryptDir* / *decryptDir* actions: the value is a directory path where all the files to be processed. 
	 
       * Example: If top directory path is "/path/to/directory" and [action] is *encrypted*, then the output results will be written to a directory at path "/path/to/directory.encrypted".
