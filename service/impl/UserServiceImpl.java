package top.xiesen.sshvideo.service.impl;/**
 * Created by Allen on 2017/9/14.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.sshvideo.dao.UserDao;
import top.xiesen.sshvideo.model.User;
import top.xiesen.sshvideo.service.UserService;
import top.xiesen.sshvideo.utils.MD5Utils;
import top.xiesen.sshvideo.utils.MailUtil;

import java.sql.Date;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-14 9:58
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        user.setPassword(MD5Utils.MD5Encrypt(user.getPassword()));
        return userDao.login(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void updateUserPassword(User user) {
        userDao.updateUserPassword(user);
    }

    @Override
    public void updateUserPic(User user) {
        userDao.updateUserPic(user);
    }

    @Override
    public Boolean addRegist(User user) {
        User user1 = userDao.selectUser(user);
        if(user1 == null){
            user.setInsert_time(new Date(System.currentTimeMillis()));
            userDao.addRegist(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean sendemail(User user) {
        User user1 = userDao.selectUser(user);
        if(user1 != null){
            String capcha =  MailUtil.createRandom();
            user.setCaptcha(capcha);
            // 发送邮件
            try {
                MailUtil.send(user.getEmail(),"智游在线公开课","智游在线公开课找回密码，您的验证码信息是：" + capcha);
            } catch (Exception e) {
                e.printStackTrace();
            }
            userDao.updateBymail(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUserResetPassword(User user) {
        User user1 = userDao.selectUser(user);
        if(user.getCaptcha().equals(user1.getCaptcha())){
            return true;
        }
        return false;
    }

    @Override
    public void updateResrtPassword(User user) {
        userDao.updateResrtPassword(user);
    }

}
