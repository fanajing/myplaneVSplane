package pk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class sky extends JPanel
{

	//显示背景图片
	private BufferedImage bg;

	//空中敌机数量
	private plane plane[] = new plane[9];

	//定义我的飞机
	private myplane myplane;
	//计数器归零
	private int count=0;

	public sky() throws Exception {
		//初始化背景图片
		bg = ImageIO.read(new File("images/bg.jpg"));
		//初始化敌机
		for(int i=0;i<plane.length;++i)
		{
			if(i<=5){
				plane[i] = new plane("01");
			}else{
				plane[i] = new plane("02");
			}
		}
		//飞机动起来;启动线程
		for(int i=0;i<plane.length;++i)
		{
			plane[i].start();
		}

		//创建我的飞机
		myplane = new myplane();
	}


	//用画笔将素材画到面板上
	@Override
	public void paint(Graphics m) {
		super.paint(m);
		//1.画背景
		m.drawImage(bg, 0, 0, 852, 480, null);//图片，左上角坐标，高宽，颜色
		//2.画飞机
		for(int i=0;i<plane.length;++i)
		{
			m.drawImage(plane[i].getImage(), plane[i].getX(), plane[i].getY(),
					plane[i].getWidth(), plane[i].getHeight(), null);
		}
		//3.画我的飞机
		if(myplane.isShow())
		{
			//鼠标和飞机重合
			int x = myplane.getX() - myplane.getWidth()/2;
			int y = myplane.getY() - myplane.getHeight()/2;
			m.drawImage(myplane.getImage(), x, y, myplane.getWidth(), myplane.getHeight(), null);
		}


		//记录击落敌机个数
		m.setColor(Color.BLACK);
		m.setFont(new Font("楷体",1,30));
		m.drawString("击坠数："+count+"\n"+"你还有"+i+"条命",10,30);


	}


	//攻击判断方法
	public void catchplane()
	{
		//planes
		for(int i=0;i<plane.length;++i)
		{
			if(myplane.isCatch(plane[i]))
			{
				//飞机击落重新进入
				plane[i].setCatch(true);
				//统计击落飞机的个数
				++count;
			}

		}
	}
	public static int i=3;
	public static int g=0;
	public static int geti(){
if(i>0){
	i--;
}
		if(i==0){
			if(g==0) {
				g=1;
				JOptionPane.showMessageDialog(null, "GAME OVER!", "提示", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		}
		return 0;
	}
	public void action()
	{
		//鼠标监听事件
		MouseAdapter mouse = new MouseAdapter() {

			//重写父类方法 ：鼠标进入
			@Override
			public void mouseEntered(MouseEvent e) {
				myplane.setShow(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				myplane.setShow(false);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				myplane.moveTo(e.getX(), e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				catchplane();
			}

		};

		//给天空添加鼠标事件
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		while(true)
		{
			repaint();
		}
	}

}
