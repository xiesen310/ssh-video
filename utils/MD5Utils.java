package top.xiesen.sshvideo.utils;

import org.springframework.util.DigestUtils;

/**
 * 加密
 */
public class MD5Utils {

    public static String MD5Encrypt (String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
