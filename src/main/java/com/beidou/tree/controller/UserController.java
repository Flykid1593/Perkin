package com.beidou.tree.controller;

import cn.hutool.core.util.ObjectUtil;
import com.beidou.tree.entity.User;
import com.beidou.tree.service.UserService;
import com.beidou.tree.service.UserServiceImpl;
import com.beidou.tree.util.*;
import lombok.AllArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.List;
import java.util.Map;
/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/8 0008 15:07
 */
@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 七牛云 公钥
     */
    @Value("${fem.file.accessKey}")
    String accessKey;
    /**
     * 七牛云 私钥
     */
    @Value("${fem.file.secretKey}")
    String secretKey;
    /**
     * 七牛云 空间名
     */
    @Value("${fem.file.bucket}")
    String bucket;
    /**
     * 下载文件拼接名
     */
    @Value("${fem.file.domainOfBucket}")
    String domainOfBucket;


    @GetMapping("/all")
    public List<User> selectAll(){
        return userService.selectAll();
    }

    @GetMapping("test")
    public  List<User> testBean(){
        User user =new User(1,"猪","200",90);
        UserServiceImpl pay =(UserServiceImpl) SpringContextUtils.getBean("userServiceImpl");
        List<User> users = pay.selectAll();
        return users;
    }
    @GetMapping("/qrCode")
    public Map qrCode() throws Exception {
        String uri = "我不管，我是你爹";
        // 嵌入二维码的图片路径
        String imgPath = "D:/ZJP.jpg";
        // 生成的二维码的路径及名称
        String destPath = "D:/jam.jpg";
        //生成二维码
        QRCodeUtil.encode(uri, imgPath, destPath, true);
        FileItem fileItem = FileUtils.createFileItem(destPath);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        //上传服务器
        Map map = UploadFile.upFile(mfile,accessKey,secretKey,bucket);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
        return map;
    }
    @GetMapping("/login")
    public Result login(String username, String password){
        System.out.println(username+"                                            "+password);
        User user = userService.selectByName(username);
        if(ObjectUtil.isEmpty(user)){
            return new Result().error("登录失败");
        }
        if(password.equals(user.getPassword())){
            return new Result().success("登陆成功");
        }
        return new Result().error("登录失败");
    }
}
