/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.dyb;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import org.junit.Test;

import java.io.IOException;

/**
 *
 * @author dyb37716
 * @version $Id: QiNiuTest, v 0.1 2017/2/16 15:13 dyb37716 Exp $
 */
public class QiNiuTest {

    public static String ACCESS_KEY = "Y-TFVLn-Eo_4g0CWiHVbe_t1QCa8wWOvg2BkKCEw";

    public static String SECRET_KEY = "CJ4ZtPhFOr9y5Vb6reUHsiQpXfJpm9Jz3RUZSZvH";

    public static String BUCKET = " test-pri-video";
    public static String KEY = "Wildlife.wmv";
    public static String KEY2 = "Wildlife2.wmv";
    public static String filepath = "D:\\test\\video\\Wildlife.wmv";

    @Test
    public void testSimpleUpload(){
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //设置要转码的空间和key，并且这个key在你空间中存在


        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);
        try {
            //调用put方法上传
            Response res = uploadManager.put(filepath, KEY, auth.uploadToken(BUCKET));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    @Test
    public void testUploadAndDeal(){
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //设置转码操作参数
        String fops = "avthumb/m3u8/noDomain/1/vb/500k";
        //设置转码的队列
        String pipeline = "video";
        //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
//        String urlbase64 = UrlSafeBase64.encodeToString(BUCKET+":" + KEY);
        String pfops = fops;

        Zone z = Zone.zone0();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);
        try {
            //调用put方法上传
            Response res = uploadManager.put(filepath, KEY, auth.uploadToken(BUCKET, KEY, 3600, new StringMap()
                    .putNotEmpty("persistentOps", pfops)
                    .putNotEmpty("persistentPipeline", pipeline), true));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    //新建一个OperationManager对象
    //String fops = "avthumb/m3u8/noDomain/1/vb/500k/t/10";
    //    OperationManager operater = new OperationManager(auth,c);
    //    //设置要转码的空间和key，并且这个key在你空间中存在
    //    String bucket = "Bucket_Name";
    //    String key = "Bucket_key";
    //    //设置转码操作参数
    //    String fops = "avthumb/mp4/s/640x360/vb/1.25m";
    //    //设置转码的队列
    //    String pipeline = "yourpipelinename";
    //    //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
    //    String urlbase64 = UrlSafeBase64.encodeToString("目标Bucket_Name:自定义文件key");
    //    String pfops = fops + "|saveas/"+urlbase64;
    //    //设置pipeline参数
    //    StringMap params = new StringMap().putWhen("force", 1, true).putNotEmpty("pipeline", pipeline);
    //  try {
    //        String persistid = operater.pfop(bucket, key, pfops, params);
    //        //打印返回的persistid
    //        System.out.println(persistid);
    //    } catch (QiniuException e) {
    //        //捕获异常信息
    //        Response r = e.response;
    //        // 请求失败时简单状态信息
    //        System.out.println(r.toString());
    //        try {
    //            // 响应的文本信息
    //            System.out.println(r.bodyString());
    //        } catch (QiniuException e1) {
    //            //ignore
    //        }
    //    }

    @Test
    public void resumeUpload(){
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String recordPath = "D:\\test\\video\\Wildlife2.wmv";
        Recorder recorder = null;
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        try {
            recorder = new FileRecorder(recordPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UploadManager uploadManager = new UploadManager(c,recorder);

        try {
            //调用put方法上传
            Response res = uploadManager.put(recordPath, KEY2, auth.uploadToken(BUCKET));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
}
