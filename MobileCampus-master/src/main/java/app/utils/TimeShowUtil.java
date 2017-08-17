package app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 青离 on 2017/7/15.
 * 当天的显示无日期具体时间；昨天的显示为昨天；
 * 比昨天早且在过去一周内的，显示星期几；
 * 超过一周的时间，显示带有年月日的日期。
 */

public class TimeShowUtil {
        private int hour;
        private int day;
        private Date date;
        private DateFormat df;
        private String pointText;
        private Long time;
        private Long now;
//    private

        public TimeShowUtil(){
            hour=60*60*1000;
            day=(60*60*24)*1000;
            time=28800L;
            now=new Date().getTime();
            pointText="1970-01-01";
        }

        //获得当天0点时间
        public static Long getTimesmorning(){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return (Long) cal.getTimeInMillis();
        }


        //获取星期几
        public static String getWeekOfDate(Date dt) {
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }

        //当天时间的显示：几小时前、多少分钟前
        public String getHoursOrMins(Long time){
            //现在时间
            String flag = null;
            now = new Date().getTime();
            if (time <= now&&time!=null) {
                if(time > getTimesmorning()){//今天内的时间
                    if(time > now - hour){//一小时之内的时间
                        int mins=(int)(now - time)/(1000*60);
                        flag = mins + "分钟前";
                        return flag;
                    }else {//当天大于一小时的时间
                        int hours =(int)(now - time)/ hour;
                        flag = hours + "小时前";
                        return flag;
                    }
                }

            }
            return flag;

        }

        //获取时间点
        public String getTimePoint(Long time) {
            //现在时间
            now = new Date().getTime();
            //时间点比当天零点早
            if (time <= now&&time!=null) {
                date = new Date(time);
                if (time < getTimesmorning()) {
                    if (time >= getTimesmorning() - day) {//比昨天零点晚
                        pointText ="昨天";
                        return pointText;
                    } else {//比昨天零点早
                        if (time >= getTimesmorning() - 6 * day) {//比七天前的零点晚，显示星期几

                            return getWeekOfDate(date);
                        } else {//显示具体日期
                            df = new SimpleDateFormat("yyyy-MM-dd");
                            pointText = df.format(date);
                            return pointText;
                        }
                    }

                } else {//无日期时间,当天内具体时间
                    //df = new SimpleDateFormat("HH:mm");
                    //pointText = df.format(date);
                    pointText = getHoursOrMins(time);
                    return pointText;

                }

            }

            return pointText;
        }
}
