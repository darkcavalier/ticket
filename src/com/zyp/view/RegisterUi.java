package com.zyp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zyp.entity.User;
import com.zyp.service.UserService;
import com.zyp.service.impl.UserServiceImpl;




public class RegisterUi extends JFrame implements ActionListener{
	UserService userService=new UserServiceImpl();
	private JFrame jf = new JFrame("电影购票系统");
	private Container con = jf.getContentPane();// 获得面板

	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension sc = toolkit.getScreenSize();// 获得屏幕尺寸
	private JLabel name = new JLabel("用 户 名");
	private JLabel pass = new JLabel("密    码");
	private JLabel pass2 = new JLabel("确认密码");
	private JTextField textName = new JTextField();
	private JLabel title = new JLabel("用户注册");
	private JPasswordField textPs = new JPasswordField();
	private JPasswordField textPs2 = new JPasswordField();
	// 密码框

	private JButton button1 = new JButton("确定");
	private JButton button2 = new JButton("返回");
	// 按钮
	private Font font = new Font("楷体", 1, 28);
	private Font font1 = new Font("楷体", 0, 20);
	private Font font2 = new Font("宋体", 0, 18);// 字体，样式（粗体，斜体），大小

	private ImageIcon loginbg = new ImageIcon("images/loginbg.jpg");
	
	public RegisterUi() {

		con.setLayout(null);
		jf.setSize(1000, 618);
        jf.setLocation((sc.width - 1000) / 2, (sc.height - 618) / 2);
		jf.setResizable(false);// 窗口大小不可变
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setVisible(true);

		JLabel maxlabel = new JLabel(loginbg);
		
		title.setBounds(215, 95, 170, 30);
		title.setFont(font);
		title.setForeground(Color.black);

		name.setBounds(160, 163, 95, 30);
		name.setFont(font1);
		name.setForeground(Color.red);

		pass.setBounds(160, 220, 95, 30);// 密码的位置大小
		pass.setForeground(Color.red);
		pass.setFont(font1);

		pass2.setBounds(160, 280, 95, 30);
		pass2.setForeground(Color.red);
		pass2.setFont(font1);

		textName.setBounds(245, 163, 140, 25);
		textName.setFont(font1);
		textName.setBorder(null);// 边框

		textPs.setBounds(245, 223, 140, 25);
		textPs.setFont(font1);
		textPs.setBorder(null);
		textPs.setEchoChar('*');// 可以将密码显示为* ；默认为· 但默认又对其设置了字体时会乱码

		textPs2.setBounds(245, 283, 140, 25);
		textPs2.setFont(font1);
		textPs2.setBorder(null);
		textPs2.setEchoChar('*');

		button1.setBounds(295, 340, 90, 25);
		button1.setFont(font2);
		button1.addActionListener(this);

		button2.setBounds(160, 340, 90, 25);
		button2.setFont(font2);
		button2.addActionListener(this);
		ImageIcon bgim = new ImageIcon("images/101.jpg");// 背景图案
		JLabel bg = new JLabel(bgim);
		Container laycon = jf.getLayeredPane();
		bg.setSize(jf.getSize().width, jf.getSize().height);
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));
		laycon.add(bg, new Integer(Integer.MIN_VALUE));

		maxlabel.add(title);
		maxlabel.add(name);
		maxlabel.add(pass);
		maxlabel.add(pass2);
		maxlabel.add(textName);
		maxlabel.add(textPs);
		maxlabel.add(textPs2);
		maxlabel.add(button1);
		maxlabel.add(button2);
		maxlabel.setBounds(0, 0, 999, 617);
		con.add(maxlabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.button1) {
			String pswd = new String(textPs.getPassword());
			String pswd2 = new String(textPs2.getPassword());
			String name = textName.getText();
			if ("".equals(name) || "".equals(pswd) || "".equals(pswd2)) {
				LoginUi.winMessage("账号、密码不能为空！");
				cleanUserInfo();
			} else {
				if (pswd.equals(pswd2)) {
					int rs = userService.register(new User(name, pswd,0));
					if (rs == 3) {
						LoginUi.winMessage("注册失败，该用户名已存在！");
						cleanUserInfo();
					} else if(rs == 1) {
						new LoginUi();
						this.jf.dispose();
						LoginUi.winMessage("注册成功！");
					} else  {
						LoginUi.winMessage("注册失败，原因。。。");
						cleanUserInfo();
					}
				} else{
					LoginUi.winMessage("两次输入的密码不一致！");
					cleanUserInfo();
				}
			}
		} else if (e.getSource() == this.button2) {
			new Login();
			this.jf.dispose();
		}
	}
	
	public void cleanUserInfo() {
		this.textName.setText("");
		this.textPs.setText("");
		this.textPs2.setText("");
	}

}
