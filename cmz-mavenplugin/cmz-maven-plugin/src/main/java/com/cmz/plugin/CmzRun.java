package com.cmz.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
* @author	chen.mz
* @email	chen.mz@belle.com.cn
* @nickname	陈梦洲
* @version  2018年11月3日 下午2:36:20
* @description 为 cmz:run命令创建一个执行类
*/
/**
 * @goal run
 */
public class CmzRun extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println("This is the result of the command  cmz:run");
		System.out.println("You can do other logic here.");
	}

}
