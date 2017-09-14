package top.xiesen.sshvideo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject {

	private Integer id;
	private String subject_name;

	private Set<Course> setCourse = new HashSet<>();

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", subject_name='" + subject_name + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Set<Course> getSetCourse() {
		return setCourse;
	}

	public void setSetCourse(Set<Course> setCourse) {
		this.setCourse = setCourse;
	}
}
