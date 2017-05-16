package com.pxx.tools.ali;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;

/**
 * 阿里云 OSS 操作类
 */
public class Oss {

    private  OSSClient ossClient;


    /**
     *
     * @param accessKeyId  <yourAccessKeyId>
     * @param accessKeySecret <yourAccessKeySecret>
     * @param endpoint <yourOssEndpoint>
     */
    public Oss (String accessKeyId, String accessKeySecret, String  endpoint ) {

        this.ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    }

    /**
     *
     * @param bucketName <yourBucketName>
     * @param path <fileSavePath>
     * @param content <fileSaveContent>
     */
    public void putObject (String bucketName, String path, String content) {
        this.ossClient.putObject(bucketName, path , new ByteArrayInputStream(content.getBytes()));

    }

}
