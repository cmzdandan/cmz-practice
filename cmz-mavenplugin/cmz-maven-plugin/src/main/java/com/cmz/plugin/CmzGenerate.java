package com.cmz.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @author chen.mz
 * @email chen.mz@belle.com.cn
 * @nickname 陈梦洲
 * @version 2018年11月3日 下午2:42:52
 * @description 为 cmz:generate命令创建一个执行类
 */
@Mojo(name = "generate")
public class CmzGenerate extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println("This is the result of the command  cmz:generate");
		System.out.println("You can do other logic here.");
	}

}
