package top.xiesen.sshvideo;
/**
 * Created by Allen on 2017/9/12.
 */

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiesen.sshvideo.dao.UserDao;
import top.xiesen.sshvideo.dao.VideoDao;
import top.xiesen.sshvideo.model.User;
import top.xiesen.sshvideo.model.Video;

import java.util.Arrays;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 19:10
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Autowired
    HibernateTemplate hibernateTemplate;
    @Autowired
    VideoDao videoDao;
    @Autowired
    UserDao userDao;

    @org.junit.Test
    public void test1(){
        /*String sql = "SELECT c.course_name ,avg(v.video_play_times) avgs FROM video v RIGHT JOIN course c ON c.id = v.course_id GROUP BY v.course_id";
        List<Object[]> list = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).list();
        for (Object[] v:list) {
            System.out.println(Arrays.toString(v));
        }*/
        User user = new User();
        user.setEmail("xiesen310@163.com");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        User login = userDao.login(user);
        System.out.println(login);
    }

}
