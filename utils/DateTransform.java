package top.xiesen.sshvideo.utils;

/**
 * Created by Administrator on 2017/8/31.
 */
public class DateTransform {
    public static String intToStr(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = "00:" + intToStr(minute) + ":" + intToStr(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = intToStr(hour) + ":" + intToStr(minute) + ":" + intToStr(second);
            }
        }
        return timeStr;
    }

    public static void main(String[] args) {

        System.out.println(secToTime(900));
    }
}
