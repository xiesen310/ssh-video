package top.xiesen.sshvideo.service;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Admin;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 16:37
 **/
public interface AdminService {
    Admin login(String username, String password);
}
