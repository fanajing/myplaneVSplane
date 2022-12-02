package pk;
import java.awt.*;
import javax.swing.*;
public class Main
{

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();

		sky sky = new sky();

		frame.add(sky);
		frame.setSize(852,500);

		frame.setLocationRelativeTo(null);
		frame.setTitle("飞机大战");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		sky.action();
		
	}
}
