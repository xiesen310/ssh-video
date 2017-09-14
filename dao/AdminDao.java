package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Admin;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 16:33
 **/
public interface AdminDao {
    Admin login(String loginName, String loginPwd);
}
