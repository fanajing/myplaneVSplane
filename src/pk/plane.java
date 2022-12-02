package pk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class plane extends Thread{

	//属性：当前的图片
	private BufferedImage image;
	//坐标
	private int x;
	private int y;
	//图片的宽度高度
	private int width;
	private int height;
	//飞机速度储值
	private int i=6;

	private int step;
	//一个飞机的1张图片
	private BufferedImage images[] = new BufferedImage[1];
	//随机生成坐标
	private	Random r = new Random();

	private boolean isCatch =false;
	//爆炸的三个状态
	private BufferedImage shoot01;
	private BufferedImage shoot02;
	private BufferedImage shoot03;
	//初始化
	public plane(String f) throws IOException
	{
		image = ImageIO.read(new File("images/plane"+f+"_01.png"));

		x=853;
		y=480;
		width = image.getWidth();
		height = image.getHeight();

		//飞机的Y坐标随机产生
		y = r.nextInt(480-height);
		//飞行的速度
		step = r.nextInt(i)+1;
		for(int i=0;i<images.length;++i)
		{
			images[i] = ImageIO.read(new File("images/plane"+f+"_01.png"));

		}

		//初始化击落动作图片
		shoot01 = ImageIO.read(new File("images/plane"+f+"_00_01.png"));
		shoot02 = ImageIO.read(new File("images/plane"+f+"_00_02.png"));
		shoot03 = ImageIO.read(new File("images/plane"+f+"_00_03.png"));
	}

	//线程的飞行的方法
	@Override
	public void run() {
		//飞机循环
		while(true)
		{

			if(this.isCatch)
			{
				//必须对其进行捕获或声明以便抛出
				try {
					this.turnOver();
					this.goOut();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}else{
				x = x-step;
				//重载图片
				this.image = images[0];
				//敌机帧数
				try {
					Thread.sleep(30);

				} catch (Exception e) {

				}
				if(x <= -width)//如果飞出，重新进入
				{
					x =853;
					i++;
					//飞机的Y坐标随机产生
					y = r.nextInt(400-height);
					//飞行的速度
					sky.geti();
				}
			}
		}
	}

	//飞机击落的退出并重新进入
	public void goOut()
	{
		x =852;
		i++;
		//飞机位置随机产生
		y = r.nextInt(480-height);
		//飞行的速度
		step = r.nextInt(i)+1;

		isCatch =false;
	}
	//飞机坠毁动画
	public void turnOver() throws InterruptedException
	{
			this.image =this.shoot01;
			Thread.sleep(100);
			this.image =this.shoot02;
			Thread.sleep(100);
			this.image =this.shoot03;
			Thread.sleep(100);

	}






	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public boolean isCatch() {
		return isCatch;
	}

	public void setCatch(boolean isCatch) {
		this.isCatch = isCatch;
	}

	public BufferedImage getCatch01() {
		return shoot01;
	}

	public void setCatch01(BufferedImage shoot01) {
		this.shoot01 = shoot01;
	}

	public BufferedImage getCatch02() {
		return shoot02;
	}

	public void setCatch02(BufferedImage catch02) {
		this.shoot02 = shoot02;
	}



}
