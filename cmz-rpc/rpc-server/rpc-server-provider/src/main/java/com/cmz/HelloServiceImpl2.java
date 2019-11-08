package com.cmz;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午10:43:44
 * @description RpcRequest
 */
@RpcService(value = HelloService.class, version = "v2.0")
public class HelloServiceImpl2 implements HelloService {

	@Override
	public String sayHello(String content) {
		System.out.println("【v2.0】request in sayHello:" + content);
		return "【v2.0】Say Hello:" + content;
	}

	@Override
	public String saveUser(User user) {
		System.out.println("【V1.0】request in saveUser:" + user);
		return "【v2.0】SUCCESS";
	}
}
