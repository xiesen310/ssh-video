package top.xiesen.sshvideo.service.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.sshvideo.dao.SpeakerDao;
import top.xiesen.sshvideo.model.Speaker;
import top.xiesen.sshvideo.service.SpeakerService;

import java.sql.Date;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:21
 **/
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public List<Speaker> selectAllSpeaker() {
        return speakerDao.selectAllSpeaker();
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speaker.setInsert_time(new Date(System.currentTimeMillis()));
        speakerDao.addSpeaker(speaker);
    }

    @Override
    public void deleteSpeakerById(int id) {
        speakerDao.deleteSpeakerById(id);
    }

    @Override
    public Speaker selectSpeakerById(Integer id) {
        return speakerDao.selectSpeakerById(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }

    @Override
    public List<Speaker> selectSpeakerByNameAndJob(Speaker speaker) {
        return speakerDao.selectSpeakerByNameAndJob(speaker);
    }
}
