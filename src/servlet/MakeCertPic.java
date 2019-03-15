package servlet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 制作验证码工具
 * 4位,由字母或者数字组成
 * @author User
 *
 */
public class MakeCertPic {
	//1.定义验证码中可以出现的数据类型
	
	private  static char [] characters = {
		
		'a','b','c','d','e','f','g','h','i','j','k',
		'l','m','n','o','p','q','r','s','t','u',
		'v','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K',
		'L','M','N','O','P','Q','R','S','T','U','V',
		'W','X','Y','Z',
		'0','1','2','3','4','5','6','7','8','9'
		
	};
	
	
	/**
	 * 生成验证码的核心代码
	 * @param width 生成的验证码图片的宽度
	 * @param height 生成的验证码图片的高度
	 *
	 * @return
	 */
	public static String getCertPic(int width,int height){
		if(width < 0){
			width = 60;
		}
		if(height < 0 ){
			height = 20;
		}

		//在内存中随机生成一张图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		//图片中没有内容---》自己画
		
		//画笔
		Graphics g = image.getGraphics();
		//设置画笔的颜色
		//g.setColor(new Color(0xDCDCDC));
		
		//画一个边框
		g.drawRect(0, 0, width, height);
		//g.drawRect(0, 0, width - 1, height - 1);
		//......
		//随机生成四个字符
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 4; i++){
			sb.append(characters[(int)(Math.random()*characters.length)]);
			
		}
		
		//将四个字符画在image中
		String certPicStr = sb.toString();//DX80
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,15));
		//画第一个
		g.drawString(certPicStr.substring(0,1), 8, 15);
		//画第二个
		g.drawString(certPicStr.substring(1,2), 20, 13);
		//画第三个
		g.drawString(certPicStr.substring(2,3), 32, 17);
		//画第四个
		g.drawString(certPicStr.substring(3,4), 44, 12);
		
		
		//增加干扰点
		Random random = new Random();
		for(int i = 0; i < 30; i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			g.drawOval(x, y, 1, 1);
		}
		g.dispose();


		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("/Users/happy/Documents/javaWeb/JavaWeb/web/web/img/code.jpeg"));
			ImageIO.write(image, "JPEG", os);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
		
	}
	
	
	public static void main(String[] args)throws Exception {
		FileOutputStream file = new FileOutputStream(new File("/Users/happy/Documents/javaWeb/JavaWeb/web/web/img/code.jpeg"));
//		String a = MakeCertPic.getCertPic(60, 20, file);
//		System.out.println(a);
	}
}
