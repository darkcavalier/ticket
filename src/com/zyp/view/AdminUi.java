package com.zyp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zyp.service.MovieService;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class AdminUi extends JFrame {

	private JPanel contentPane;
	private JDesktopPane tablePane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUi frame = new AdminUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 1000);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理员功能");
		mnNewMenu.setFont(new Font("楷体", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenu moviemanageMenu = new JMenu("电影管理");
		moviemanageMenu.setFont(new Font("楷体", Font.PLAIN, 20));
		mnNewMenu.add(moviemanageMenu);
		
		JMenuItem addmovieMenuItem = new JMenuItem("电影添加");
		addmovieMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMovieactionPerformed(e);
			}
		});
		addmovieMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		moviemanageMenu.add(addmovieMenuItem);
		
		JMenuItem movieMenuItem = new JMenuItem("电影维护");
		movieMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmoviemanageActionPerformed(e);
			}
		});
		movieMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		moviemanageMenu.add(movieMenuItem);
		
		JMenu cinemamanageMenu = new JMenu("影院管理");
		cinemamanageMenu.setFont(new Font("楷体", Font.PLAIN, 20));
		mnNewMenu.add(cinemamanageMenu);
		
		JMenuItem addcinemaMenuItem = new JMenuItem("影院维护");
		addcinemaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cinemaactionPerformed(e);
			}
		});
		addcinemaMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		cinemamanageMenu.add(addcinemaMenuItem);
		
		JMenuItem addhallMenuItem = new JMenuItem("场厅维护");
		addhallMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hallmanageactionPerformed(e);
			}
		});
		addhallMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		cinemamanageMenu.add(addhallMenuItem);
		
		JMenu sessionMenu = new JMenu("场次管理");
		sessionMenu.setFont(new Font("楷体", Font.PLAIN, 20));
		mnNewMenu.add(sessionMenu);
		
		JMenuItem addsessionMenuItem = new JMenuItem("场次添加");
		addsessionMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addsessionActionPerformed(e);
			}
		});
		addsessionMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		sessionMenu.add(addsessionMenuItem);
		
		JMenuItem sessionMenuItem = new JMenuItem("场次维护");
		sessionMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SessionManager sessionmanage=new SessionManager();
				sessionmanage.setVisible(true);
				tablePane.add(sessionmanage);
			}
		});
		sessionMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		sessionMenu.add(sessionMenuItem);
		
		JMenuItem TicketMenuItem = new JMenuItem("影票管理");
		TicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketManager ticketManager=new TicketManager();
				ticketManager.setVisible(true);
				tablePane.add(ticketManager);
			}
		});
		TicketMenuItem.setFont(new Font("楷体", Font.PLAIN, 20));
		mnNewMenu.add(TicketMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//添加背景图片

		tablePane = new JDesktopPane();
			tablePane.setBackground(Color.WHITE);
		
		 
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(tablePane, GroupLayout.DEFAULT_SIZE, 1753, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tablePane, GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("欢迎使用影票管理系统");
		/*lblNewLabel.setForeground(Color.WHITE);*/
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(862, 111, 402, 54);
		tablePane.add(lblNewLabel);
		
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	protected void hallmanageactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		HallManage hallManage=new HallManage();
		hallManage.setVisible(true);
		tablePane.add(hallManage);	
	}

	protected void cinemaactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CinemaManage cinemaManage=new CinemaManage();
		cinemaManage.setVisible(true);
		tablePane.add(cinemaManage);	
	}

	protected void sessionmanagerActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void addsessionActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AddSession addSession=new AddSession();
		addSession.setVisible(true);
		tablePane.add(addSession);
		
	}

	protected void mmoviemanageActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MovieManage movieManage=new MovieManage();
		movieManage.setVisible(true);
		tablePane.add(movieManage);
	}

	protected void addMovieactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AddMovie addmovie=new AddMovie();
		addmovie.setVisible(true);
		tablePane.add(addmovie);
	}
}
