package top.xiesen.sshvideo.web.action.admin;/**
 * Created by Allen on 2017/9/13.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Video;
import top.xiesen.sshvideo.service.VideoService;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 13:51
 **/
@Controller
@Scope(scopeName = "porotype")
public class CountAction extends ActionSupport{

    @Autowired
    private VideoService videoService;

    public String countList(){
        List<Object[]> objects = videoService.selectVideoByXY();
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();

        for (Object[] obj : objects) {
            x.append("'"+obj[0]+"',");
            y.append(obj[1]+",");
        }

        System.out.println("x:"+x);
        System.out.println("y:"+y);

        ActionContext.getContext().put("x",x.deleteCharAt(x.length()-1));
        ActionContext.getContext().put("y",y.deleteCharAt(y.length()-1));
        return SUCCESS;
    }

}
