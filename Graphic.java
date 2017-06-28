package Project2_TAG;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Graphic extends JFrame {
	Container contentPane = getContentPane();
	JPanel JPane = new JPanel();
	JLabel redbox = new JLabel("бс");
	JLabel bluebox = new JLabel("бс");
	int rx = 100;
	int ry = 100;
	int bx = 825;
	int by = 825;
	String timer;
	JLabel lb_time = new JLabel("");
	KeyListen keyL = new KeyListen();
	boolean onoff = true;
	Graphic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TAG!");
		setSize(1200, 1060);
		setResizable(false);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		contentPane.addKeyListener(keyL);
		
		lb_time.setFont(new Font(null,0,70));
		lb_time.setSize(200,100);
		lb_time.setLocation(600,-10);
		lb_time.setForeground(Color.WHITE);
		contentPane.add(lb_time);
		
		JPane.setLocation(120,70);
		JPane.setSize(950,950);
		JPane.setPreferredSize(new Dimension(950, 950)); // 0,25,50,75,100....950
		JPane.setBackground(Color.WHITE);
		JPane.setLayout(null);
		contentPane.add(JPane);

		redbox.setFont(new Font(null, 1, 27));
		redbox.setLocation(rx, ry);
		redbox.setForeground(Color.red);
		redbox.setSize(25, 25);
		JPane.add(redbox);

		bluebox.setFont(new Font(null, 1, 27));
		bluebox.setLocation(bx, by);
		bluebox.setForeground(Color.blue);
		bluebox.setSize(25, 25);
		JPane.add(bluebox);
		
		setVisible(true);
		contentPane.requestFocus();
		
		int time = 3;
		while(onoff){
			if(time == 0){
				if(contentPane.getBackground() == Color.blue)
					contentPane.setBackground(Color.red);
				else
					contentPane.setBackground(Color.blue);
				time = 9;
			}
			timer = Integer.toString(time);
			lb_time.setText(timer);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time--;
			
		}
	}

	class KeyListen implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyChar() == '\n'){
				
			}
			if (e.getKeyCode() == 37 && bx > 0) {
				bx -= 25;
				bluebox.setLocation(bx,by);
			}
			if(e.getKeyCode() == 38 && by > 0) {
				by -= 25;
				bluebox.setLocation(bx,by);
			}
			if(e.getKeyCode() == 39 && bx < 925) {
				bx += 25;
				bluebox.setLocation(bx,by);
			}
			if(e.getKeyCode() == 40 && by < 925) {
				by += 25;
				bluebox.setLocation(bx,by);
			}
			
			if (e.getKeyChar() == 'a' && rx > 0) {
				rx -= 25;
				redbox.setLocation(rx,ry);
			}
			if(e.getKeyChar() == 'w' && ry > 0) {
				ry -= 25;
				redbox.setLocation(rx,ry);
			}
			if(e.getKeyChar() == 'd' && rx < 925) {
				rx += 25;
				redbox.setLocation(rx,ry);
			}
			if(e.getKeyChar() == 's' && ry < 925) {
				ry += 25;
				redbox.setLocation(rx,ry);
			}
			if(rx==bx && ry == by){
				onoff = false;
				contentPane.removeAll();
				setVisible(false);
				JLabel win = new JLabel("");
				win.setSize(1000,200);
				win.setLocation(100,100);
				win.setFont(new Font(null,0,200));
				contentPane.add(win);
				if(contentPane.getBackground() == Color.red){			
					contentPane.setBackground(Color.red);
					win.setText("RED WIN");
				}
				else{
					contentPane.setBackground(Color.blue);
					win.setText("BLUE WIN");
				}
				contentPane.add(win);
				repaint();
				setVisible(true);
			}
				
				
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
