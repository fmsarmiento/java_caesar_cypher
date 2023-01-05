
/**
 * Write a description of OOPCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OOPCaesarCipher {
    private String alphabet;
    private String shiftedalphabet;
    private int key_used;
    
    public OOPCaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedalphabet = alphabet.substring(key) + alphabet.substring(0,key);
        key_used = key;
    }
    
    public String encrypt(String input) {
        StringBuilder plaintext = new StringBuilder(input);
        boolean toLower = false;
            for (int i=0 ; i < plaintext.length() ; i+=1) {
                char currChar = plaintext.charAt(i);
                if (Character.isLowerCase(currChar)) {
                    currChar = Character.toUpperCase(currChar);
                    toLower = true;
                }
                else {
                    toLower = false;
                }
                int idx = alphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedalphabet.charAt(idx);
                    if (toLower) {
                    newChar = Character.toLowerCase(newChar);
                    }
                    plaintext.setCharAt(i, newChar);
                }
            }
        return plaintext.toString(); // SB to String
    }
    
    public String decrypt(String input) {
        key_used = 26 - key_used;
        shiftedalphabet = alphabet.substring(key_used) + alphabet.substring(0,key_used);
        return encrypt(input);
    }
    
    public void TestCipher() {
        System.out.println("Key is "+key_used);
        String sample = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        OOPCaesarCipher object1 = new OOPCaesarCipher(key_used);
        System.out.println(object1);
        System.out.println(object1.encrypt(sample));
        System.out.println(object1.decrypt(sample));
    }
}
