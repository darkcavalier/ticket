package com.zyp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.zyp.entity.Comment;
import com.zyp.entity.Movie;
import com.zyp.entity.User;
import com.zyp.service.CommentService;
import com.zyp.service.UserService;
import com.zyp.service.impl.CommentServiceImpl;
import com.zyp.service.impl.UserServiceImpl;

public class MovieUi {
	private Movie movie;
	private User u;
	private JFrame jf = new JFrame("电影购票系统");
	private Container con = jf.getContentPane();
	private ImageIcon moviebg;
	private Font font0 = new Font("楷体", 0, 40);
	private Font font1 = new Font("楷体", 0, 28);
	private Font font2 = new Font("楷体", 0, 25);
	/* private JLabel maxLable=new JLabel(); */
	private JLabel jPic = new JLabel();// 图片
	private JLabel jmName = new JLabel();// 电影名字
	private JLabel jmLoca = new JLabel();// 地区
	private JLabel jmLanguage = new JLabel();// 语言
	private JLabel jmDuration = new JLabel();// 时长
	private JLabel jmType = new JLabel();// 类型
	private JLabel jmGrade = new JLabel();// 评分
	private JLabel jcomment=new JLabel();//评论列表
	private JTextArea jcommentcontent=new JTextArea(30,30);//评论内容
	private JButton jreport=new JButton("发表评论");//评论
	private JTextArea jmDetail = new JTextArea(50, 50);
	private JButton jreturn = new JButton("返回主页");
	private JButton jBuy = new JButton("想看电影");
	private JPanel p = new JPanel();
	private UserService userservice=new UserServiceImpl();
	private CommentService commentservice=new CommentServiceImpl();
    private JLabel[] jothercomment;
    private JLabel[]  jcommentName;
    private JLabel[]  jcommentTime;
    private JTextArea[] jothercommentcontent;
    private List<Comment> comlist;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/* Container contentPane; */
	public MovieUi(Movie movie, User u) {
		this.movie = movie;
		this.u = u;
		 comlist=commentservice.queryAllCommentBymId(movie.getmId());
		int size=comlist.size();
		jothercomment=new JLabel[size];
		jcommentName=new JLabel[size];
		jcommentTime=new JLabel[size];
		jothercommentcontent=new JTextArea[size];
		jcommentcontent.setBounds(0, 0, 1000, 150);
		jcommentcontent.setFont(font1);
		jreport.setBounds(600, 160, 150, 50);
		jreport.setFont(font1);
		jreport.setBackground(Color.GRAY);
		jreport.setForeground(Color.white);
		jreport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reportActionPerformed(e);
			}
		});
		moviebg = new ImageIcon(movie.getmPicaddress());
		jPic.setIcon(moviebg);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jPic.setBounds(400, 150, 400, 500);
		jmName.setText("片名：" + movie.getmName());
		jmName.setFont(font0);
		jmName.setBounds(900, 30, 500, 90);
		jmName.setForeground(Color.LIGHT_GRAY);
		jmType.setText("类型：" + movie.getmType());
		jmType.setBounds(830, 220, 300, 60);
		jmType.setFont(font1);
		jmType.setForeground(Color.LIGHT_GRAY);
		jmLoca.setText("地区：" + movie.getMlocality());
		jmLoca.setBounds(1200, 220, 300, 60);
		jmLoca.setFont(font1);
		jmLoca.setForeground(Color.LIGHT_GRAY);
		jmDuration.setText("时长：" + movie.getmDuration() + "分钟");
		jmDuration.setBounds(830, 260, 300, 60);
		jmDuration.setFont(font1);
		jmDuration.setForeground(Color.LIGHT_GRAY);
		jmLanguage.setText("语言：" + movie.getMlanguage());
		jmLanguage.setBounds(1200, 260, 300, 60);
		jmLanguage.setFont(font1);
		jmLanguage.setForeground(Color.LIGHT_GRAY);
		jmGrade.setText("评分：" + movie.getmGrade() + "分");
		jmGrade.setBounds(970, 150, 300, 60);
		jmGrade.setFont(font1);
		jmGrade.setForeground(Color.LIGHT_GRAY);
		jmDetail.setText("剧情简介：" + movie.getmDetail());
		jmDetail.setBounds(830, 340, 600, 310);
		jmDetail.setFont(font1);
		jmDetail.setLineWrap(true);
		jmDetail.setForeground(Color.black);
		jmDetail.setBackground(Color.white);
		jreturn.setBounds(530, 700, 150, 50);
		jreturn.setFont(font1);
		jreturn.setBackground(Color.GRAY);
		jreturn.setForeground(Color.white);
		jreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				returnActionPerformed(e);
			}

		});
		jBuy.setBounds(1000, 700, 150, 50);
		jBuy.setFont(font1);
		jBuy.setBackground(Color.GRAY);
		jBuy.setForeground(Color.white);
		jBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buyActionPerformed(e);
			}
		});
		User user=new User();
		for(int i=0;i<size;i++) {
			user=userservice.queryUserByid(comlist.get(i).getuId());
			jcommentName[i]=new JLabel(user.getuName());
			jcommentName[i].setBounds(0, 0, 100, 50);
			jcommentName[i].setFont(font2);
			jcommentName[i].setForeground(Color.white);
			
			jcommentTime[i]=new JLabel(formatter.format(comlist.get(i).getComtime()));
			jcommentTime[i].setBounds(150, 0, 280, 50);
			jcommentTime[i].setFont(font2);
			jcommentTime[i].setForeground(Color.white);
			
			jothercommentcontent[i]=new JTextArea(20,20);
			jothercommentcontent[i].setLineWrap(true);
			jothercommentcontent[i].setEditable(false);
			jothercommentcontent[i].setBounds(0, 80, 1000, 150);
			jothercommentcontent[i].setText(comlist.get(i).getComment());
			jothercommentcontent[i].setFont(font2);
			
			jothercomment[i]=new JLabel();			
			jothercomment[i].setBounds(400, 1100+(203*i), 1200, 203);
			jothercomment[i].add(jcommentName[i]);
			jothercomment[i].add(jcommentTime[i]);
			jothercomment[i].add(jothercommentcontent[i]);
			p.add(jothercomment[i]);
		}
		/*
		 * maxLable.add(jPic); maxLable.add(jmName); maxLable.add(jmType);
		 * maxLable.add(jmLoca); maxLable.add(jmDuration); maxLable.add(jmLanguage);
		 * maxLable.add(jmDetail); maxLable.add(jreturn); maxLable.add(jBuy);
		 * maxLable.setBounds(0, 0, 1500, 1500);
		 */
		jcomment.add(jcommentcontent);
		jcomment.add(jreport);
		jcomment.setBounds(400, 800, 1200, 220);
		p.setBackground(Color.darkGray);
		p.add(jPic);
		p.add(jmName);
		p.add(jmType);
		p.add(jmLoca);
		p.add(jmDuration);
		p.add(jmLanguage);
		p.add(jmDetail);
		p.add(jmGrade);
		p.add(jreturn);
		p.add(jBuy);
		p.add(jcomment);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(830, 340, 600, 310);
		p.add(scrollPane_1);
		scrollPane_1.setViewportView(jmDetail);
		jmDetail.setEditable(false);
		p.setLayout(null);
		/*JScrollPane a = new JScrollPane(p);*/
		 p.setPreferredSize(new Dimension(1500,1200+size*203));
		JScrollPane a = new JScrollPane(p);              
		con.add(a);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true);
		jf.setVisible(true);
		a.setVisible(true);

	}

	protected void reportActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean canreport=true;
		for (Comment comment : comlist) {
			if(comment.getuId()==u.getUid()) {
				canreport=false;
				break;
			}
		}
	if(canreport) {
	  if("".equals(jcommentcontent.getText())) {
		  JOptionPane.showMessageDialog(null, "评论不能为空");
	  }else {
		Comment comm=new Comment(u.getUid(),movie.getmId(),jcommentcontent.getText(),new Date());
		if(commentservice.addComment(comm)) {
			JOptionPane.showMessageDialog(null, "评论成功");
			new MovieUi(movie,u);
			jf.dispose();
		}
	  }
	  }else {
		  JOptionPane.showMessageDialog(null, "您已评论过该电影");
	  }
	}

	protected void buyActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new SessionUi(movie, u);
		jf.dispose();
	}

	protected void returnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new UserUi(u, 1);
		jf.dispose();

	}

	public static void main(String[] args) {

	}

}

