package top.xiesen.sshvideo.service;/**
 * Created by Allen on 2017/9/12.
 */

import org.hibernate.criterion.DetachedCriteria;
import top.xiesen.sshvideo.model.Video;
import top.xiesen.sshvideo.utils.Page;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:15
 **/
public interface VideoService {
    Page loadPage(String video_title, String speaker_name, String course_name, Integer page);

    List<Video> selectAllVideo();

    void deleteVideo(Video video);

    Video selectVideoById(Integer videoId);

    void updateVideo(Video video);

    void addVideo(Video video);


    List<Object[]> selectVideoByXY();

    Page<Video> fingAllVideo(DetachedCriteria dcv1, DetachedCriteria dcv2, Integer page);

    void updateVideoById(String videoId);
}
