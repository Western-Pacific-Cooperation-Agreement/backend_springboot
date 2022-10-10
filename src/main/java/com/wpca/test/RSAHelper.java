package com.wpca.test;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.test.RSAHelper
 * @Date 2022年10月08日 11:27
 * @Description
 */

import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;
import sun.security.util.DerValue;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

public class RSAHelper {


    public static final int ENCODE_MAX = 2;
    public static final int DECODE_MAX = 16;


    @SneakyThrows
    @Test
    public  void test(){

        String encode = encode("厦门理工", "123");
        String encode1 = encode("厦门", "123");
       System.out.println(encode);
        System.out.println(encode1);

        String decode = encode(encode, "123");
        System.out.println(decode);
        String decode1 = encode(encode1, "123");
        System.out.println(decode1);

    }

    public static String decode(String encBase64String,String privateKeyString) throws Exception {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] desEncodeRead = base64Decoder.decodeBuffer(privateKeyString);//
        DerValue d = new DerValue(desEncodeRead);
        RSAPrivateKey privateKey= (RSAPrivateKey) RSAPrivateKeyImpl.parseKey(d);
        Cipher cipher =Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] src = base64Decoder.decodeBuffer(encBase64String);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for(int i=0; i<src.length; i+= DECODE_MAX){
            byte[] toDecodeSegment = ArrayUtils.subarray(src, i,i+DECODE_MAX);
            byte[] destByte = cipher.doFinal(toDecodeSegment);
            System.out.println("decode"+destByte.length);
            out.write(destByte);
        }
        byte[] decode = out.toByteArray();
        return new String(decode, "UTF-8");
    }


    public static String encode(String src, String publicKey) throws Exception {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        byte[] desEncodeRead = base64Decoder.decodeBuffer(publicKey);//
        DerValue d = new DerValue(desEncodeRead);
        RSAPublicKey p = (RSAPublicKey) RSAPublicKeyImpl.parse(d);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, p);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] toEncode = src.getBytes();
        for(int i=0; i<toEncode.length; i+= ENCODE_MAX){
            byte[] toEncodeSegment = ArrayUtils.subarray(toEncode, i,i+ENCODE_MAX);
            byte[] ecodeSegemnt = cipher.doFinal(toEncodeSegment);
            System.out.println("adfdsSS"+ecodeSegemnt.length);
            out.write(ecodeSegemnt);
        }
        byte[] encode = out.toByteArray();
        return base64Encoder.encode(encode);
    }

    /**
     * return map siz KEY为public key value为private key   BASE64串
     */
    public static Map generateRSAKey() throws NoSuchAlgorithmException {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // Generate keys
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        byte[] privateEncode = privateKey.getEncoded();
        byte[] publicEncode = publicKey.getEncoded();
        String privateKeyBase64 = base64Encoder.encode(privateEncode);
        String publicKeyBase64 = base64Encoder.encode(publicEncode);
        Map retValue = new HashMap(1);
        retValue.put(publicKeyBase64, privateKeyBase64);
        return retValue;
    }



}
