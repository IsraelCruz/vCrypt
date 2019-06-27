File encryption/decryption.

Usage - 

[action] [key] [target].

* [action]: case insensitive values of either *encrypt*, *decrypt*, *encryptDir*, or *decryptDir*
* [key]: string of any character sequence to be used as the encrypt/decrypt key
* [target]: 
     * For *encrypt* / *decrypt* actions: the value is the input text to be processed.  
     * For *encryptDir* / *decryptDir* actions: the value is a directory path where all the files to be processed. 
	 
       * Example: If top directory path is "/path/to/directory" and [action] is *encrypted*, then the output results will be written to a directory at path "/path/to/directory.encrypted".
