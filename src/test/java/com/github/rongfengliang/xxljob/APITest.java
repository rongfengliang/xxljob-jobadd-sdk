package com.github.rongfengliang.xxljob;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APITest {

    private Map<String,String> jobConf;
    @Before
    public  void init(){
        jobConf = new HashMap<>();
        jobConf.put("jobGroup","1");
        jobConf.put("jobDesc","demo");
        jobConf.put("cronGen_display","");
        jobConf.put("glueType","BEAN");
        jobConf.put("executorHandler","demoJobHandler");
        jobConf.put("author","dalong");
        jobConf.put("executorRouteStrategy","FIRST");
        jobConf.put("triggerStatus","1");
        jobConf.put("misfireStrategy","DO_NOTHING");
        jobConf.put("executorBlockStrategy","SERIAL_EXECUTION");
        jobConf.put("scheduleType","FIX_RATE");
        jobConf.put("scheduleConf","11");
    }
    @Test
    public  void demo() throws IOException {
        XxlJobServerConf xxlJobServerConf = new XxlJobServerConf();
        xxlJobServerConf.setAddJobURL("http://localhost:8080/xxl-job-admin/jobinfo/add");
        xxlJobServerConf.setName("admin");
        xxlJobServerConf.setPassword("123456");
        xxlJobServerConf.setLoginURL("http://localhost:8080/xxl-job-admin/login");
        XxlJobAddApi xxlJobAddApi = new XxlJobAddApi(xxlJobServerConf);
        String  result =  xxlJobAddApi.AddJob(jobConf);
        System.out.println(result);

    }
}
