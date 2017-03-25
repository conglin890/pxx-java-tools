package com.pxx.tools;



import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http 请求 POST GET
 */
public class PxxHttp {
    private static Logger logger = Logger.getLogger(PxxHttp.class);


    /**
     * 发送post请求， 返回body
     *
     * @param url  请求url
     * @param params  请求参数
     * @return
     * @throws IOException
     */
    public  String post (String url, Map<String, String> params) throws IOException {


        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        List <NameValuePair> nameValuePairList = new ArrayList <NameValuePair>();

        params.forEach( (key, value) -> {
            nameValuePairList.add(new BasicNameValuePair(key, value));

        });

        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
        CloseableHttpResponse response = httpclient.execute(httpPost);


        HttpEntity entity = response.getEntity();

        return  EntityUtils.toString(entity);
    }



    /**
     * 发送post请求， 返回body
     *
     * @param url  请求url
     * @return
     * @throws IOException
     */
    public  String post (String url) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        CloseableHttpResponse response = httpclient.execute(httpPost);

        HttpEntity entity = response.getEntity();

        return  EntityUtils.toString(entity);

    }


    public void get (String url){
        // TODO: 2017/3/25  发送无参数get请求
    }


    public void get (String url, Map<String, String> params) {
        // TODO: 2017/3/25  发送带参数get请求
    }
}
