package com.huanleichen.hello.client.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        post();
    }

    public static void post() {
        //创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost("http://localhost:8080/myshop/user/page");

        post.setHeader("Cookie", "JSESSIONID=3D19CBAC44C6FB2ECF42E9FA395C28D4; Idea-555a4e13=19a72a4d-e7b8-4c8c-9c5a-df988f63db7b; userInfo=admin@huanleichen.com:123456");
        post.setHeader("Connection", "keep-alive");
        post.setHeader("User-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");


        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();

        params.add(new BasicNameValuePair("draw", "1"));
        params.add(new BasicNameValuePair("start", "0"));
        params.add(new BasicNameValuePair("length", "10"));

        CloseableHttpResponse response = null;

        try {
            post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void get() {
        //创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //设置 url
        HttpGet get = new HttpGet("http://localhost:8080/myshop/user/page?draw=1&start=0&length=10");
        get.setHeader("Cookie", "JSESSIONID=3D19CBAC44C6FB2ECF42E9FA395C28D4; Idea-555a4e13=19a72a4d-e7b8-4c8c-9c5a-df988f63db7b; userInfo=admin@huanleichen.com:123456");
        get.setHeader("Connection", "keep-alive");
        get.setHeader("User-agent", "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(get);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
