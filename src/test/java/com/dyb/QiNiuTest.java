/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.dyb;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.processing.OperationStatus;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.StringUtils;
import com.qiniu.util.UrlSafeBase64;
import org.junit.Test;

import java.io.IOException;

/**
 * @author dyb37716
 * @version $Id: QiNiuTest, v 0.1 2017/2/16 15:13 dyb37716 Exp $
 */
public class QiNiuTest {

    public static String ACCESS_KEY = "Y-TFVLn-Eo_4g0CWiHVbe_t1QCa8wWOvg2BkKCEw";

    public static String SECRET_KEY = "CJ4ZtPhFOr9y5Vb6reUHsiQpXfJpm9Jz3RUZSZvH";

    public static String BUCKET = "public-video";
    public static String KEY = "test.m3u8";
    public static String KEY2 = "Wildlife2.wmv";
    public static String filepath = "E:\\项目\\云聚线上课程UI\\resource\\b_zx_3hairstyles_1_1080.mp4";

    @Test
    public void testSimpleUpload() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //设置要转码的空间和key，并且这个key在你空间中存在


        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);
        try {
            //调用put方法上传
            Response res = uploadManager.put(filepath, KEY2, auth.uploadToken(BUCKET));
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
    public void testUploadAndDeal() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //设置转码操作参数
        String fops = "avthumb/m3u8/noDomain/1/segtime/15/vb/2400k";
        //设置转码的队列
        String pipeline = "video";
        //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
        //KEY = test.m3u8
        // filepath mp4 文件
        String urlbase64 = UrlSafeBase64.encodeToString(BUCKET + ":" + KEY);
        String pfops = fops + "|saveas/" + urlbase64;

        Zone z = Zone.autoZone();
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

    @Test
    public void hlsDeal() {
        String accessKey = ACCESS_KEY;
        String secretKey = SECRET_KEY;
        //待处理文件所在空间
        String bucket = "public-video";
        //待处理文件名
        String key = "o_1bdvs5m2d1kfcmh15m31qn1j8q5u.mp4";
        Auth auth = Auth.create(accessKey, secretKey);
        //数据处理指令，支持多个指令
        String pattern = UrlSafeBase64.encodeToString("jtvod$(count)");
        String fops = "avthumb/m3u8/noDomain/1/pattern/" + pattern + "/segtime/15/vb/2400k";

//        String saveMp4Entry = String.format("%s:avthumb_test_target.mp4", bucket);
//        String saveJpgEntry = String.format("%s:vframe_test_target.jpg", bucket);
//        String avthumbMp4Fop = String.format("avthumb/mp4|saveas/%s", UrlSafeBase64.encodeToString(saveMp4Entry));
//        String vframeJpgFop = String.format("vframe/jpg/offset/1|saveas/%s", UrlSafeBase64.encodeToString(saveJpgEntry));
        //将多个数据处理指令拼接起来
        String persistentOpfs = StringUtils.join(new String[]{
                fops
        }, ";");
        //数据处理队列名称，必须
        String persistentPipeline = "video";
        //数据处理完成结果通知地址
        String persistentNotifyUrl = "http://api.example.com/qiniu/pfop/notify";
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        //构建持久化数据处理对象
        OperationManager operationManager = new OperationManager(auth, cfg);
        try {
            String persistentId = operationManager.pfop(bucket, key, fops, persistentPipeline, persistentNotifyUrl, true);
            //可以根据该 persistentId 查询任务处理进度
            System.out.println(persistentId);
            OperationStatus operationStatus = operationManager.prefop(persistentId);
            System.out.println(operationStatus);
            //解析 operationStatus 的结果
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
        }
    }

    @Test
    public void hlsDealStatus() {
        Gson gson = new Gson();
        String accessKey = ACCESS_KEY;
        String secretKey = SECRET_KEY;
        Auth auth = Auth.create(accessKey, secretKey);
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        //构建持久化数据处理对象
        OperationManager operationManager = new OperationManager(auth, cfg);
        try {
            OperationStatus operationStatus = operationManager.prefop("z2.5938d0dce3d0041bf80a6d1a");
            System.out.println(gson.toJson(operationStatus));
            //解析 operationStatus 的结果
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
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
    public void resumeUpload() {
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

        UploadManager uploadManager = new UploadManager(c, recorder);

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
