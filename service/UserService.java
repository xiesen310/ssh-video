package top.xiesen.sshvideo.service;/**
 * Created by Allen on 2017/9/14.
 */

import top.xiesen.sshvideo.model.User;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-14 9:58
 **/
public interface UserService {

    User login(User user);

    User updateUser(User user);

    void updateUserPassword(User user);

    void updateUserPic(User user);

    Boolean addRegist(User user);

    Boolean sendemail(User user);

    Boolean updateUserResetPassword(User user);

    void updateResrtPassword(User user);
}
