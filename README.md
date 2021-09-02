# xxljob  jobadd sdk 

> use admin api for job add (http client with okhttp3)



## Usage


* maven

```code
 <dependency>
    <groupId>com.github.rongfengliang</groupId>
    <artifactId>xxljobapi</artifactId>
    <version>1.0-SNAPSHOT</version>
 </dependency>
```

* code

> use xxljob default arguments

```code
    Map<String,String> jobConf jobConf = new HashMap<>();
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
    XxlJobServerConf xxlJobServerConf = new XxlJobServerConf();
    xxlJobServerConf.setAddJobURL("http://localhost:8080/xxl-job-admin/jobinfo/add");
    xxlJobServerConf.setName("admin");
    xxlJobServerConf.setPassword("123456");
    xxlJobServerConf.setLoginURL("http://localhost:8080/xxl-job-admin/login");
    XxlJobAddApi xxlJobAddApi = new XxlJobAddApi(xxlJobServerConf);
    String  result =  xxlJobAddApi.AddJob(jobConf);
    System.out.println(result);
```