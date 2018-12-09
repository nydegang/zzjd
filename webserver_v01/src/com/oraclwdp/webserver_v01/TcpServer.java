package com.oraclwdp.webserver_v01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	 /**
	    * 我们首先是服务器发送一个信息给顾客
	    */
	public static void main(String[] args){
		ServerSocket  serverSocket=null;
		try {
			serverSocket=new ServerSocket(80);
			//1 迎宾
			while (true) {
				
				//2 等顾客来,如果有顾客来了交给包厢服务器服务员交流
				Socket baoxiao=serverSocket.accept();
				///由于迎宾直到是否有顾客来，因而由它启动
				new ServerThread(baoxiao).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (serverSocket!=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
