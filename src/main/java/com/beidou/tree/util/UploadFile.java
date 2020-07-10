package com.beidou.tree.util;


import cn.hutool.core.util.RandomUtil;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 *
 * @author Perkin
 * @date 2019/9/25
 */
@Component
public class UploadFile {

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

    public static Map upFile(MultipartFile file, String accessKey, String secretKey, String bucket) throws Exception {
        //华北
        Configuration configuration = new Configuration(Region.huabei());

        UploadManager uploadManager = new UploadManager(configuration);
        // 生成文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = RandomUtil.randomString(16) + "." + suffix;

        // 自定义返回格式
        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(bucket);

        try {
            // 调用上传
            Response response = uploadManager.put(file.getInputStream(), fileName, uploadToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            String acc = putRet.key;
            Map  map= new HashMap(16);
            map.put("key",acc);
            map.put("putRet",putRet);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
