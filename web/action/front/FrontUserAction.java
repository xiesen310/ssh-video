package top.xiesen.sshvideo.web.action.front;/**
 * Created by Allen on 2017/9/13.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Result;
import top.xiesen.sshvideo.model.User;
import top.xiesen.sshvideo.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 22:14
 **/
@Controller
@Scope(scopeName = "porotype")
public class FrontUserAction extends ActionSupport implements ModelDriven<User>{

    private User user = new User();
    private Result result = new Result();
    private String newPassword;

    private File image_file;
    private String image_fileFileName;
    private String image_fileContentType;

    public File getImage_file() {
        return image_file;
    }

    public void setImage_file(File image_file) {
        this.image_file = image_file;
    }

    public String getImage_fileFileName() {
        return image_fileFileName;
    }

    public void setImage_fileFileName(String image_fileFileName) {
        this.image_fileFileName = image_fileFileName;
    }

    public String getImage_fileContentType() {
        return image_fileContentType;
    }

    public void setImage_fileContentType(String image_fileContentType) {
        this.image_fileContentType = image_fileContentType;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Autowired
    private UserService userService;
    // 登录
    public String login(){
        user = userService.login(user);
        result.setSuccess(user == null ? false:true);
        ActionContext.getContext().getSession().put("_front_user",user);
        ActionContext.getContext().getSession().put("user",user);
        result.setMessage("用户名或密码错误");
        return "jsonLogin";
    }
    // 退出
    public String logout(){
        ActionContext.getContext().getSession().remove("user");
        ActionContext.getContext().getSession().remove("_front_user");
        return "loginout";
    }
    // 跳转到user首页
    public String toIndex(){
        return "toIndex";
    }

    public String index(){
        return "index";
    }
    //
    public String profile(){
        user = (User) ActionContext.getContext().getSession().get("user");
        return "profile";
    }
    // 保存更新
    public String doprofile(){

        user = userService.updateUser(user);
        ActionContext.getContext().getSession().put("_front_user",user);
        ActionContext.getContext().getSession().put("user",user);
        return "doprofile";
    }
    // 条状密码界面
    public String password(){
        return "password";
    }
    public String dopassword(){
        user = (User) ActionContext.getContext().getSession().get("user");
        user.setPassword(newPassword);
        System.out.println("newPassword:"+ newPassword);
        userService.updateUserPassword(user);
        return "dopassword";
    }
    // 跳转头像页面
    public String avatar(){
        return "avatar";
    }
    // 上传头像
    public String doavatar() throws IOException {
        user = (User) ActionContext.getContext().getSession().get("user");
        // 产生随机的名字
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取图像的后缀名
        String extension = FilenameUtils.getExtension(image_fileFileName);
        // 拼接新起的图片名
        String fileName = str + "." + extension;
        // 设置图像上传后的路径，D:\IDEA\project\ssh-video\pic
        String path = "D:\\IDEA\\project\\ssh-video\\pic\\";
        FileUtils.copyFile(image_file,new File(path+fileName));
        user.setHead_url(fileName);
        userService.updateUserPic(user);
        return "doavatar";
    }
    public String regist(){
        result.setMessage("该邮箱已经被注册");
        result.setSuccess(userService.addRegist(user));
        return "jsonRegist";
    }
    // 跳转忘记密码页面
    public String forgetpwd(){
        return "forgetpwd";
    }
    // 发送邮件
    public String sendemail(){
        result.setMessage("邮箱不存在，别给我胡扯");
        result.setSuccess(userService.sendemail(user));
        return "sendemail";
    }

   // 提交忘记密码
    public String toforgetpwd(){
        Boolean b = userService.updateUserResetPassword(user);
        String a = "";
        System.out.println();
        if(b==false){
            ActionContext.getContext().put("message","验证码不正确");
            a = "forgetpwd";
        }else {
            a = "toforgetpwd";
        }
        return a;
    }
    // 重置密码
    public String resetpwd(){
        userService.updateResrtPassword(user);
        return "resetpwd";
    }
    // 重置按钮
    public String resetting(){
        return "resetting";
    }
    @Override
    public User getModel() {
        return user;
    }
}
