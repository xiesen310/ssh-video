package top.xiesen.sshvideo.service.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.sshvideo.dao.AdminDao;
import top.xiesen.sshvideo.model.Admin;
import top.xiesen.sshvideo.service.AdminService;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 16:39
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username,password);
    }
}
