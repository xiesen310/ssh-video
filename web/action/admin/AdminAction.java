package top.xiesen.sshvideo.web.action.admin;
/**
 * Created by Allen on 2017/9/12.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Admin;
import top.xiesen.sshvideo.service.AdminService;
import top.xiesen.sshvideo.utils.MD5Utils;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 16:22
 **/

@Controller
@Scope(scopeName = "porotype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

    private Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Autowired
    AdminService adminService;


    public String login() throws Exception {
        return SUCCESS;
    }
    /*处理登录流程*/
    public String doLogin() throws Exception {
        Admin login = adminService.login(admin.getLoginName(), MD5Utils.MD5Encrypt(admin.getLoginPwd()));
        if(login == null){
            return ERROR;
        }
        ActionContext.getContext().getSession().put("admin",login);
        return SUCCESS;
    }
    /*处理退出流程*/
    public String exitLogin() throws Exception {
        ActionContext.getContext().getSession().remove("admin");
        return SUCCESS;
    }

    @Override
    public Admin getModel() {
        return admin;
    }
}
