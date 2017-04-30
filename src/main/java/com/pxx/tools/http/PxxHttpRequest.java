package com.pxx.tools.http;



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
 * http  POST GET
 */
public class PxxHttpRequest {
    private static Logger logger = Logger.getLogger(PxxHttpRequest.class);



    private  CloseableHttpClient httpclient =  HttpClients.createDefault();




    /**
     * 发送post请求， 返回body
     *
     * @param url  请求url
     * @param params  请求参数
     * @return  String  返回结果文本
     * @throws IOException
     */
    public  String post (String url, Map<String, String> params) throws IOException {



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
     * @return String  返回结果文本
     * @throws IOException
     */
    public  String post (String url) throws IOException {


        HttpPost httpPost = new HttpPost(url);

        CloseableHttpResponse response = httpclient.execute(httpPost);

        HttpEntity entity = response.getEntity();

        return  EntityUtils.toString(entity);

    }

    /**
     * 发送post请求， 返回 body
     *
     * @param url
     * @return String  返回结果文本
     * @throws IOException
     */
    public String get (String url) throws IOException {

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = httpclient.execute(httpGet);

        HttpEntity entity = response.getEntity();

        return  EntityUtils.toString(entity);
    }


    /**
     * 发送post请求， 返回 body
     *
     * @param url 请求url
     * @param params  请求参数
     * @return String  返回结果文本
     * @throws IOException
     */
    public String get (String url, Map<String, String> params) throws IOException {


        StringBuilder paramsString = new StringBuilder();


        params.forEach( (key, value) -> {
            paramsString.append(key + "=" + value + "&");

        });

        logger.info(url + "?" +paramsString.toString());

        HttpGet httpGet = new HttpGet(url + "?" +paramsString.toString());

        CloseableHttpResponse response = httpclient.execute(httpGet);

        HttpEntity entity = response.getEntity();

        return  EntityUtils.toString(entity);

    }
}
