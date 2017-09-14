package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/12.
 */

import top.xiesen.sshvideo.model.Speaker;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:20
 **/
public interface SpeakerDao {
    List<Speaker> selectAllSpeaker();

    void addSpeaker(Speaker speaker);

    void deleteSpeakerById(int id);

    Speaker selectSpeakerById(Integer id);

    void updateSpeaker(Speaker speaker);

    List<Speaker> selectSpeakerByNameAndJob(Speaker speaker);
}
