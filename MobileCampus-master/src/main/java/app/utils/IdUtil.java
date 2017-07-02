package app.utils;

import java.util.Random;

/**
 * Created by 青离 on 2017/6/21.
 */
public class IdUtil {

    /**
     * id生成函数
     * id组成是由当前时间的毫秒数+两位随机数组成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}