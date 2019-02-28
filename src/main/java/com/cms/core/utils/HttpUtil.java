package com.cms.core.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.helper.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpUtil {

    private static RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();

    public static String sendGet(String url, String queryString) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * HTTP Post 获取内容
     *
     * @param params     请求的参数，key-value形式
     * @param reqMsg     请求的参数，字符串
     * @param url        请求的url地址 ?之前的地址
     * @param reqCharset 编码格式
     * @param resCharset 编码格式
     * @return 页面内容
     */

    public static String doPost(Map<String, String> params, String url, String reqMsg, String reqCharset, String resCharset) throws Exception {
        //获取绕过安全检查的httpClient，以便发送https请求
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        CloseableHttpResponse response = null;
        if (StringUtil.isBlank(url)) {//自己的方法，报错自己改改就好
            return null;
        }
        try {
            //创建httppost方法
            HttpPost httpPost = new HttpPost(url);
            //添加head，需要什么填什么
            httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
            httpPost.addHeader("Content-type", "text/html,application/xhtml+xml,application/xml");

            //组装请求参数，key-value形式的
            List<NameValuePair> pairs = null;
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
            }
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, reqCharset));
            }
            //这个是直接post一串字符串的方式，如json串，并不用带key
			/*StringEntity reqEntity = new StringEntity(reqMsg, "GBK");//解决中文乱码问题
			reqEntity.setContentEncoding("GBK");
			reqEntity.setContentType("application/json");
			httpPost.setEntity(reqEntity);*/

            HttpEntity entity = null;
            String result = null;
            //执行post方法
            response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {//出现链接异常，抛出
                httpPost.abort();
                throw new Exception("HttpClient,error status code :" + statusCode);
            }
            //获得返回结果
            entity = response.getEntity();
            if (entity != null) {
                //返回结果转为字符串
                result = EntityUtils.toString(entity, resCharset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
