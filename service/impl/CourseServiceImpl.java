package top.xiesen.sshvideo.service.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.sshvideo.dao.CourseDao;
import top.xiesen.sshvideo.model.Course;
import top.xiesen.sshvideo.service.CourseService;

import java.sql.Date;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:58
 **/
@Service
public class CourseServiceImpl  implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> selectAllCourse() {
        return courseDao.selectAllCourse();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        course.setUpdate_time(new Date(System.currentTimeMillis()));
        courseDao.updateCourse(course);
    }

    @Override
    public List<Course> selectCourseById(Integer courseId) {
        return courseDao.selectCourseById(courseId);
    }
}
