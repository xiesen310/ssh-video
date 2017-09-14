package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/13.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.SubjectDao;
import top.xiesen.sshvideo.model.Subject;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-13 10:38
 **/
@Repository
public class SubjectDaoImpl implements SubjectDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Subject> selectAllSubject() {
        List<Subject> list = (List<Subject>) hibernateTemplate.find("from Subject");
        return list;
    }

    @Override
    public Subject selectSubjectById(int id) {
        Subject subject = hibernateTemplate.get(Subject.class, id);
        return subject;
    }
}
