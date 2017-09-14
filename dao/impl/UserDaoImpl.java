package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/14.
 */

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.UserDao;
import top.xiesen.sshvideo.model.User;
import top.xiesen.sshvideo.utils.MD5Utils;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-14 9:57
 **/

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public User login(User user) {
        Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(User.class);
        User u = (User) criteria.add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("password", user.getPassword())).uniqueResult();
        return u;
    }

    @Override
    public User updateUser(User user) {
        User user1 = hibernateTemplate.get(User.class, user.getId());
        user1.setNick_name(user.getNick_name());
        user1.setSex(user.getSex());
        user1.setBirthday(user.getBirthday());
        user1.setProvince(user.getProvince());
        user1.setCity(user.getCity());
        return user1;
    }

    @Override
    public void updateUserPassword(User user) {
        User user1 = hibernateTemplate.get(User.class, user.getId());
        user.setPassword(MD5Utils.MD5Encrypt(user.getPassword()));
        user1.setPassword(user.getPassword());
    }

    @Override
    public void updateUserPic(User user) {
        User user1 = hibernateTemplate.get(User.class, user.getId());
        user1.setHead_url(user.getHead_url());
    }

    @Override
    public void addRegist(User user) {
        user.setPassword(MD5Utils.MD5Encrypt(user.getPassword()));
        hibernateTemplate.save(user);
    }

    @Override
    public User selectUser(User user) {
        User user1 = (User) hibernateTemplate.getSessionFactory().openSession().createCriteria(User.class)
                .add(Restrictions.eq("email", user.getEmail())).uniqueResult();
        return user1;
    }

    @Override
    public void updateBymail(User user) {

        User user1 = (User) hibernateTemplate.getSessionFactory().openSession().createCriteria(User.class).add(Restrictions.eq("email", user.getEmail())).uniqueResult();
        user1.setCaptcha(user.getCaptcha());
        hibernateTemplate.saveOrUpdate(user1);

    }

    @Override
    public void updateResrtPassword(User user) {
        System.out.println(user);
        User user1 = (User) hibernateTemplate.getSessionFactory().openSession().createCriteria(User.class).add(Restrictions.eq("email", user.getEmail())).uniqueResult();
        user1.setPassword(MD5Utils.MD5Encrypt(user.getPassword()));
        hibernateTemplate.saveOrUpdate(user1);
    }


}
