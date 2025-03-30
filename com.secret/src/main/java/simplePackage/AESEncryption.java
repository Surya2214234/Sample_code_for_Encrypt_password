package simplePackage;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
	
	private static final String SECRET_KEY = "admin12345678901"; // 16 bytes long

	    public static String encrypt(String strToEncrypt) {
	        try {
	            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static String decrypt(String strToDecrypt) {
	        try {
	            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    public static void main(String args[]) {
	    	
	    	//AESEncryption ae = new AESEncryption();
	    	String username = encrypt("Admin");
	    	System.out.println(username);
	    	System.out.println(decrypt(username));
	    	
	    	String password = encrypt("admin123");
	    	System.out.println(password);
	    	System.out.println(decrypt(password));
	    }
	
}
