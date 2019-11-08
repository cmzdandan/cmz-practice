package com.cmz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午11:00:06
 * @description main
 */
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
		PaymentService paymentService = rpcProxyClient.clientProxy(PaymentService.class, "localhost", 8080);
		paymentService.doPay();
	}

}
