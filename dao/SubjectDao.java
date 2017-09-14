package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/13.
 */

import top.xiesen.sshvideo.model.Subject;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 10:38
 **/
public interface SubjectDao {
    List<Subject> selectAllSubject();
    Subject selectSubjectById(int id);
}
