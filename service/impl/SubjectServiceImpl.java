package top.xiesen.sshvideo.service.impl;/**
 * Created by Allen on 2017/9/13.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.SubjectDao;
import top.xiesen.sshvideo.model.Subject;
import top.xiesen.sshvideo.service.SubjectService;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 10:39
 **/
@Repository
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> selectAllSubject() {
        return subjectDao.selectAllSubject();
    }

    @Override
    public Subject selectSubjectById(int id) {
        return subjectDao.selectSubjectById(id);
    }
}
