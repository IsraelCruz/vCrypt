package exercise.vigenere;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDirectory
{
    VigenereCypher cypher = new VigenereCypher();

    private String key;
    private boolean encryptFiles;

    String CIPHER_CHAR_SET;

    public void copyFolder(String src, String key, boolean encryptFiles, String characterts)
    {
        File srcFolder = new File(src);
        File destFolder = new File(src + "." + (encryptFiles ? "encrypt" : "decrypt"));

        this.key = key;
        this.encryptFiles = encryptFiles;
        this.CIPHER_CHAR_SET = characterts;

        if(!srcFolder.exists())
        {
            System.out.println("Directory does not exist.");
            System.exit(0);
        }
        else
        {
            try
            {
                copyFolder(srcFolder, destFolder);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    private void copyFolder(File src, File dest)
    throws IOException
    {
        if(src.isDirectory())
        {
            //if directory not exists, create it
            if(!dest.exists())
            {
                dest.mkdir();
                System.out.println("Directory copied from "
                + src + "  to " + dest);
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files)
            {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }
        }
        else
        {
            BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest));

            String st;

            boolean firstLine = true;
            while ((st = br.readLine()) != null)
            {
                if(!firstLine)
                {
                    bw.newLine();
                }
                else
                {
                    firstLine = false;
                }

                if(encryptFiles)
                {
                    bw.write(cypher.encrypt(key, st, CIPHER_CHAR_SET));
                }
                else
                {
                    bw.write(cypher.decrypt(key, st, CIPHER_CHAR_SET));
                }
            }
            bw.close();
        }
    }
}