package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.AdminDao;
import top.xiesen.sshvideo.model.Admin;

import java.util.List;

/**
 * todo
 * @author Allen
 * @create 2017-09-12 16:33
 **/
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Admin login(String loginName, String loginPwd) {
        List<Admin> list = (List<Admin>) hibernateTemplate.find("from Admin where loginName =? and loginPwd = ?", loginName, loginPwd);
        Admin admin = null;
        for (Admin a:list) {
            admin = a;
        }
        return admin;
    }
}
