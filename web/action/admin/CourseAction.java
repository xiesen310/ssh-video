package top.xiesen.sshvideo.web.action.admin;/**
 * Created by Allen on 2017/9/13.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Course;
import top.xiesen.sshvideo.model.Speaker;
import top.xiesen.sshvideo.model.Subject;
import top.xiesen.sshvideo.service.CourseService;
import top.xiesen.sshvideo.service.SubjectService;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 11:11
 **/
@Controller
@Scope(scopeName = "propotype")
public class CourseAction extends ActionSupport implements ModelDriven<Course>{
    private Course course = new Course();
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;

    public String courseList(){
        List<Course> courses = courseService.selectAllCourse();
        ActionContext.getContext().put("courseList",courses);
        return SUCCESS;
    }
    public String addCourse(){
        List<Subject> subjects = subjectService.selectAllSubject();
        ActionContext.getContext().put("subject",subjects);
        return SUCCESS;
    }

    public String doAddCourses(){
        courseService.addCourse(course);
        return SUCCESS;
    }

    public String deleteCourse(){
        courseService.deleteCourse(course);
        return SUCCESS;
    }

    public String editCourse(){
        List<Subject> subjects = subjectService.selectAllSubject();
        ActionContext.getContext().put("subject",subjects);
        Integer courseId = course.getId();
        List<Course> courses = courseService.selectCourseById(courseId);
        if(courses != null){
            for (Course c:courses) {
                course = c;
            }
        }
        return SUCCESS;
    }

    public String doEditCourse(){
        courseService.updateCourse(course);
        return SUCCESS;
    }
    @Override
    public Course getModel() {
        return course;
    }
}
