package app.service;

import app.Model.PictureResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xdcao on 2017/6/9.
 */
@Service
public class PictureService {

    private static String filepath="D:/mobileTmp";
    private static String baseUrl="http://";

    public PictureResult uploadPicture(MultipartFile pic) {

        PictureResult pictureResult=new PictureResult();

        if (pic==null){
            System.out.println("文件为空");
            pictureResult.setError(1);
            pictureResult.setMessage("文件为空");
            return pictureResult;
        }

        String picName=System.currentTimeMillis()+pic.getOriginalFilename();
        File file=new File(filepath,picName);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(pic.getBytes());
        }catch (Exception e){
            pictureResult.setError(1);
            System.out.println("上传文件失败");
            pictureResult.setMessage("上传文件失败");
            return pictureResult;
        }

        pictureResult.setError(0);

        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip=addr.getHostAddress().toString();//获得本机IP

        pictureResult.setUrl(baseUrl+ip+"/"+picName);
        return pictureResult;


    }

}
