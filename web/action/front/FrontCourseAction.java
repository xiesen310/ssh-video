package top.xiesen.sshvideo.web.action.front;/**
 * Created by Allen on 2017/9/13.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.service.SubjectService;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 22:14
 **/
@Controller
@Scope(scopeName = "porotype")
public class FrontCourseAction extends ActionSupport {

    @Autowired
    private SubjectService subjectService;


    private String subjectId;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String toindex(){
        ActionContext.getContext().put("subject",subjectService.selectSubjectById(Integer.parseInt(subjectId)));
        return SUCCESS;
    }
}
