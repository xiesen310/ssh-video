package top.xiesen.sshvideo.service.impl;
/**
 * Created by Allen on 2017/9/12.
 */

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.sshvideo.dao.VideoDao;
import top.xiesen.sshvideo.model.Video;
import top.xiesen.sshvideo.service.VideoService;
import top.xiesen.sshvideo.utils.Page;

import java.sql.Date;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:16
 **/

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public Page loadPage(String video_title, String speaker_name, String course_name, Integer page) {
        Page<Video> pages = new Page<>();
        pages.setPage(page);
        //pages.setRows(videoDao.selectVideo(video_title, speaker_name, course_name,(page-1)*5));

        System.out.println(videoDao.selectVideo(video_title, speaker_name, course_name,(page-1)*5));
        pages.setSize(5);
        pages.setTotal(videoDao.selectVideoCount(video_title, speaker_name, course_name));
        return pages;
    }

    @Override
    public List<Video> selectAllVideo() {
        return videoDao.selectAllVideo();
    }

    @Override
    public void deleteVideo(Video video) {
        videoDao.deleteVideo(video);
    }

    @Override
    public Video selectVideoById(Integer videoId) {
        return videoDao.selectVideoById(videoId);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public void addVideo(Video video) {
        video.setInsert_time(new Date(System.currentTimeMillis()));
        videoDao.addVideo(video);
    }

    @Override
    public List<Object[]> selectVideoByXY() {
        return videoDao.selectVideoByXY();
    }

    @Override
    public Page<Video> fingAllVideo(DetachedCriteria dcv1, DetachedCriteria dcv2, Integer page) {
        Page<Video> pageInfo = new Page<>();
        pageInfo.setPage(page);
        pageInfo.setSize(7);
        pageInfo.setTotal(videoDao.findCount(dcv1));
        pageInfo.setRows(videoDao.findAllVideo(dcv2,page));
        System.out.println("查询"+videoDao.findCount(dcv1));
        return pageInfo;
    }

    @Override
    public void updateVideoById(String videoId) {
        videoDao.updateVideoById(videoId);
    }


}
