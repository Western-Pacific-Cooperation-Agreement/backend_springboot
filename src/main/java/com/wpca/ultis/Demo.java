package com.wpca.ultis;

import java.util.ArrayList;

//栅栏密码
public class Demo {

	public static void main(String[] args) {

		String str = "5ZGoYWFh5pyr5paH5YyW6ZuG5biC";

		//通过字符长度的因数判断可设置的分栏数n
		ArrayList<Integer> n = new ArrayList<>();
		for(int x=2;x<str.length();x++) {
			if(str.length()%x == 0) {
				n.add(x);
			}
		}

		//输出所有分栏可能
		for(int i:n) {
			System.out.println("可分为"+i+"栏：");
			//设置二维字符数组分别存储各分栏字符
			char[][] num = new char[i][str.length()/i];
			//遍历打印i栏
			for(int j=0;j<i;j++) {
				//cut为各分栏字符串
				String cut = str.substring(j*str.length()/i, j*str.length()/i+str.length()/i);
				//num数组每行存储各分栏字符串cut
				num[j] = cut.toCharArray();

				System.out.println(cut);
			};

			//解密过程实现
			//设置end集合存储存储Character对象取得解密结果
			ArrayList<Character> end = new ArrayList<>();
			//通过二维数组存储每个字符，使各字符可定位
			for(int k = 0; k < num.length; k++) {

	            for(int j = 0; j <num[k].length; j++) {

	                for(int m = 0; m < num.length; m++) {
	                	 end.add(num[m][j]);
	                }
	            }
			}
			//输出结果
			System.out.println("--------------------");
			System.out.println(i+"分栏连接在一起得到密文为：");
			//遍历截取解密结果并输出
			for(int y=0;y<end.size()/i;y++) {
				//字符不换行衔接打印
				System.out.print(end.get(y));
			}
			System.out.println();
			System.out.println("--------------------");
		}

	}
}
