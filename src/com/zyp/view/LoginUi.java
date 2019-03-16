package com.zyp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.zyp.entity.User;
import com.zyp.service.UserService;
import com.zyp.service.impl.UserServiceImpl;







public class LoginUi implements ActionListener{
	private JFrame jf = new JFrame(" 电影购票系统");
	private Container con = jf.getContentPane();// 获得面板
	
	private ImageIcon bg = new ImageIcon("images/bg.jpg");
	private ImageIcon btnbg = new ImageIcon("images/btn.png");
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension sc = toolkit.getScreenSize();// 获得屏幕尺寸
	
	private JButton in = new JButton("",btnbg);
	//"进入系统"用背景图
	
	private JLabel bglabel = new JLabel();
	
	public LoginUi() {
		con.setLayout(null);
		jf.setSize(1000, 600);
		jf.setLocation((sc.width - 1000) / 2, (sc.height - 618) / 2);		
		jf.setResizable(false);// 窗口大小不可变
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setVisible(true);		
		bglabel.setIcon(bg);
		bglabel.setBounds(0, 0, 1000, 600);		
		in.setBounds(425, 250, 150, 56);
		
		con.add(bglabel);
		con.add(in);
		
	/*	if (!Util.getConnet()) {
			winMessage("服务端未开启，无法继续！");
			return;
		}*/
		in.addActionListener(this);
		
	}

	public static void winMessage(String str) {// 提示窗口，有多个地方调用
		JOptionPane.showMessageDialog(null, str, "提示",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.in) {
			new Login();
			jf.dispose();
		}
	}
}

class Login implements ActionListener {
	private JFrame jf = new JFrame("电影购票系统");
	private Container con = jf.getContentPane();// 获得面板

	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension sc = toolkit.getScreenSize();// 获得屏幕尺寸
	private JLabel title = new JLabel("电影购票系统");
	private JLabel name1 = new JLabel("用户名");
	private JLabel pass1 = new JLabel("密  码");
	private JTextField textName = new JTextField();
	private JPasswordField textPs = new JPasswordField();// 密码框

	private JRadioButton choice1 = new JRadioButton("用户");
	private JRadioButton choice2 = new JRadioButton("管理员");

	private JLabel code1 = new JLabel("验证码");
	private JTextField textCode = new JTextField();
	private JLabel code2 = new JLabel();

	private JButton button1 = new JButton("注册");
	private JButton button2 = new JButton("登录");
	// 按钮

	private Font font = new Font("楷体", 1, 28);
	private Font font1 = new Font("楷体", 0, 20);
	private Font font2 = new Font("楷体", 0, 18);
	// 字体，样式（粗体，斜体），大小

	private ButtonGroup buttongroup = new ButtonGroup();

	private ImageIcon loginbg = new ImageIcon("images/loginbg.jpg");
	
	public Login() {
		con.setLayout(null);
		jf.setSize(1000, 618);
		jf.setLocation((sc.width - 1000) / 2, (sc.height - 618) / 2);

		jf.setResizable(false);// 窗口大小不可变
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setVisible(true);

		JLabel maxlabel = new JLabel(loginbg);
		
		title.setBounds(355, 10, 370, 30);
		title.setFont(font);
		title.setForeground(Color.black);

		name1.setBounds(140, 140, 85, 30);// 账号的位置大小
		name1.setFont(font1);// 字体
		name1.setForeground(Color.black);// name1字的颜色

		pass1.setBounds(140, 190, 85, 30);// 密码的位置大小
		pass1.setForeground(Color.black);
		pass1.setFont(font1);

		textName.setBounds(200, 143, 140, 25);
		textName.setBorder(null);// 边框
		textName.setFont(font1);

		textPs.setBounds(200, 193, 140, 25);
		textPs.setBorder(null);
		textPs.setEchoChar('*');// 可以将密码显示为* ；默认为·
		textPs.setFont(font1);

		choice1.setBounds(140, 290, 120, 25);
		choice1.setSelected(true);// 默认普通用户登录
		choice2.setBounds(260, 290, 80, 25);

		code1.setBounds(140, 240, 60, 25);
		code1.setFont(font1);
		code1.setForeground(Color.black);
		textCode.setBounds(200, 240, 95, 25);
		textCode.setBorder(null);
		textCode.setFont(font1);
		code2.setBounds(300, 240, 70, 25);
		code2.setFont(font1);
		code2.setText(code());
		code2.setForeground(Color.black);

		button1.setBounds(140, 340, 90, 25);
		button1.setFont(font2);
		button1.addActionListener(this);

		button2.setBounds(250, 340, 90, 25);
		button2.setFont(font2);
		button2.addActionListener(this);

		JLabel bg = new JLabel(loginbg);
		
		maxlabel.add(title);
		maxlabel.add(name1);
		maxlabel.add(pass1);
		maxlabel.add(textName);
		maxlabel.add(textPs);
		maxlabel.add(choice1);
		maxlabel.add(choice2);

		buttongroup.add(choice1);
		buttongroup.add(choice2);

		maxlabel.add(code1);
		maxlabel.add(code2);
		maxlabel.add(textCode);
		maxlabel.add(button1);
		maxlabel.add(button2);
		
		maxlabel.setBounds(0, 0, 999, 617);
		con.add(maxlabel);

	}

	private String code() {
		int m = 0;
		for (int i = 0; i < 4; i++) {
			m *= 10;
			m += (int) (Math.random() * 9 + 1);
		}
		return ((Integer) m).toString();
	}

	public void cleanUserInfo() {
		this.textName.setText("");
		this.textPs.setText("");
		this.textCode.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ac) {
		// TODO Auto-generated method stub
		if (ac.getSource() == this.button2) {
			String id = textName.getText();
			String pswd = new String(textPs.getPassword());
			if (id.equals("") || pswd.equals("")) {
				LoginUi.winMessage("账号、密码不能为空！");
				cleanUserInfo();
				this.code2.setText(code());
			} else {
				String code1 = textCode.getText();
				String code = code2.getText();
				if (code1.equals(code)) {
					int choice=0;
					if (choice1.isSelected())
						choice = 0;
					else 
						choice = 1;
					UserService userService = new UserServiceImpl();
					User user = userService.login(new User(id, pswd, choice));
					if (user == null) {
						LoginUi.winMessage("用户名或密码不正确！登录失败！");
						cleanUserInfo();
						this.code2.setText(code());
					} else {
						
						user=userService.queryUser(user);
					    				   
							if (user.getuType()==0) {
								new UserUi(user,1);
							} else if (user.getuType()==1) {
								new AdminUi();
							}
							this.jf.dispose();
						
						LoginUi.winMessage("登录成功！");
					}
				} else {
					LoginUi.winMessage("验证码不正确！");
					cleanUserInfo();// 可以考虑不清空信息
					this.code2.setText(code());
				}
			}
		} else if (ac.getSource() == this.button1) {
			new RegisterUi();
			this.jf.dispose();// 点击按钮时,new一个frame，原先frame销毁
		}	
	}
}
