package top.xiesen.sshvideo.service;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Speaker;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:21
 **/
public interface SpeakerService {
    List<Speaker> selectAllSpeaker();

    void addSpeaker(Speaker speaker);

    void deleteSpeakerById(int id);

    Speaker selectSpeakerById(Integer id);

    void updateSpeaker(Speaker speaker);

    List<Speaker> selectSpeakerByNameAndJob(Speaker speaker);
}
