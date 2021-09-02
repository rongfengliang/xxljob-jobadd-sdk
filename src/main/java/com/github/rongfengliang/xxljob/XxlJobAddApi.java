package com.github.rongfengliang.xxljob;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

/**
 * XxlJobAddjob Api
 * @author  rongfengliang
 */
public class XxlJobAddApi {
    private   OkHttpClient okHttpClientCookie = new OkHttpClient();
    private  OkHttpClient okHttpClient;
    private  XxlJobServerConf xxlJobServerConf;
    XxlJobAddApi(XxlJobServerConf xxlJobServerConf){
        this.xxlJobServerConf=xxlJobServerConf;
        this.okHttpClient = okHttpClientCookie.newBuilder().addInterceptor(new AuthIntercerptor(okHttpClientCookie,xxlJobServerConf))
                .build();
    }

    /**
     * add xxljob
     * @param jobConf jobconf
     * @return String contents xxljob server return message
     * @throws IOException
     */
    public   String AddJob(Map<String,String> jobConf) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        jobConf.entrySet().forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                builder.add(stringStringEntry.getKey(),stringStringEntry.getValue());
            }
        });
        Request request= new  Request.Builder().post(builder.build()).url(this.xxlJobServerConf.getAddJobURL()).build();
        Response response=    okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
