package top.xiesen.sshvideo.dao;/**
 * Created by Allen on 2017/9/12.
 */

import org.hibernate.criterion.DetachedCriteria;
import top.xiesen.sshvideo.model.Video;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:15
 **/
public interface VideoDao {
    List<Video> selectVideo(String video_title, String speaker_name, String course_name, int i);

    int selectVideoCount(String video_title, String speaker_name, String course_name);

    List<Video> selectAllVideo();

    void deleteVideo(Video video);

    Video selectVideoById(Integer videoId);

    void updateVideo(Video video);

    void addVideo(Video video);

    List<Object[]> selectVideoByXY();

    int findCount(DetachedCriteria dcv1);

    List<Video> findAllVideo(DetachedCriteria dcv2, Integer page);

    void updateVideoById(String videoId);
}
