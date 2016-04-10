package com.room618.Thedounblechromosphere;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	static int[] array = new int[7];
	static String path;
	Color lightBlue = new Color(135, 206, 255);
	Color pink = new Color(255, 106, 106);
	JFrame window = new JFrame("双色球");
	Container c = window.getContentPane();
	RoundJTextField[] number = new RoundJTextField[7];
	JPanel InputNumber = new JPanel();
	JPanel Output = new JPanel();
	GridBagLayout gbl = new GridBagLayout();
	JButton yes;
	JTextArea jta;
	JScrollPane jsp;

	UI() {
		path = JOptionPane.showInputDialog("请输入数据文件夹路径","./data");

		window.setSize(400, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(2, 1));

		centerWindow();
		
		InputPart();
		ShowPart();
		
		window.setVisible(true);
	}

	private void centerWindow(){
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		window.setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	
	void InputPart() {
		InputNumber.setLayout(new GridLayout(2, 4));
		for (int i = 0; i < 7; i++) {
			if (i == 6) {
				number[i] = new RoundJTextField(4, lightBlue);
			} else {
				number[i] = new RoundJTextField(4, pink);
			}
			InputNumber.add(number[i]);
		}
		yes = new JButton("确定");
		yes.setPreferredSize(new Dimension(40, 30));
		yes.addActionListener(this);
		InputNumber.add(yes);
		c.add(InputNumber);
	}

	void ShowPart() {
		jta = new JTextArea();
		jta.setSize(400, 200);
		jsp = new JScrollPane(jta);
		c.add(jsp);
	}

	int[] getNumber() {
		return array;
	}

	void setNumber(int[] arr) {
		array = arr;
	}

	void setTextArea(String output) {
		jta.setText(output);
	}
	
	public void actionPerformed(ActionEvent e) {
		int wrong = 0;
		try {
			boolean judge = true;
			int[] Number = new int[7];
			for (int i = 0; i < 7; i++) {
				Number[i] = Integer.parseInt(number[i].getText().trim());
				System.out.println(Number[i]);
			}

			for (int i = 0; i < 7; i++) {
				wrong = i;
				if (Number[i] > 33 || Number[i] < 1) {
					number[i].setText(null);
					JOptionPane.showMessageDialog(null, "输入错误", "错误",
							JOptionPane.INFORMATION_MESSAGE);
					judge = false;
					break;
				}
				if (i != 6) {
					for (int j = i + 1; j < 6; j++) {
						if (Number[i] == Number[j]) {
							number[i].setText(null);
							number[j].setText(null);
							JOptionPane.showMessageDialog(null, "输入相同数据", "错误",
									JOptionPane.INFORMATION_MESSAGE);
							judge = false;
							break;
						}
					}
				}

			}
			if (judge) {
				setNumber(Number);
				Sort.sort();
			}
		} catch (Exception ex) {
			number[wrong].setText(null);
			JOptionPane.showMessageDialog(null, "输入错误", "错误",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

class RoundJTextField extends JTextField {
	private Shape shape;

	public RoundJTextField(int size, Color c) {
		super(size);
		setOpaque(false);
		setBackground(c);
		setCaretColor(Color.white);
		setForeground(Color.white);
		setFont(new Font("宋体", Font.BOLD, 30));
	}
	
	public String getText(){
		return super.getText();
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1,
					getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}
