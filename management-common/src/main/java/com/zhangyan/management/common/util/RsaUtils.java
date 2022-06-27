package com.zhangyan.management.common.util;

import com.sun.javafx.binding.StringConstant;
import com.zhangyan.management.common.constant.Constant;
import org.springframework.data.redis.cache.RedisCache;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-24 14:39
 * RSA密钥工具类
 */
public class RsaUtils {


    /**
     * 从redis中读取公钥
     *
     * @return 公钥对象
     * @throws Exception
     */
    public static PublicKey getPublicKey() throws Exception {
        String PublicKey = ConvertUtil.objectToString(SpringUtils.getBean(RedisUtil.class).get(Constant.PUBLICKEY));
        return getPublicKey(ConvertUtil.stringToByte(PublicKey));
    }

    /**
     * 从redis中读取密钥
     *
     * @return 私钥对象
     * @throws Exception
     */
    public static PrivateKey getPrivateKey() throws Exception {
        String PrivateKey = ConvertUtil.objectToString(SpringUtils.getBean(RedisUtil.class).get(Constant.PRIVATEKEY));
        return getPrivateKey(ConvertUtil.stringToByte(PrivateKey));
    }

    /**
     * 获取公钥
     *
     * @param bytes 公钥的字节形式
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * 获取密钥
     *
     * @param bytes 私钥的字节形式
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    /**
     * 根据密文，生存rsa公钥和私钥,并写入指定文件
     *
     * @param secret             生成密钥的密文
     */
    public static void generateKey(String secret, int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize, Constant.DEFAULT_KEY_SIZE), secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        String publicKey = new String(publicKeyBytes);
        //存入redis
        SpringUtils.getBean(RedisUtil.class).set(Constant.PUBLICKEY,publicKey);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        String privateKey = new String(privateKeyBytes);
        //存入redis
        SpringUtils.getBean(RedisUtil.class).set(Constant.PRIVATEKEY,privateKey);
    }




}
