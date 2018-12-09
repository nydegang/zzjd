package com.oraclwdp.webserver_v01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 
 * @author HPYH
 *
 */
public class ServerThread extends Thread {
	private Socket baoxiao;

	public ServerThread(Socket baoxiao) {
		this.baoxiao = baoxiao;
	}

	@Override
	public void run() {
		PrintWriter out = null;
		BufferedReader br =null;
		try {
			// 3获取一行行输出的流
			out = new PrintWriter(baoxiao.getOutputStream());
			//3.1 响应行
			out.println("HTTP/1.1 200 OK");
			//3.2 若干响应头
			out.println("Content-Type: text/html; charset=utf-8");
			//3.3 空白行
			out.println();
			//3.4 正文
			out.print("<b>欢迎您世界!</b>");
			//out.flush();// 强制发出

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out!=null) {
				
				out.close();
			}
			if (br!=null) {
				
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
