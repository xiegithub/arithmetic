package arithmetic.aes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesTest {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String content = "1234567890123456";
		/**
		 * ����AES��key������
		 */
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom());
		/**
		 * ����һ����Կ
		 */
		SecretKey secretKey = keyGenerator.generateKey();
		/**
		 * ����һ�����������ʽ��һ����Կ
		 */
		byte[] enCodeFormat = secretKey.getEncoded();
		/**
		 * ת��AESר����Կ
		 */
		SecretKey key = new SecretKeySpec(enCodeFormat, "AES");
		/**
		 * ����������
		 */
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		byte[] byteContent = content.getBytes();
		/**
		 * ��ʼ��������
		 */
		cipher.init(Cipher.ENCRYPT_MODE, key);
		/**
		 * ��������
		 */
		byte[] result = cipher.doFinal(byteContent);
		
		/**
		 * ���ܣ���
		 */
	}
	
}
