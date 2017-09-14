package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/14.
 */

import top.xiesen.sshvideo.model.User;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-14 9:57
 **/
public interface UserDao {

    User login(User user);

    User updateUser(User user);

    void updateUserPassword(User user);

    void updateUserPic(User user);

    void addRegist(User user);

    User selectUser(User user);

    void updateBymail(User user);

    void updateResrtPassword(User user);
}
