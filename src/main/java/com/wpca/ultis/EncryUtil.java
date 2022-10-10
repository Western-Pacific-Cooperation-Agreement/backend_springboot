package com.wpca.ultis;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;
import sun.security.util.DerValue;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Scanner;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.ultis.EncryUtil
 * @Date 2022年10月08日 14:41
 * @Description  加密算法
 */
//public class EncryUtil {
//
//    public final int[]EXCHAGEARY={2,1,3,0};//变位数组
//    public int KESHA=6;                    //凯撒偏移密钥
//    public static String encryptAndDencrypt(String value, char secret)
//    {
//        byte[] bt=value.getBytes(); //将需要加密的内容转换为字节数组
//        for(int i=0;i<bt.length;i++)
//        {
//            bt[i]=(byte)(bt[i]^(int)secret); //通过异或运算进行加密
//        }
//        String newresult=new String(bt,0,bt.length); //将加密后的字符串保存到 newresult 变量中
//        return newresult;
//    }
//    public static void main(String[] args)
//    {
//       String sad="aaaaaaaaaaaa";
//       sad=sad.replaceAll("aaa","a");
//        System.out.println(sad);
//    }
//
//
//
//    /**
//     * 编码方法
//     * @param str 字符串
//     * @return 返回编码后的字符串
//     */
//    public static String toBase64(String str) {
//        //把str按字符放入bytes数组
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//        //记录需要补等号的个数
//        int count = 3 - (bytes.length % 3);
//        //记录数组长度
//        int length = bytes.length;
//        //下标指针
//        int index = 0;
//        //定义一个StringBuilder来存放编码后的字符串
//        StringBuilder sb = new StringBuilder();
//        while((length - index) >= 3) {
//            //当数组长度比下标指针相差3甚至更多时，就将bytes[index]，bytes[index + 1]，bytes[index + 2]
//            // （每一个bytes[]都由8位二进制数组成）拼接成24位二进制数
//            int v = (bytes[index] & 0xFF) << 16 | (bytes[index + 1] & 0xFF) << 8 | (bytes[index + 2] & 0xFF);
//            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
//            //右移18位，取6位
//            sb.append(toBase64[v >>> 18 & 0x3F]);
//            //右移12位，取6位
//            sb.append(toBase64[v >>> 12 & 0x3F]);
//            //右移6位，取6位
//            sb.append(toBase64[v >>> 6 & 0x3F]);
//            //取6位
//            sb.append(toBase64[v & 0x3F]);
//            //下标指针加3
//            index += 3;
//            //如果还满足(length - index) >= 3，取接下来的3个bytes[]进行拼接，不满足则跳出循环
//        }
//
//        if (count == 1){
//            //如果需要补1个等号
//            //bytes[index]，bytes[index + 1]拼接成16位二进制数
//            int v = (bytes[index] & 0xFF) << 8 | (bytes[index + 1] & 0xFF);
//            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
//            //右移10位，取6位
//            sb.append(toBase64[v >>> 10 & 0x3F]);
//            //右移4位，取6位
//            sb.append(toBase64[v >>> 4 & 0x3F]);
//            //左移2位（相当于需要借2位），取6位
//            sb.append(toBase64[v << 2 & 0x3F]);
//            sb.append('=');
//        }else if (count == 2){
//            //如果需要补2个等号
//            //bytes[index]化成8位二进制数
//            int v = (bytes[index] & 0xFF);
//            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
//            //右移2位，取6位
//            sb.append(toBase64[v >>> 2 & 0x3F]);
//            //左移4位（相当于需要借4位），取6位
//            sb.append(toBase64[v << 4 & 0x3F]);
//            sb.append('=');
//            sb.append('=');
//        }
//        return sb.toString();
//    }
//
//    /**
//     * 解码方法
//     * @param str 字符串
//     * @return 返回解码后的字符串
//     */
//    public static String reversalBase64(String str) {
//        //记录=的数量
//        int count = 0;
//        //arr下标指针
//        int index = 0;
//        //bytes下标指针
//        int indexs = 0;
//        //遍历字符串得到=的数量
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '=') {
//                count++;
//            }
//        }
//        //new一个arr数组用来存放非=的字符串
//        int length = str.length() - count;
//        int[] arr = new int[length];
//        //得到arr数组的值所对应的char数组的下标
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < toBase64.length; j++) {
//                if (str.charAt(i) == toBase64[j]) {
//                    arr[i] = j;
//                }
//            }
//        }
//        //new一个bytes数组用来存放解码后的字符串的每一个字符
//        byte[] bytes = new byte[str.length() / 4 * 3 - count];
//        while ((length / 4) > 0) {
//            //当arr数组长度大于等于4时，就将arr[index]，arr[index + 1]，arr[index + 2]，arr[index + 3]
//            // （每一个arr[]都由6位二进制数组成）拼接成24位二进制数
//            int v = (arr[index] & 0x3F) << 18 | (arr[index + 1] & 0x3F) << 12 | (arr[index + 2] & 0x3F) << 6 | (arr[index + 3] & 0x3F);
//            //每8位为一组转化成byte型，并赋值给bytes
//            //右移16位，取8位
//            bytes[indexs] = (byte) (v >>> 16 & 0xFF);
//            //右移8位，取8位
//            bytes[indexs + 1] = (byte) (v >>> 8 & 0xFF);
//            //取8位
//            bytes[indexs + 2] = (byte) (v & 0xFF);
//            //bytes下标指针加3
//            indexs += 3;
//            //arr下标指针加4
//            index += 4;
//            //arr数组长度减4
//            length -= 4;
//            //如果还满足(length / 4) > 0，取接下来的4个arr[]进行拼接，不满足则跳出循环
//        }
//
//        if (count == 1) {
//            //如果存在1个=
//            //将arr[index]，arr[index + 1]，arr[index + 2]拼接成18位二进制数
//            int v = (arr[index] & 0x3F) << 12 | (arr[index + 1] & 0x3F) << 6 | (arr[index + 2] & 0x3F);
//            //每8位为一组转化成byte型，并赋值给bytes
//            //右移10位，取8位
//            bytes[indexs] = (byte) (v >>> 10 & 0xFF);
//            //右移2位，取8位
//            bytes[indexs + 1] = (byte) (v >>> 2 & 0xFF);
//        } else if (count == 2) {
//            //如果存在2个=
//            //将arr[index]，arr[index + 1]拼接成12位二进制数
//            int v = (arr[index] & 0x3F) << 6 | (arr[index + 1] & 0x3F);
//            //每8位为一组转化成byte型，并赋值给bytes
//            //右移4位，取8位
//            bytes[indexs] = (byte) (v >>> 4 & 0xFF);
//        }
//        //将bytes数组中存的字符转换成String类型
//        String result = new String(bytes, StandardCharsets.UTF_8);
//        return result;
//    }

//}
import java.nio.charset.StandardCharsets;

public class EncryUtil {

    public final int[]EXCHAGEARY={2,1,3,0};//变位数组

    public int KESHA=6;                    //凯撒偏移密钥



    //用一个char数组封装base64码
    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    @Test
    public void test(){

        System.out.println(encode("ccc"));;
        System.out.println(decode("T8p_"));

    }

    //编码
    public String encode(String str){
        String codeStr= toBase64(str);
        System.out.println("初始"+" : "+codeStr);
        for(int i = 0 ; i<codeStr.length();i=i+4){
            //进行转换并添加凯撒偏移值
            String temp="";
            char a=codeStr.charAt(i),b=codeStr.charAt(i+1),c=codeStr.charAt(i+2),d=codeStr.charAt(i+3);
            for(int j = 0 ; j<EXCHAGEARY.length;j++){
                switch (EXCHAGEARY[j]){
                    case 0:temp+=(char)(a+KESHA);break;
                    case 1:temp+=(char)(b+KESHA);break;
                    case 2:temp+=(char)(c+KESHA);break;
                    case 3:temp+=(char)(d+KESHA);break;
                }
            }
            System.out.println(i+"   : "+codeStr);

            String front=codeStr.substring(0,i);
            String end;
            if(i+4==codeStr.length()) {
                end = "";
            }
            else {
                end = codeStr.substring(i + 4, codeStr.length());
            }
                codeStr=front+temp+end;

        }

        return codeStr;
    }

    //解码
    public String decode(String codeStr){
        for(int i = 0 ; i<codeStr.length();i=i+4){
            //进行转换并添加凯撒偏移值
            StringBuffer temp=new StringBuffer("****");
            char a=codeStr.charAt(i),b=codeStr.charAt(i+1),c=codeStr.charAt(i+2),d=codeStr.charAt(i+3);
            for(int j = 0 ; j<EXCHAGEARY.length;j++){
                switch (j){
                    case 0:temp.replace(EXCHAGEARY[j],EXCHAGEARY[j]+1,""+(char)(a-KESHA));break;
                    case 1:temp.replace(EXCHAGEARY[j],EXCHAGEARY[j]+1,""+(char)(b-KESHA));break;
                    case 2:temp.replace(EXCHAGEARY[j],EXCHAGEARY[j]+1,""+(char)(c-KESHA));break;
                    case 3:temp.replace(EXCHAGEARY[j],EXCHAGEARY[j]+1,""+(char)(d-KESHA));break;
                }
            }
            String front=codeStr.substring(0,i);
            String end;
            if(i+4==codeStr.length()) {
                end = "";
            }
            else {
                end = codeStr.substring(i + 4, codeStr.length());
            }
            codeStr=front+temp+end;
            System.out.println("codeStr   : "+codeStr);
        }
        codeStr = reversalBase64(codeStr);
        System.out.println("codeStr   : "+codeStr);

        /********替换3字符到1个****/
        codeStr=replace3to1(codeStr);

        return codeStr;
    }

    private String replace3to1(String codeStr) {
        for (int i = 33; i <= 39; i++) {
            char r = (char) i;
            String replace = "" + r + "" + r + "" + r;
            codeStr = codeStr.replaceAll(replace, "" + i);
        }
        codeStr = codeStr.replaceAll("\\(\\(\\(", "\\(");
        codeStr = codeStr.replaceAll("\\)\\)\\)", "\\)");
        codeStr = codeStr.replaceAll("\\*\\*\\*", "\\*");
        codeStr = codeStr.replaceAll("\\+\\+\\+", "\\+");
        for (int i = 44; i <= 62; i++) {
            char r = (char) i;
            String replace = "" + r + "" + r + "" + r;
            codeStr = codeStr.replaceAll(replace, "" + i);
        }
        codeStr = codeStr.replaceAll("\\?\\?\\?", "\\?");
        for (int i = 64; i <= 90; i++) {
            char r = (char) i;
            String replace = "" + r + "" + r + "" + r;
            codeStr = codeStr.replaceAll(replace, "" + i);
        }
        codeStr = codeStr.replaceAll("\\[\\[\\[", "\\[");

        for (int i = 93; i <= 122; i++) {
            char r = (char) i;
            String replace = "" + r + "" + r + "" + r;
            codeStr = codeStr.replaceAll(replace, "" + i);
        }
        codeStr = codeStr.replaceAll("\\{\\{\\{", "\\{");
        codeStr = codeStr.replaceAll("\\}\\}\\}", "\\}");
        for (int i = 125; i <= 126; i++) {
            char r = (char) i;
            String replace = "" + r + "" + r + "" + r;
            codeStr = codeStr.replaceAll(replace, "" + i);
        }
        return codeStr;
    }

    public static void main(String[] args) {
        String str = "好好学习";
        System.out.println("编码前："+str);
        str = toBase64(str);
        System.out.println("编码后："+str);
        str = reversalBase64(str);
        System.out.println("解码后："+str);
    }

    /**
     * 编码方法
     * @param str 字符串
     * @return 返回编码后的字符串
     */
    public static String toBase64(String str) {
        //把str按字符放入bytes数组
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //记录需要补等号的个数
        int count = 3 - (bytes.length % 3);
        //记录数组长度
        int length = bytes.length;
        //下标指针
        int index = 0;
        //定义一个StringBuilder来存放编码后的字符串
        StringBuilder sb = new StringBuilder();
        while((length - index) >= 3) {
            //当数组长度比下标指针相差3甚至更多时，就将bytes[index]，bytes[index + 1]，bytes[index + 2]
            // （每一个bytes[]都由8位二进制数组成）拼接成24位二进制数
            int v = (bytes[index] & 0xFF) << 16 | (bytes[index + 1] & 0xFF) << 8 | (bytes[index + 2] & 0xFF);
            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
            //右移18位，取6位
            sb.append(toBase64[v >>> 18 & 0x3F]);
            //右移12位，取6位
            sb.append(toBase64[v >>> 12 & 0x3F]);
            //右移6位，取6位
            sb.append(toBase64[v >>> 6 & 0x3F]);
            //取6位
            sb.append(toBase64[v & 0x3F]);
            //下标指针加3
            index += 3;
            //如果还满足(length - index) >= 3，取接下来的3个bytes[]进行拼接，不满足则跳出循环
        }

        if (count == 1){
            //如果需要补1个等号
            //bytes[index]，bytes[index + 1]拼接成16位二进制数
            int v = (bytes[index] & 0xFF) << 8 | (bytes[index + 1] & 0xFF);
            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
            //右移10位，取6位
            sb.append(toBase64[v >>> 10 & 0x3F]);
            //右移4位，取6位
            sb.append(toBase64[v >>> 4 & 0x3F]);
            //左移2位（相当于需要借2位），取6位
            sb.append(toBase64[v << 2 & 0x3F]);
            sb.append('=');
        }else if (count == 2){
            //如果需要补2个等号
            //bytes[index]化成8位二进制数
            int v = (bytes[index] & 0xFF);
            //每6位为一组转化成十进制数，然后把找到char[十进制数]对应的值放入StringBuilder
            //右移2位，取6位
            sb.append(toBase64[v >>> 2 & 0x3F]);
            //左移4位（相当于需要借4位），取6位
            sb.append(toBase64[v << 4 & 0x3F]);
            sb.append('=');
            sb.append('=');
        }
        return sb.toString();
    }

    /**
     * 解码方法
     * @param str 字符串
     * @return 返回解码后的字符串
     */
    public static String reversalBase64(String str) {
        //记录=的数量
        int count = 0;
        //arr下标指针
        int index = 0;
        //bytes下标指针
        int indexs = 0;
        //遍历字符串得到=的数量
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '=') {
                count++;
            }
        }
        //new一个arr数组用来存放非=的字符串
        int length = str.length() - count;
        int[] arr = new int[length];
        //得到arr数组的值所对应的char数组的下标
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < toBase64.length; j++) {
                if (str.charAt(i) == toBase64[j]) {
                    arr[i] = j;
                }
            }
        }
        //new一个bytes数组用来存放解码后的字符串的每一个字符
        byte[] bytes = new byte[str.length() / 4 * 3 - count];
        while ((length / 4) > 0) {
            //当arr数组长度大于等于4时，就将arr[index]，arr[index + 1]，arr[index + 2]，arr[index + 3]
            // （每一个arr[]都由6位二进制数组成）拼接成24位二进制数
            int v = (arr[index] & 0x3F) << 18 | (arr[index + 1] & 0x3F) << 12 | (arr[index + 2] & 0x3F) << 6 | (arr[index + 3] & 0x3F);
            //每8位为一组转化成byte型，并赋值给bytes
            //右移16位，取8位
            bytes[indexs] = (byte) (v >>> 16 & 0xFF);
            //右移8位，取8位
            bytes[indexs + 1] = (byte) (v >>> 8 & 0xFF);
            //取8位
            bytes[indexs + 2] = (byte) (v & 0xFF);
            //bytes下标指针加3
            indexs += 3;
            //arr下标指针加4
            index += 4;
            //arr数组长度减4
            length -= 4;
            //如果还满足(length / 4) > 0，取接下来的4个arr[]进行拼接，不满足则跳出循环
        }

        if (count == 1) {
            //如果存在1个=
            //将arr[index]，arr[index + 1]，arr[index + 2]拼接成18位二进制数
            int v = (arr[index] & 0x3F) << 12 | (arr[index + 1] & 0x3F) << 6 | (arr[index + 2] & 0x3F);
            //每8位为一组转化成byte型，并赋值给bytes
            //右移10位，取8位
            bytes[indexs] = (byte) (v >>> 10 & 0xFF);
            //右移2位，取8位
            bytes[indexs + 1] = (byte) (v >>> 2 & 0xFF);
        } else if (count == 2) {
            //如果存在2个=
            //将arr[index]，arr[index + 1]拼接成12位二进制数
            int v = (arr[index] & 0x3F) << 6 | (arr[index + 1] & 0x3F);
            //每8位为一组转化成byte型，并赋值给bytes
            //右移4位，取8位
            bytes[indexs] = (byte) (v >>> 4 & 0xFF);
        }
        //将bytes数组中存的字符转换成String类型
        String result = new String(bytes, StandardCharsets.UTF_8);
        return result;
    }

}


