package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Course;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:57
 **/
public interface CourseDao {
    List<Course> selectAllCourse();

    void addCourse(Course course);

    void deleteCourse(Course course);

    void updateCourse(Course course);

    List<Course> selectCourseById(Integer courseId);
}
