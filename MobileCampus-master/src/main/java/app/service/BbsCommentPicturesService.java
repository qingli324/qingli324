package app.service;

import app.Model.PictureResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by 青离 on 2017/6/19.
 */
@Service
public class BbsCommentPicturesService {

    private static String filepath = "D:/mobileTmp";
    private static String baseUrl = "http://";

    public PictureResult uploadPicture(MultipartFile[] pics) {

        PictureResult pictureResult = new PictureResult();
        String allUrls = "";

       if (pics == null || pics.length == 0) {
            System.out.println("文件为空");
            pictureResult.setError(0);
            pictureResult.setMessage("文件为空");
            return pictureResult;
        }

        for (int i = 0; i < pics.length; i++) {
            //String picName = System.currentTimeMillis() + pic.getOriginalFilename();
            String picName = System.currentTimeMillis() + pics[i].getOriginalFilename();
            File file = new File(filepath, picName);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(pics[i].getBytes());
            } catch (Exception e) {
                pictureResult.setError(1);
                //System.out.println("上传文件失败");
                pictureResult.setMessage("上传文件失败");
                return pictureResult;
            }
            InetAddress addr = null;
            try {
                addr = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            String ip = addr.getHostAddress().toString();//获得本机IP
            //一张图片的url地址
            String url = baseUrl + ip + "/" + picName;
            allUrls = allUrls + url +";";
        }
        pictureResult.setError(0);
        pictureResult.setUrl(allUrls);
        return pictureResult;
    }
}
