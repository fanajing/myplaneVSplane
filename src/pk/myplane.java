package pk;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Robot;
import java.lang.InterruptedException;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;

public class myplane {
	// 当前的图片
	private BufferedImage image;
	// 坐标
	private int x;
	private int y;
	// 图片的宽度高度
	private int width;
	private int height;
	//发射激光
	private BufferedImage images[] = new BufferedImage[1];
	private boolean isCatch =false;
	private BufferedImage shoot01;
	private BufferedImage shoot02;
	// 是否显示
	private boolean isShow;
	//初始化
	public myplane() throws IOException {
		image = ImageIO.read(new File("images/my.png"));
		x = 100;
		y = 100;
		width = image.getWidth();
		height = image.getHeight();
		isShow =false;
		shoot01 = ImageIO.read(new File("images/bullet.png"));
		shoot02 = ImageIO.read(new File("images/my.png"));
	}

	//移动飞机
	public void moveTo(int x,int y)
	{
		this.x = x;
		this.y = y;
		this.image =this.shoot02;
	}
	//打飞机
	public boolean isCatch(plane plane)
	{
			this.image =this.shoot01;
		int dy = this.y - plane.getY();
		return dy>=0 && dy <= plane.getHeight();

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

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

}
