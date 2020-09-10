package com.aaa.controller.front;

import com.aaa.entity.ImgInfo;
import com.aaa.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("Reception/editor")
public class WangEditorController {
    @Resource
    FileUtil fileUtil;

    @RequestMapping("upload")
    @ResponseBody
    public ImgInfo uploadNew(@RequestParam(value = "file") MultipartFile uploadFile, HttpServletResponse response){
        try {
            //检查是否是图片
            BufferedImage bi = ImageIO.read(uploadFile.getInputStream());
            if(bi == null){
                return null;
            }else{
                String upload = fileUtil.upload(uploadFile);
                String load = "http://localhost:8088/springboot/"+upload;
                String[] values = { load };

                ImgInfo imgInfo = new ImgInfo();
                imgInfo.setError(0);
                imgInfo.setUrl(values);

                System.out.println(imgInfo.toString());
                return imgInfo;
            }
        }catch (Exception e){
            return null;
        }
    }

}
