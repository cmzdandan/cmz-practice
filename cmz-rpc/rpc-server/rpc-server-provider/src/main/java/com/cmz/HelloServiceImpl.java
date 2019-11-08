package com.cmz;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午10:43:44
 * @description RpcRequest
 */
@RpcService(value = HelloService.class, version = "v1.0")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String content) {
		System.out.println("【V1.0】request in sayHello:" + content);
		return "【V1.0】Say Hello:" + content;
	}

	@Override
	public String saveUser(User user) {
		System.out.println("【V1.0】request in saveUser:" + user);
		return "【V1.0】SUCCESS";
	}
}
