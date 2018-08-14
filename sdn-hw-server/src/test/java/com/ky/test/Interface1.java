package com.ky.test;
/*
 *作者：barret
 *日期：2018年2月5日
 *
*/

public interface Interface1 {

	public void saysomething();
	default public void sayhello(){
		System.out.println("test");
	};
}
