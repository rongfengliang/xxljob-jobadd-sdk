package com.github.rongfengliang.xxljob;

import lombok.Data;

/**
 * xxljob api address
 * @author  rongfengliang
 */
@Data
public class XxlJobServerConf {
    private String loginURL;
    private String addJobURL;
    private String name;
    private String password;
}
