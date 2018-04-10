import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Cryptography {
    
    static String alphabet = ("abcdefghijklmnopqrstuvwxyz");
    
    static String encodeCaesar(String plaintxt){
        List <String> newString = new ArrayList <String> ();
        String txt = plaintxt.toLowerCase();
        for(int i = 0; i<txt.length();i++){
            for(int j=0; j<alphabet.length();j++){
                if(txt.charAt(i) == (alphabet.charAt(j))){
                    newString.add(Character.toString(alphabet.charAt(j+3)));
                }
            }
        }
        String enctxt = newString.toString();
        return enctxt;
        
    }
    
    static String decodeCaesar(String enctxt)
    {
        List <String> decoded = new ArrayList <String> ();
        for(int i = 0; i<enctxt.length(); i++){
            for(int j =0; j<alphabet.length(); j++){
                if(enctxt.charAt(i) == alphabet.charAt(j)){
                    decoded.add(Character.toString(alphabet.charAt(j-3)));
                }
            }
        }
        String plaintxt = decoded.toString();
        return plaintxt;
    }
    
    static String encodeSub(String plaintxt, String code){
        List <String> newtxt = new ArrayList <String> ();
        String txt = plaintxt.toLowerCase();
        for(int i=0; i<txt.length(); i++){
            for(int j=0; j<alphabet.length(); j++){
                if(txt.charAt(i) == alphabet.charAt(j)){
                    newtxt.add(Character.toString(code.charAt(j)));
                }
            }
        }
        String enctxt = newtxt.toString();
        return enctxt;
    }
    
    static String decodeSub(String enctxt, String code){
        List <String> newstring = new ArrayList <String> ();
        for(int i=0; i<enctxt.length(); i++){
            for(int j=0; j<code.length(); j++){
                if(enctxt.charAt(i) == code.charAt(j)){
                    newstring.add(Character.toString(alphabet.charAt(j)));
                }
            }
        }
        String plaintxt = newstring.toString();
        return plaintxt;
    }
    
    static String encodeRotate(String s, String code){
        
        List <String> newtxt = new ArrayList <String> ();
        
        String txt = s.toLowerCase();
        for(int i=0; i<txt.length(); i++){
            code = (code.substring(1) + code.charAt(0));
            String t = Character.toString(txt.charAt(i));
            newtxt.add((encodeSub(t, code)));
        }
        String enctxt = newtxt.toString();
        return enctxt;
    }
    
    
    static String decodeRotate(String enctxt, String code)
    {
        List <String> decoded = new ArrayList <String> ();
        for(int i=0; i<enctxt.length();i++){
            code = (code.substring(1) + code.charAt(0));
            
            String ch = (enctxt.charAt(i)+ "");
            System.out.println(ch);
            String n = (decodeSub(ch, code));
            
            decoded.add(n);
            
        }
        String plaintxt = decoded.toString();
        return plaintxt;
    }
    
    
    static void genPasswordsRec(String password, int pos, int size, char[] charset)
    {
        //Challenge question: Can you brute-force a password of size size,
        //by creating all permutations of characters in the character set?
        
    }
    
    public static void main(String[] args)
    {
        String str="hello";
        System.out.println("\nCaesar cipher");
        String enctxt=encodeCaesar(str);
        System.out.println("Encoded output: "+enctxt);
        String plaintxt=decodeCaesar(enctxt);
        System.out.println("Decoded output: "+plaintxt);
        
        System.out.println("\n*******************\n");
        System.out.println("Substitution cipher");
        String code="qwertyuiopasdfghjklzxcvbnm"; //you may change the code!!
        enctxt=encodeSub(str, code);
        System.out.println("Encoded output: "+enctxt);
        plaintxt=decodeSub(enctxt, code);
        System.out.println("Decoded output: "+plaintxt);
        
        System.out.println("\n*******************\n");
        System.out.println("Rotation cipher");
        //code = ? //you may change the code!!
        
        enctxt=encodeRotate(str, code);
        System.out.println("Encoded output: "+enctxt);
        plaintxt=decodeRotate(enctxt, code);
        System.out.println("Decoded output: "+plaintxt);
        
        System.out.println("\n*******************\n");
        System.out.println("Brute-force password cracking");
        int size=3;
        char[] charset = {'a', 'b', 'c'};
        genPasswordsRec("", 0, size, charset);
        
        System.out.println();
    }
    
}
