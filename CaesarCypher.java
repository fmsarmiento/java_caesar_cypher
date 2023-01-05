
/**
 * Write a description of CaesarCypher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCypher {
    public String Encrypt(String input, int key) {
            StringBuilder encrypted = new StringBuilder(input); 
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String cypher = alphabet.substring(key) + alphabet.substring(0,key);
            boolean toLower = false;
            for (int i=0 ; i < encrypted.length() ; i+=1) {
                char currChar = encrypted.charAt(i);
                if (Character.isLowerCase(currChar)) {
                    currChar = Character.toUpperCase(currChar);
                    toLower = true;
                }
                else {
                    toLower = false;
                }
                int idx = alphabet.indexOf(currChar);
                
                if (idx != -1) {
                    char newChar = cypher.charAt(idx);
                    if (toLower) {
                    newChar = Character.toLowerCase(newChar);
                    }
                    encrypted.setCharAt(i, newChar);
                }
            }
        return encrypted.toString(); // SB to String
    }
    
    public String decrypt(String input, int key) {
        key = 26 - key;
        return Encrypt(input, key);
    }
    
    public void testing_encrypt() {
        int key = 15;
        String sample1 = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = Encrypt(sample1, key);
        System.out.println("Encrypted is: "+encrypted);
        String decrypted = Encrypt(encrypted, 26-key); //return to normal
        System.out.println("Decrypted is: "+decrypted);
    }
}
