package top.xiesen.sshvideo.dao.impl;/**
 * Created by Allen on 2017/9/12.
 */

import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import top.xiesen.sshvideo.dao.VideoDao;
import top.xiesen.sshvideo.model.Video;

import java.math.BigInteger;
import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:15
 **/

@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Video> selectVideo(String video_title, String speaker_id, String course_id, int i) {
        if(video_title == null){
            video_title="";
        }
        String sql = "FROM video v LEFT JOIN course c1 ON v.course_id = c1.id LEFT JOIN speaker s1 ON v.speaker_id = s1.id " +
                "WHERE v.video_title LIKE '%' ? '%'";
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = null;
        if(speaker_id != null &&course_id != null){
            sql += "AND s1.speaker_id = ? AND c1.course_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, speaker_id).setParameter(2, course_id);
        }else if (speaker_id != null){
            sql += "AND s1.speaker_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, speaker_id);
        }else if(course_id != null){
            sql += "AND c1.course_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, course_id);
        }else {
            query = session.createSQLQuery(sql).setParameter(0, video_title);
        }
        List<Video> list = query.list();
        return list;
    }

    @Override
    public int selectVideoCount(String video_title, String speaker_id, String course_id) {
        if(video_title == null){
            video_title="";
        }

        String sql = "SELECT count(*) " +
                "FROM video v LEFT JOIN course c ON v.course_id = c.id LEFT JOIN speaker s ON v.speaker_id = s.id " +
                "WHERE v.video_title LIKE '%' ? '%'";
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = null;
        if(speaker_id != null &&course_id != null){
            sql += "AND s.speaker_name = ? AND c.course_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, speaker_id).setParameter(2, course_id);
        }else if (speaker_id != null){
            sql += "AND s.speaker_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, speaker_id);
        }else if(course_id != null){
            sql += "AND c.course_name = ?";
            query = session.createSQLQuery(sql).setParameter(0, video_title).setParameter(1, course_id);
        }else {
            query =  session.createSQLQuery(sql).setParameter(0, video_title);
        }
        BigInteger  o = (BigInteger) query.uniqueResult();
        return o.intValue();
    }

    @Override
    public List<Video> selectAllVideo() {
        List<Video> list = (List<Video>) hibernateTemplate.find("from Video");
        return list;
    }
    @Override
    public void deleteVideo(Video video) {
        hibernateTemplate.delete(video);
    }

    @Override
    public Video selectVideoById(Integer videoId) {
        List<Video> list = (List<Video>) hibernateTemplate.find("from Video where id = ?", videoId);
        Video video = null;
        for (Video v:list) {
            video = v;
        }
        return video;
    }

    @Override
    public void updateVideo(Video video) {
        hibernateTemplate.update(video);
    }

    @Override
    public void addVideo(Video video) {
        hibernateTemplate.save(video);
    }

    @Override
    public List<Object[]> selectVideoByXY() {
        String sql = "SELECT c.course_name ,avg(v.video_play_times) avg FROM video v RIGHT JOIN course c ON c.id = v.course_id GROUP BY v.course_id limit 1,5";
        List<Object[]> list = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).list();
        return list;
    }

    // 查询条数
    @Override
    public int findCount(DetachedCriteria dcv1) {
        List<Number> count =  (List<Number>) hibernateTemplate.findByCriteria(dcv1);
        Number number = count.get(0);
        int a = number.intValue();
        return a;
    }
    // 查询所有
    @Override
    public List<Video> findAllVideo(DetachedCriteria dcv2, Integer page) {
        List<Video> list = (List<Video>) hibernateTemplate.findByCriteria(dcv2, page, 7);
        return list;
    }

    @Override
    public void updateVideoById(String videoId) {
        Video video = hibernateTemplate.get(Video.class, Integer.parseInt(videoId));
        video.setVideo_play_times(video.getVideo_play_times()+1);
        hibernateTemplate.saveOrUpdate(video);
    }
}
