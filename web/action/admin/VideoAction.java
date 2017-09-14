package top.xiesen.sshvideo.web.action.admin;/**
 * Created by Allen on 2017/9/12.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Course;
import top.xiesen.sshvideo.model.Speaker;
import top.xiesen.sshvideo.model.Subject;
import top.xiesen.sshvideo.model.Video;
import top.xiesen.sshvideo.service.CourseService;
import top.xiesen.sshvideo.service.SpeakerService;
import top.xiesen.sshvideo.service.SubjectService;
import top.xiesen.sshvideo.service.VideoService;
import top.xiesen.sshvideo.utils.Page;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 16:51
 **/
@Controller
@Scope(scopeName = "porotype")
public class VideoAction extends ActionSupport implements ModelDriven<Video>{

    private String[] ids;
    private Video video = new Video();
    private String video_titles;
    private Integer speaker_namess;
    private Integer course_namess;
    private Integer page = 1;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getVideo_titles() {
        return video_titles;
    }

    public void setVideo_titles(String video_titles) {
        this.video_titles = video_titles;
    }

    public Integer getSpeaker_namess() {
        return speaker_namess;
    }

    public void setSpeaker_namess(Integer speaker_namess) {
        this.speaker_namess = speaker_namess;
    }

    public Integer getCourse_namess() {
        return course_namess;
    }

    public void setCourse_namess(Integer course_namess) {
        this.course_namess = course_namess;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SubjectService subjectService;

    public String videoList() throws Exception {
        if(video_titles == null){
            video_titles = "";
        }
        DetachedCriteria dcv1 = DetachedCriteria.forClass(Video.class);//count
        DetachedCriteria dcv2= DetachedCriteria.forClass(Video.class);//list

        DetachedCriteria dcs = DetachedCriteria.forClass(Speaker.class);
        DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);

        dcv1.setProjection(Projections.rowCount());
        if(speaker_namess != null){
            dcv1.add(Restrictions.eq("speaker_id", speaker_namess));
            dcv2.add(Restrictions.eq("speaker_id", speaker_namess));
        }
        if(course_namess != null){
            dcv1.add(Restrictions.eq("course_id", course_namess));
            dcv2.add(Restrictions.eq("course_id", course_namess));
        }
        if(video_titles != null && video_titles != ""){
            dcv1.add(Restrictions.like("video_title", video_titles, MatchMode.ANYWHERE));
            dcv2.add(Restrictions.like("video_title", video_titles,MatchMode.ANYWHERE));
        }

        ActionContext.getContext().put("cid", course_namess);
        ActionContext.getContext().put("sid", speaker_namess);
        ActionContext.getContext().put("title", video_titles);

        Page<Video> list = videoService.fingAllVideo(dcv1,dcv2,page);
        ActionContext.getContext().put("pages", list);

        List<Speaker> speakers = speakerService.selectAllSpeaker();
        ActionContext.getContext().put("speakerList",speakers);

        List<Course> courses = courseService.selectAllCourse();
        ActionContext.getContext().put("courseList",courses);

        System.out.println(course_namess+"---" + speaker_namess + "---" + video_titles);

        return SUCCESS;
    }

    public String deleteVideo(){
        System.out.println(video.getId());
        videoService.deleteVideo(video);
        return SUCCESS;
    }

    public String editVideo(){

        Integer videoId = video.getId();
        video = videoService.selectVideoById(videoId);


        List<Speaker> speakers = speakerService.selectAllSpeaker();
        ActionContext.getContext().put("speakerList",speakers);

        List<Course> courses = courseService.selectAllCourse();
        ActionContext.getContext().put("courseList",courses);

        return SUCCESS;
    }

    public String doEditVideo(){
        videoService.updateVideo(video);
        return SUCCESS;
    }

    public String addVideo(){
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        ActionContext.getContext().put("speakerList",speakers);

        /*List<Subject> subjects = subjectService.selectAllSubject();
        ActionContext.getContext().put("subjectList",subjects);*/
        List<Course> courses = courseService.selectAllCourse();
        ActionContext.getContext().put("coursesList",courses);
        return SUCCESS;
    }

    public String doAddVideo(){
        videoService.addVideo(video);
        return SUCCESS;
    }

    public String batchDelect(){
        System.out.println("ids:" + ids);
        for(int i = 0; i < ids.length;i++){
            video.setId(Integer.parseInt(ids[i]));
            videoService.deleteVideo(video);
        }
        return SUCCESS;
    }
    @Override
    public Video getModel() {
        return video;
    }
}
