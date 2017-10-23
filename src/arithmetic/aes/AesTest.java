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
		 * 创建AES的key生产者
		 */
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom());
		/**
		 * 生成一个密钥
		 */
		SecretKey secretKey = keyGenerator.generateKey();
		/**
		 * 返回一个基本编码格式的一个密钥
		 */
		byte[] enCodeFormat = secretKey.getEncoded();
		/**
		 * 转换AES专用密钥
		 */
		SecretKey key = new SecretKeySpec(enCodeFormat, "AES");
		/**
		 * 创建加密器
		 */
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		byte[] byteContent = content.getBytes();
		/**
		 * 初始化加密器
		 */
		cipher.init(Cipher.ENCRYPT_MODE, key);
		/**
		 * 加密数据
		 */
		byte[] result = cipher.doFinal(byteContent);
		
		/**
		 * 解密？？
		 */
	}
	
}
