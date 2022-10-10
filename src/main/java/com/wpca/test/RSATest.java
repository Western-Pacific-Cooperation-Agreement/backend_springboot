package com.wpca.test;

import com.alibaba.fastjson.JSONObject;
import com.wpca.ultis.RSAUtil;
import org.apache.commons.codec.binary.Base64;

public class RSATest {

    public static void main(String[] args) throws Exception {

        // 密钥长度 1024 bit ；密钥格式：PKCS#8
        // 公钥
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+4XSsVRrX4Mbp6QZ3u1NwgCHc" +
                "Zmqea7ZRYflexA5YlNPTnKCeqkizzHgrE4Ff6niYGsmUlaLRoSC5GvFYOfFX3ZQ/" +
                "KyCGg68zlxDPhPklnEQhop/kbLvCMUrFsmgm5KSIPzd5jXqUluzWDYs+f19nhYdr" +
                "3JzJYktXrKMXcP5lTQIDAQAB";

        // 私钥
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL7hdKxVGtfgxunp" +
                "Bne7U3CAIdxmap5rtlFh+V7EDliU09OcoJ6qSLPMeCsTgV/qeJgayZSVotGhILka" +
                "8Vg58VfdlD8rIIaDrzOXEM+E+SWcRCGin+Rsu8IxSsWyaCbkpIg/N3mNepSW7NYN" +
                "iz5/X2eFh2vcnMliS1esoxdw/mVNAgMBAAECgYEAph451ryeBuAU3H6y5UJ+pDqu" +
                "vUvYYBSnb34Pcty3C3pCOzhlRJA3g1pf/kUUY6//0YgGhKwRLdTHULDU9w4+LNPZ" +
                "XraysIoscBiIjol171zSdFX/qPaKAJ0IAZacXA+uaKBmd3BL3ho7Mon2GqJnA8NF" +
                "cvl19aF0M4sBuVGvpBUCQQDgNx9RII7bPHX2FW4LAVo2+vf3hoh7Fg6ikFLmcez6" +
                "56K8dBjUShYNebIr2i5NLCPrfoST1peWzuHaj4j0eVRrAkEA2fCapr+qHH0gN99a" +
                "vBOXqHqiTZBV00PUX2K37OcnyK7CzWNbTo9WoSSf1aRHBT/xeY9KrEQWNhsovl7s" +
                "8KHbJwJAJ02CT9ZFNGkExH49K/Cwv7J+hQUwJ2NWbWifH4YY5GJ2RFKVh6D0/Ke4" +
                "c7drJlv2b/FdjAyxxd29+XHvr+sUwQJAclJ+LX5Y87zHS8fERuhYI67AuMM/4iSw" +
                "oKCeLo1LF0BlO2wlF16laL5XgbA8+QoD12pNF3RX2mYAx2vwCoI8/QJBANwKXMw9" +
                "qd3SX5WYci+gtABKBu12T2rFarz3OxvbKqnZ03vVVb+DNJjsuFP55lbJMMq5D6Dg" +
                "KTEpBOZ6ojfaxB8=";

//        Ujr2ms6br2okfr9JbPoISW8CkZwW4gO7XGfMh9roL8lwYs5jxdUSyxh1HFLb1MlbD7fCzVdkOTdETfykk/MBXWb2zEvO1SnxrcW9JT1UpOLocvlO/eiiZC7Ee1hcBu5GnPko3ry5H4Qk+VAUGPKUl5XyLK44e6AY32mt0mCbHr+5J5w1Np3s/7NgjU+e7zX8uX1/ncCcMh0U36t8W8iQKM9VEkhTnSLInSJ3HCkBa5/rnxULoNgXHzgxryXVfFOl/f1QERkYm6Jcev6ZgBpgrOqteKQU6khIvwSi08FfbuG4ye9itX9+ggjQUepc6vWj1hN2Zbo+XXndz1fddbAZjy4cJsfVGNeLjXXULYtvABtd9C489w9u2I793OB3qGCTAEySvlyasaWF4zE/sHwE7gDjmUurrJUW+jeW5WqsXLWm2KJMA2Te0FFPXmQym/3Ga+g0tWSA2XtHZaUeCu07UqACmGOaQuK+9634TGNN9o9DtfSNlLAa5DK4s+EZ4BJSD2sQYzbyzOmXYqxNMGyiQ/rRLtHZipNLBUng/9sV66tr77bRY2+3zO1/z0a3mc40EY4HJkLjmv46wISL3OHgbMz5izFNh3VQ1ZRDNRuAIfP7FY9W7Bt6NJh83psmrsVtUwHJiHYpXAh0gRFysW2NW60R9itN6XXWfwEqZLJYjUOSe1jw1zx+iWSuJcJRZkY413aB4uWKrvBV/xM17xlr/ObeZ6OROHiFi/3sXoaKhmU3aM2PcJ4frHh2y4OpzRiEqiBV0rz7PIadyy2+/YaZjWpQvNRhWwtiS+dBxm8BJFj+BJpzfhlAL5XB4JNmSFtXb1dhoydtG5nvQBiNWQutgqbu3VAVWljp/9tvbWc*/FAIU+nq3o5TUd5XZmsMAnufQd7HvDPCnDvUwvROtpjRu6OPBHt7dMrvrF5fGZGJIbHvAKjia7JL4xX0eLRYSkF8QDy9o28rApoUXWS6x4LyQ/aL/ShH4zmr44G/fAaMYWSYIsNn7B5OAsZhSpKlGQEhfE
        System.out.println("==========开始加密==========");
        String s = "厦门理工";
        System.out.println("原字符串s = " + s);
        System.out.println("原字符串长度 = " + s.length());
        // 公钥加密
        byte[] encryptStrByte = RSAUtil.encryptByPublicKey(s.getBytes(), publicKey);
        String encryptStr = new String(Base64.encodeBase64(encryptStrByte));
        System.out.println("加密后 = " + encryptStr);
        System.out.println("加密后长度 = " + encryptStr.length());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("redata", encryptStr);
        System.out.println("最终传输密文 = " + jsonObject.toJSONString());
        System.out.println("==========加密成功，开始传输密文==========");


        System.out.println("==========传输密文成功，开始解密==========");
        String code = jsonObject.get("redata").toString();
        System.out.println("code = " + code);
        // 私钥解密
        byte[] decryptStrByte = RSAUtil.decryptByPrivateKey(Base64.decodeBase64(code), privateKey);
        String answer = new String(decryptStrByte);
        System.out.println("解密后 = " + answer);
        System.out.println("解密后长度 = " + answer.length());
        System.out.println("==========解密成功==========");
    }
}
