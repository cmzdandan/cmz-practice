package com.cmz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午10:43:44
 * @description RpcRequest
 */

@Configuration
@ComponentScan(basePackages = "com.gupaoedu.vip")
public class SpringConfig {

    @Bean(name="gpRpcServer")
    public CmzRpcServer gpRpcServer(){
        return new CmzRpcServer(8080);
    }
}
