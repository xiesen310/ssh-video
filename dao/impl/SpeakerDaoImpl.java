package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.SpeakerDao;
import top.xiesen.sshvideo.model.Speaker;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:20
 **/
@Repository
public class SpeakerDaoImpl implements SpeakerDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Speaker> selectAllSpeaker() {
        List<Speaker> list = (List<Speaker>) hibernateTemplate.find("from Speaker");
        return list;
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        hibernateTemplate.save(speaker);
    }

    @Override
    public void deleteSpeakerById(int id) {
        Speaker speaker = new Speaker();
        speaker.setId(id);
        hibernateTemplate.delete(speaker);
    }

    @Override
    public Speaker selectSpeakerById(Integer id) {
        List<Speaker> list = (List<Speaker>) hibernateTemplate.find("from Speaker where id = ?", id);
        Speaker speaker = null;
        for (Speaker s:list) {
            speaker = s;
        }
        return speaker;
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        hibernateTemplate.update(speaker);
    }

    @Override
    public List<Speaker> selectSpeakerByNameAndJob(Speaker speaker) {
        List<Speaker> speakers = (List<Speaker>) hibernateTemplate.find("from Speaker where speaker_name like ? and speaker_job like ?", "%" + speaker.getSpeaker_name() + "%", "%" + speaker.getSpeaker_job() + "%");
        return speakers;
    }
}
