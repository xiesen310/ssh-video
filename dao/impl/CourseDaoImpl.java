package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.CourseDao;
import top.xiesen.sshvideo.model.Course;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:57
 **/
@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Course> selectAllCourse() {
        List<Course> list = (List<Course>) hibernateTemplate.find("from Course");
        return list;
    }

    @Override
    public void addCourse(Course course) {
        hibernateTemplate.save(course);
    }

    @Override
    public void deleteCourse(Course course) {
        hibernateTemplate.delete(course);
    }

    @Override
    public void updateCourse(Course course) {
        hibernateTemplate.update(course);
    }

    @Override
    public List<Course> selectCourseById(Integer courseId) {
        List<Course> list = (List<Course>) hibernateTemplate.find("from Course where id = ? ", courseId);
        return list;
    }
}
