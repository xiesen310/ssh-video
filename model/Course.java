package top.xiesen.sshvideo.model;

import javax.xml.ws.Service;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {

	private Integer id;

    private String course_name;

    private String course_descr;

    private Date insert_time;

    private Date update_time;

    private Integer subject_id;
    
    private String subject_name;

    private List<Video> videoList;

    private Subject subject;

    private Set<Video> setVideo = new HashSet<>();

	public Set<Video> getSetVideo() {
		return setVideo;
	}

	public void setSetVideo(Set<Video> setVideo) {
		this.setVideo = setVideo;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", course_name='" + course_name + '\'' +
				", course_descr='" + course_descr + '\'' +
				", insert_time=" + insert_time +
				", update_time=" + update_time +
				", subject_id=" + subject_id +
				", subject_name='" + subject_name + '\'' +
				", videoList=" + videoList +
				", subject=" + subject +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_descr() {
		return course_descr;
	}

	public void setCourse_descr(String course_descr) {
		this.course_descr = course_descr;
	}

	public Date getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public List<Video> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
