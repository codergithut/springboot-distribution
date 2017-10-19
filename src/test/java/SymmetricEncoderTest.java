import app.util.SymmetricEncoder;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public class SymmetricEncoderTest {

    @Test
    public void symmetricEncoderTest() {
        SymmetricEncoder se=new SymmetricEncoder();
        String encodeRules="22";
        String content = "22";
        /*
         * 加密
         */
        System.out.println("使用AES对称加密，请输入加密的规则" + encodeRules);

        System.out.println("请输入要加密的内容:" + content);

        String encodeResult = se.AESEncode(encodeRules, content);
        System.out.println("根据输入的规则"+encodeRules+"加密后的密文是:"+encodeResult);

        /*
         * 解密
         */
        System.out.println("使用AES对称解密，请输入加密的规则：(须与加密相同)" + encodeRules);
        System.out.println("请输入要解密的内容（密文）:" + encodeResult);
        System.out.println("根据输入的规则"+encodeRules+"解密后的明文是:"+se.AESDncode(encodeRules, encodeResult));
    }
}
