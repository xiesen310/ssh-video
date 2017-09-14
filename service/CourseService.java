package top.xiesen.sshvideo.service;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Course;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:58
 **/
public interface CourseService {
    List<Course> selectAllCourse();

    void addCourse(Course course);

    void deleteCourse(Course course);

    void updateCourse(Course course);

    List<Course> selectCourseById(Integer courseId);
}
