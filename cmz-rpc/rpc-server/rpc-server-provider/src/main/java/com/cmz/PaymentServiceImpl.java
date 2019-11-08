package com.cmz;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午10:43:44
 * @description RpcRequest
 */

@RpcService(PaymentService.class)
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void doPay() {
		System.out.println("执行doPay方法");
	}
}
