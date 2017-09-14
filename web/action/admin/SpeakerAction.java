package top.xiesen.sshvideo.web.action.admin;
/**
 * Created by Allen on 2017/9/12.
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.xiesen.sshvideo.model.Speaker;
import top.xiesen.sshvideo.service.SpeakerService;

import java.util.List;

/**
 * todo
 *
 * @author Allen
 * @create 2017-09-12 17:22
 **/

@Controller
@Scope(scopeName = "propotype")
public class SpeakerAction extends ActionSupport implements ModelDriven<Speaker>{

    @Autowired
    private SpeakerService speakerService;

    private Speaker speaker = new Speaker();

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public String speakerList(){
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        System.out.println(speakers);
        ActionContext.getContext().put("speakerList",speakers);
        return SUCCESS;
    }

    public String addSpeaker(){
        return SUCCESS;
    }

    public String doAddSpeaker(){
        speakerService.addSpeaker(speaker);
        return SUCCESS;
    }

    @Override
    public Speaker getModel() {
        return speaker;
    }
    public String deleteSpeaker(){
       speakerService.deleteSpeakerById(speaker.getId());
        return SUCCESS;
    }
    public String editSpeaker(){
        Integer speakerId = speaker.getId();
        speaker = speakerService.selectSpeakerById(speakerId);
        return SUCCESS;
    }

    public String doEditSpeaker(){
        System.out.println(speaker.getId());
        speakerService.updateSpeaker(speaker);
        return SUCCESS;
    }

    public String selectSpeakerByNameAndJob(){
        List<Speaker> speakers = speakerService.selectSpeakerByNameAndJob(speaker);
        System.out.println("speakers对象："+speakers);
        ActionContext.getContext().put("speakerList",speakers);
        return SUCCESS;
    }
}
