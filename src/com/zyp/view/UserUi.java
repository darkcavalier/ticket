package com.zyp.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.zyp.entity.Cinema;
import com.zyp.entity.Comment;
import com.zyp.entity.Hall;
import com.zyp.entity.Movie;
import com.zyp.entity.Session;
import com.zyp.entity.Ticket;
import com.zyp.entity.User;
import com.zyp.service.CinemaService;
import com.zyp.service.CommentService;
import com.zyp.service.HallService;
import com.zyp.service.MovieService;
import com.zyp.service.SessionService;
import com.zyp.service.TicketService;
import com.zyp.service.UserService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.CommentServiceImpl;
import com.zyp.service.impl.HallServiceImpl;
import com.zyp.service.impl.MovieServiceImpl;
import com.zyp.service.impl.SessionServiceImpl;
import com.zyp.service.impl.TicketServiceImpl;
import com.zyp.service.impl.UserServiceImpl;

public class UserUi implements ActionListener {
	private User user;
	private UserService uo=new UserServiceImpl();
	private MovieService mo = new MovieServiceImpl();
	private TicketService ticketservice=new TicketServiceImpl();
	private CommentService commentservice=new CommentServiceImpl();
	private CinemaService cinemaservice=new CinemaServiceImpl();
	private SessionService sessionservice=new SessionServiceImpl();
	private HallService  hallservice=new HallServiceImpl();
	private int size=0;
	private int size1=0;
	private int size2=0;
	private int size3=0;
	private int size4=0;
	private int row = -1;// 行
	private int row1=-1;
	private int defaultcard;
	private Comment ccomment;
	private JLabel card0 = new JLabel();//用户
	private JLabel card8 = new JLabel();//我的影票
	private JLabel card1 = new JLabel();//热门
	private JLabel card2 = new JLabel();//查找
	private JLabel card3 = new JLabel();//科幻
	private JLabel card4 = new JLabel();//动作
	private JLabel card5 = new JLabel();//爱情
	/*private JLabel card6 = new JLabel();//剧情
	private JLabel card7 = new JLabel();//动漫
*/	private JFrame jf = new JFrame("电影购票系统");
	private JMenuBar menuBar = new JMenuBar();
	private Container con = jf.getContentPane();// 获得面板
	private JPasswordField oldpass = new JPasswordField();
	private JPasswordField newpass = new JPasswordField();
	private JButton jupdatere=new JButton("更改评论");
	private JButton jreport=new JButton("发表");
	private JButton reFresh = new JButton("刷新");
	private JButton btnexit = new JButton("退出");//
	private JButton updatepass = new JButton("修改密码");
	private JButton confirmUp = new JButton("确定");
	private JButton cancel = new JButton("取消");
	private JLabel oldjl;
	private JLabel newjl;
	private JTable ticktb;
	private JTable movietb;
	private ImageIcon userinfobg = new ImageIcon("images/userinfobg.jpg");
	private Font font = new Font("楷体", 0, 20);
	private Font font0 = new Font("楷体", 0, 25);
	private Font font1 = new Font("楷体", 0, 16);
	private Font font2 = new Font("楷体", 0, 15);
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension sc = toolkit.getScreenSize();// 获得屏幕尺寸
	private JLabel jIscomment=new JLabel();//是否评论
	private JTextArea jcommentcontent=new JTextArea(30,30);//评论内容
	private JLabel  moviebtn_label;
	private JButton moviecard1_btn;
	private JButton delTicket;
	private JLabel moviename;
	private JLabel movielocality_language;
	private JLabel movietype_grade;
	private JTextField jsearch_nametext=new JTextField();	
	private JButton jsearch_jbutton=new JButton("搜索电影");
	
	//评分前十
	private JLabel[][] btn_label;
	private JButton[] card1_btn;
	private JLabel[][] dname;
	private JLabel[][] locality_language;
	private JLabel[][] type_grade;
	//科幻部分
	private JLabel[][] btn_label1;
	private JButton[] card1_btn1;
	private JLabel[][] dname1;
	private JLabel[][] locality_language1;
	private JLabel[][] type_grade1;
	//动作部分
	private JLabel[][] btn_label2;
	private JButton[] card1_btn2;
	private JLabel[][] dname2;
	private JLabel[][] locality_language2;
	private JLabel[][] type_grade2;
	//爱情部分
	private JLabel[][] btn_label3;
	private JButton[] card1_btn3;
	private JLabel[][] dname3;
	private JLabel[][] locality_language3;
	private JLabel[][] type_grade3;
	
	private List<Ticket> ticketlist;
	private List<Movie> movielist;
	private List<Movie> list;
	private List<Movie> sciencelist;
	private List<Movie> actionlist;
	private List<Movie> lovelist;
	private JButton isrecharge;//选择充值按钮
	private JLabel rechargeinfo;//提示
	private JButton recharge;//充值按钮
	private JTextField charge;//输入
	private JLabel[] card0_label = new JLabel[2];
	public UserUi(User u, int defaultcard) {
		user = u;
		this.defaultcard = defaultcard;
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);// 点击栏位置
		// 选项卡面板类
		reFresh.addActionListener(this);
		reFresh.setFont(font1);
		btnexit.addActionListener(this);
		btnexit.setFont(font1);
		jf.setJMenuBar(menuBar);
		menuBar.add(reFresh);
		menuBar.add(btnexit);
		tabbedPane.setFont(font);// 左栏字体，字号

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 每个选项卡滚动模式
		con.add(tabbedPane);
		// 用户信息
		tabbedPane.addTab("欢迎您，" + user.getuName(), card0);
		JLabel maxlabel = new JLabel();
		
		for (int i = 0; i < 2; i++) {
			card0_label[i] = new JLabel();
			maxlabel.add(card0_label[i]);
			card0_label[i].setFont(font0);
			card0_label[i].setBounds(40, 70 + (i * 50), 500, 50);
		}

		card0_label[0].setText("您的信息如下： ");
		card0_label[0].setForeground(Color.gray);
		card0_label[1].setText("用户名 : " + user.getuName()+"余额："+user.getBalance()+"元");
		card0_label[1].setForeground(Color.gray);
		updatepass.setBounds(40, 190, 120, 35);
		updatepass.addActionListener(this);
		updatepass.setBackground(Color.gray);
		updatepass.setFont(font);
		updatepass.setForeground(Color.white);
		maxlabel.add(updatepass);
		isrecharge=new JButton("充值金额");
		isrecharge.setBounds(200, 190, 120, 35);
		isrecharge.addActionListener(this);
		isrecharge.setFont(font);
		isrecharge.setForeground(Color.white);
		isrecharge.setBackground(Color.gray);
		maxlabel.add(isrecharge);
		rechargeinfo=new JLabel("请输入金额");
		rechargeinfo.setBounds(200, 250, 120, 30);
		rechargeinfo.setFont(font);
		rechargeinfo.setForeground(Color.LIGHT_GRAY);
		rechargeinfo.setVisible(false);
		maxlabel.add(rechargeinfo);
		charge=new JTextField();
		charge.setBounds(200, 300, 120, 30);
		charge.setBackground(Color.GRAY);
		charge.setFont(font);
		charge.setForeground(Color.white);
		charge.setFont(font);
		charge.setVisible(false);
		maxlabel.add(charge);
		recharge=new JButton("充值");
		recharge.setBounds(200, 380, 120, 30);
		recharge.setForeground(Color.white);
		recharge.setBackground(Color.GRAY);
		recharge.setFont(font);
		recharge.setVisible(false);
		recharge.addActionListener(this);
		maxlabel.add(recharge);
		oldjl = new JLabel("原密码");
		oldjl.setBounds(40, 250, 90, 30);
		oldjl.setForeground(Color.LIGHT_GRAY);
		oldjl.setFont(font);
		oldjl.setVisible(false);
		maxlabel.add(oldjl);

		oldpass.setBounds(40, 280, 120, 30);
		oldpass.setBackground(Color.GRAY);
		oldpass.setFont(font);
		oldpass.setForeground(Color.white);
		oldpass.setEchoChar('*');
		oldpass.setVisible(false);
		maxlabel.add(oldpass);

		newjl = new JLabel("新密码");
		newjl.setBounds(40, 350, 90, 30);
		newjl.setFont(font);
		newjl.setForeground(Color.LIGHT_GRAY);
		newjl.setVisible(false);
		maxlabel.add(newjl);

		newpass.setBounds(40, 380, 120, 30);
		newpass.setBackground(Color.GRAY);
		newpass.setForeground(Color.white);
		newpass.setFont(font);
		newpass.setEchoChar('*');
		newpass.setVisible(false);
		maxlabel.add(newpass);
		// cancel取消
		cancel.setBounds(40, 500, 120, 30);
		maxlabel.add(cancel);
		cancel.setBackground(Color.GRAY);
		cancel.setForeground(Color.white);
		cancel.setFont(font);
		cancel.setVisible(false);
		cancel.addActionListener(this);

		confirmUp.setBounds(40, 445, 120, 30);
		confirmUp.setBackground(Color.GRAY);
		confirmUp.setForeground(Color.white);
		confirmUp.setFont(font);
		maxlabel.add(confirmUp);
		confirmUp.setVisible(false);
		confirmUp.addActionListener(this);

		maxlabel.setIcon(userinfobg);
		maxlabel.setBounds(0, 0, 1800, 1000);
		card0.add(maxlabel);
		// 热门电影
		tabbedPane.addTab("热门电影", card1);
		list = mo.OrderMovieTen();
		int row = (list.size() + 3) / 4;
		int k = list.size();

		 btn_label = new JLabel[row][4];
		 card1_btn = new JButton[k];
		dname = new JLabel[row][4];
		 locality_language = new JLabel[row][4];
		 type_grade = new JLabel[row][4];
//测试   
		
		JLabel allinfo = new JLabel();//包含所有信息

		String[] cnames = { "", "", "", "" };
		JTable tb = new JTable(btn_label, cnames);

		allinfo.setSize(1610, 602 * row);
		tb.setRowHeight(600);
		int x = 0;
		ImageIcon img = null;
		ImageIcon defaultImg = new ImageIcon("images/img.jpg");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 4 && x < k; j++) {
				if (list.get(x).getmPicaddress() != null) {
					img = new ImageIcon(list.get(x).getmPicaddress());
				} else {
					img = defaultImg;
				}
				card1_btn[x] = new JButton(img);//按钮
				card1_btn[x].setText(list.get(x).getmId()+"");
				card1_btn[x].setBounds(0, 0, 400, 500);
				card1_btn[x].addActionListener(this);
				dname[i][j] = new JLabel("片名：" + list.get(x).getmName()+"   评分："+list.get(x).getmGrade());
				dname[i][j].setBounds(0, 510, 400, 30);
				dname[i][j].setFont(font);

				locality_language[i][j] = new JLabel(
						"地区：" + list.get(x).getMlocality() + "  语言：" + list.get(x).getMlanguage());
				locality_language[i][j].setBounds(0, 540, 400, 30);
				locality_language[i][j].setFont(font1);
				type_grade[i][j] = new JLabel(
						"类型:" + (list.get(x).getmType()) + "   " + "时长 :" + list.get(x).getmDuration() + "分钟"); 
																												
																												
				type_grade[i][j].setBounds(0, 570, 400, 30);
				type_grade[i][j].setFont(font2);

				btn_label[i][j] = new JLabel();
				btn_label[i][j].setBounds(402 * j + 1, 600 * i, 400, 600);
				btn_label[i][j].add(dname[i][j]);
				btn_label[i][j].add(locality_language[i][j]);
				btn_label[i][j].add(type_grade[i][j]);
				btn_label[i][j].add(card1_btn[x]);

				allinfo.add(btn_label[i][j]);

				x++;
			}
			size=x;
		}
     
		tb.add(allinfo);
		tb.setEnabled(false);
		JScrollPane sPane = new JScrollPane(tb);
		// sPane.add()加按钮等一些控件时，要鼠标滑过，才会显示出来，直接在构造方法中传参则正常

		
		sPane.setBounds(0, 0, 1627, 950);
		sPane.setVisible(true);
		card1.add(sPane);
		tabbedPane.addTab("我的影票", card8);
		jupdatere.setBounds(850, 80, 150, 50);
		jupdatere.setFont(font);
		card8.add(jupdatere);
		jupdatere.addActionListener(this);
		jreport.setBounds(1200, 80, 100, 50);
		jreport.setFont(font);
		jreport.addActionListener(this);
		card8.add(jreport);
		jIscomment.setText("您的评论");
		jIscomment.setFont(font0);
		jIscomment.setBounds(400, 50, 300, 200);
		card8.add(jIscomment);
		delTicket=new JButton("退订");
		delTicket.setFont(font);
		delTicket.setBounds(1400, 350, 100, 50);
		delTicket.addActionListener(this);
		card8.add(delTicket);
		jcommentcontent.setBounds(300, 250, 1000, 150);
		jcommentcontent.setFont(font0);
		card8.add(jcommentcontent);
		ticketlist=ticketservice.queryAllTicketuId(user.getUid());
		/*int ticketRow = ticketlist.size();
		Session session;
		Hall hall;
		Cinema cinema;
		Movie tmovie;*/
		/*String[][] ticinfo = new String[ticketRow][9];
		     
		for (int i = 0; i < ticketRow; i++) {
			session=sessionservice.querySessionById(ticketlist.get(i).getsId());
			hall=hallservice.queryHallById(session.gethId());
			cinema=cinemaservice.queryCinemaById(session.getcId());
			tmovie=mo.queryMovieById(session.getmId());
			ticinfo[i][0]=String.valueOf(ticketlist.get(i).gettId() );
			ticinfo[i][1]=user.getuName();
			ticinfo[i][2]= cinema.getCname() ;
			ticinfo[i][3]=cinema.getCaddress();
			ticinfo[i][4]=hall.gethName();
			ticinfo[i][5]=tmovie.getmName();
			ticinfo[i][6]=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getBeginTime());
			ticinfo[i][7]=String.valueOf(session.getPrice());
			ticinfo[i][8]=String.valueOf(ticketlist.get(i).getSeat());
			
		}
		// 加上影院地址
        String[] tbheadnames = { "影票编号", "用户名", "影院名称", "影院地址","场厅名字", "电影名称", "开始时间", "价格", "座位号" };*/
        ticktb = new JTable() {
			public boolean isCellEditable( int row, int column) {
				return false;
			}

		};
		ticktb.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"影票编号", "用户名", "影院名称","影院地址","场厅名字","电影名称","开始时间","价格","座位号"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false,false,false,false,false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		fillticktable(ticketlist);
		r.setHorizontalAlignment(JLabel.CENTER);
		ticktb.setDefaultRenderer(Object.class, r);
		ticktb.setRowHeight(90);
		ticktb.setFont(font);
		ticktb.getTableHeader().setFont(new Font("楷体", 1, 20));
		ticktb.getTableHeader().setBackground(Color.orange);
		ticktb.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		ticktb.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		ticktb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				ticktablemousePressed(me);
			}
		});
		JScrollPane ticsPane = new JScrollPane(ticktb);
		
		ticsPane.setBounds(0, 420, 1800, 480);
		
		card8.add(ticsPane);
		tabbedPane.addTab("查找电影", card2);
		jsearch_jbutton.setBounds(400,450,150,40);
		jsearch_jbutton.setFont(font);
		jsearch_jbutton.addActionListener(this);
		jsearch_nametext.setBounds(50,450,300,40);
		jsearch_nametext.setFont(font);
		card2.add(jsearch_nametext);
		card2.add(jsearch_jbutton);
		moviecard1_btn=new JButton();
		moviecard1_btn.setBounds(580, 0,  400, 500);
		moviename=new JLabel();
		moviename.setBounds(1080, 100, 400, 30);
		moviename.setFont(font);
		movielocality_language=new JLabel();
		movielocality_language.setBounds(1080, 150, 400, 30);
		movielocality_language.setFont(font);
		movietype_grade=new JLabel();
		movietype_grade.setBounds(1080, 200, 400, 30);
		movietype_grade.setFont(font);
		moviebtn_label=new JLabel();
		
		/*moviebtn_label.add(moviecard1_btn);
		moviebtn_label.add(moviename);
		moviebtn_label.add(movielocality_language);
		moviebtn_label.add(movietype_grade);*/
		/*card2.add(moviebtn_label);*/
		card2.add(moviecard1_btn);
		card2.add(moviename);
		card2.add(movielocality_language);
		card2.add(movietype_grade);
		movielist=mo.queryAllMovie();
		moviecard1_btn.addActionListener(this);
		if(movielist.size()!=0) {
			moviecard1_btn.setIcon(new ImageIcon(movielist.get(0).getmPicaddress()));
			moviename.setText("片名：" +movielist.get(0).getmName()+"   评分："+movielist.get(0).getmGrade());
			movielocality_language.setText("地区：" + movielist.get(0).getMlocality() + "  语言：" + movielist.get(0).getMlanguage());
			movietype_grade.setText("类型:" + (movielist.get(0).getmType()) + "   " + "时长 :" + movielist.get(0).getmDuration() + "分钟");
		}
		movietb=new JTable(){
			  public boolean isCellEditable( int row, int column) {
					return false;
				}

			};
		movietb.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"电影编号", "电影名字", "语言", " 地区","时长","类别","分数"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		fillTable( movielist);
		movietb.setDefaultRenderer(Object.class, r);
		movietb.setRowHeight(70);
		movietb.setFont(font);
		movietb.getTableHeader().setFont(new Font("楷体", 1, 20));
		movietb.getTableHeader().setBackground(Color.orange);
		movietb.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		movietb.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		movietb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				movietbmousePressed(me);
			}
		});
      JScrollPane moviesPane = new JScrollPane(movietb);		
      moviesPane.setBounds(0, 510, 1800, 450);
		card2.add(moviesPane);
		//科幻电影
		tabbedPane.addTab("科幻", card3);				
		sciencelist=mo.queryMovieByType("科幻");
		int row1 = (sciencelist.size() + 3) / 4;
		int k1 = sciencelist.size();
		 btn_label1 = new JLabel[row1][4];
		 card1_btn1 = new JButton[k1];
		dname1 = new JLabel[row1][4];
		 locality_language1 = new JLabel[row1][4];
		 type_grade1 = new JLabel[row1][4];
		JLabel allinfo1 = new JLabel();//包含所有信息
		String[] cnames1 = { "", "", "", "" };
		JTable tb1 = new JTable(btn_label1, cnames1);
		allinfo1.setSize(1610, 602 * row1);
		tb1.setRowHeight(600);
		int x1 = 0;
		ImageIcon img1 = null;
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < 4 && x1 < k1; j++) {
				if (sciencelist.get(x1).getmPicaddress() != null) {
					img1 = new ImageIcon(sciencelist.get(x1).getmPicaddress());
				} else {
					img1 = defaultImg;
				}
				card1_btn1[x1] = new JButton(img1);//按钮
				card1_btn1[x1].setText(sciencelist.get(x1).getmId()+"");
				card1_btn1[x1].setBounds(0, 0, 400, 500);
				card1_btn1[x1].addActionListener(this);
				dname1[i][j] = new JLabel("片名：" + sciencelist.get(x1).getmName()+"   评分："+sciencelist.get(x1).getmGrade());
				dname1[i][j].setBounds(0, 510, 400, 30);
				dname1[i][j].setFont(font);
				locality_language1[i][j] = new JLabel(
						"地区：" + sciencelist.get(x1).getMlocality() + "  语言：" + sciencelist.get(x1).getMlanguage());
				locality_language1[i][j].setBounds(0, 540, 400, 30);
				locality_language1[i][j].setFont(font1);
				type_grade1[i][j] = new JLabel(
						"类型:" + (sciencelist.get(x1).getmType()) + "   " + "时长 :" + sciencelist.get(x1).getmDuration() + "分钟"); 
				type_grade1[i][j].setBounds(0, 570, 400, 30);
				type_grade1[i][j].setFont(font2);
				btn_label1[i][j] = new JLabel();
				btn_label1[i][j].setBounds(402 * j + 1, 600 * i, 400, 600);
				btn_label1[i][j].add(dname1[i][j]);
				btn_label1[i][j].add(locality_language1[i][j]);
				btn_label1[i][j].add(type_grade1[i][j]);
				btn_label1[i][j].add(card1_btn1[x1]);
				allinfo1.add(btn_label1[i][j]);

				x1++;
			}
			size1=x1;
		}
		tb1.add(allinfo1);
		tb1.setEnabled(false);
		JScrollPane sPane1 = new JScrollPane(tb1);
		// sPane.add()加按钮等一些控件时，要鼠标滑过，才会显示出来，直接在构造方法中传参则正常
		
		sPane1.setBounds(0, 0, 1627, 950);
		sPane1.setVisible(true);
		card3.add(sPane1);
		//动作
		tabbedPane.addTab("动作", card4);	
		actionlist=mo.queryMovieByType("动作");
		int row2 = (actionlist.size() + 3) / 4;
		int k2 = actionlist.size();
		btn_label2 = new JLabel[row2][4];
		 card1_btn2 = new JButton[k2];
		dname2 = new JLabel[row2][4];
		 locality_language2 = new JLabel[row2][4];
		 type_grade2 = new JLabel[row2][4];
		 JLabel allinfo2 = new JLabel();//包含所有信息
		 String[] cnames2 = { "", "", "", "" };
		 JTable tb2 = new JTable(btn_label2, cnames2);
		 allinfo2.setSize(1610, 602 * row2);
			tb2.setRowHeight(600);
			int x2 = 0;
			ImageIcon img2 = null;
			for (int i = 0; i < row2; i++) {
				for (int j = 0; j < 4 && x2 < k2; j++) {

					if (actionlist.get(x2).getmPicaddress() != null) {
						img2 = new ImageIcon(actionlist.get(x2).getmPicaddress());
					} else {
						img2 = defaultImg;
					}
					card1_btn2[x2] = new JButton(img2);//按钮
					card1_btn2[x2].setText(actionlist.get(x2).getmId()+"");
					card1_btn2[x2].setBounds(0, 0, 400, 500);
					card1_btn2[x2].addActionListener(this);
					dname2[i][j] = new JLabel("片名：" + actionlist.get(x2).getmName()+"   评分："+actionlist.get(x2).getmGrade());
					dname2[i][j].setBounds(0, 510, 400, 30);
					dname2[i][j].setFont(font);
					locality_language2[i][j] = new JLabel(
							"地区：" + actionlist.get(x2).getMlocality() + "  语言：" + actionlist.get(x2).getMlanguage());
					locality_language2[i][j].setBounds(0, 540, 400, 30);
					locality_language2[i][j].setFont(font1);
					type_grade2[i][j] = new JLabel(
							"类型:" + (actionlist.get(x2).getmType()) + "   " + "时长 :" + actionlist.get(x2).getmDuration() + "分钟"); 
					type_grade2[i][j].setBounds(0, 570, 400, 30);
					type_grade2[i][j].setFont(font2);
					btn_label2[i][j] = new JLabel();
					btn_label2[i][j].setBounds(402 * j + 1, 600 * i, 408, 600);
					btn_label2[i][j].add(dname2[i][j]);
					btn_label2[i][j].add(locality_language2[i][j]);
					btn_label2[i][j].add(type_grade2[i][j]);
					btn_label2[i][j].add(card1_btn2[x2]);
					allinfo2.add(btn_label2[i][j]);

					x2++;
					/*if(actionlist.size())*/
				}
				size2=x2;
			}
			tb2.add(allinfo2);
			tb2.setEnabled(false);
			JScrollPane sPane2 = new JScrollPane(tb2);
			// sPane.add()加按钮等一些控件时，要鼠标滑过，才会显示出来，直接在构造方法中传参则正常			
			sPane2.setBounds(0, 0, 1627, 950);
			sPane2.setVisible(true);
			card4.add(sPane2);
		tabbedPane.addTab("爱情", card5);
		lovelist=mo.queryMovieByType("爱情");
		int row3 = (lovelist.size() + 3) / 4;
		int k3 = lovelist.size();
		 btn_label3 = new JLabel[row3][4];
		 card1_btn3 = new JButton[k3];
		dname3 = new JLabel[row3][4];	
		 locality_language3 = new JLabel[row3][4];
		 type_grade3 = new JLabel[row3][4];
		JLabel allinfo3 = new JLabel();//包含所有信息
		String[] cnames3 = { "", "", "", "" };
		JTable tb3 = new JTable(btn_label3, cnames3);
		allinfo3.setSize(1610, 602 * row3);
		tb3.setRowHeight(600);
		int x3 = 0;
		ImageIcon img3 = null;
		for (int i = 0; i < row3; i++) {
			for (int j = 0; j < 4 && x3 < k3; j++) {
				if (lovelist.get(x3).getmPicaddress() != null) {
					img3 = new ImageIcon(lovelist.get(x3).getmPicaddress());
				} else {
					img3 = defaultImg;
				}
				card1_btn3[x3] = new JButton(img3);//按钮
				card1_btn3[x3].setText(lovelist.get(x3).getmId()+"");
				card1_btn3[x3].setBounds(0, 0, 400, 500);
				card1_btn3[x3].addActionListener(this);
				dname3[i][j] = new JLabel("片名：" + lovelist.get(x3).getmName()+"   评分："+lovelist.get(x3).getmGrade());
				dname3[i][j].setBounds(0, 510, 400, 30);
				dname3[i][j].setFont(font);
				locality_language3[i][j] = new JLabel(
						"地区：" + lovelist.get(x3).getMlocality() + "  语言：" + lovelist.get(x3).getMlanguage());
				locality_language3[i][j].setBounds(0, 540, 400, 30);
				locality_language3[i][j].setFont(font1);
				type_grade3[i][j] = new JLabel(
						"类型:" + (lovelist.get(x3).getmType()) + "   " + "时长 :" + lovelist.get(x3).getmDuration() + "分钟"); 
				type_grade3[i][j].setBounds(0, 570, 400, 30);
				type_grade3[i][j].setFont(font2);
				btn_label3[i][j] = new JLabel();
				btn_label3[i][j].setBounds(402 * j + 1, 600 * i, 408, 600);
				btn_label3[i][j].add(dname3[i][j]);
				btn_label3[i][j].add(locality_language3[i][j]);
				btn_label3[i][j].add(type_grade3[i][j]);
				btn_label3[i][j].add(card1_btn3[x3]);
				allinfo3.add(btn_label3[i][j]);

				x3++;
			}
			
			
		}
		size3=x3;
		tb3.add(allinfo3);
		tb3.setEnabled(false);
		JScrollPane sPane3 = new JScrollPane(tb3);
		// sPane.add()加按钮等一些控件时，要鼠标滑过，才会显示出来，直接在构造方法中传参则正常
		
		sPane3.setBounds(0, 0, 1627, 950);
		sPane3.setVisible(true);
		card5.add(sPane3);
		
		
		tabbedPane.setBackground(Color.GRAY);	
		tabbedPane.setForeground(Color.BLACK);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		con.setVisible(true);

	}

	private void fillticktable(List<Ticket> ticketlist2) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=(DefaultTableModel) ticktb.getModel();
		dtm.setRowCount(0); // 设置成0行
		int ticketRow = ticketlist.size();
		Session session;
		Hall hall;
		Cinema cinema;
		Movie tmovie;
		for (int i = 0; i < ticketRow; i++) {
			session=sessionservice.querySessionById(ticketlist.get(i).getsId());
			hall=hallservice.queryHallById(session.gethId());
			cinema=cinemaservice.queryCinemaById(session.getcId());
			tmovie=mo.queryMovieById(session.getmId());
			Vector v=new Vector();
			  v.add(ticketlist.get(i).gettId());
			  v.add(user.getuName());
			  v.add( cinema.getCname());
			  v.add(cinema.getCaddress());
			  v.add(hall.gethName());
			  v.add(tmovie.getmName());
			  v.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getBeginTime()));
			  v.add(session.getPrice());
			  v.add(ticketlist.get(i).getSeat());
			  dtm.addRow(v);
		}
	}

	protected void movietbmousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		row1=movietb.getSelectedRow();
		if(row1!=-1) {
			moviecard1_btn.setIcon(new ImageIcon(movielist.get(row1).getmPicaddress()));
			moviename.setText("片名：" +movielist.get(row1).getmName()+"   评分："+movielist.get(row1).getmGrade());
			movielocality_language.setText("地区：" + movielist.get(row1).getMlocality() + "  语言：" + movielist.get(row1).getMlanguage());
			movietype_grade.setText("类型:" + (movielist.get(row1).getmType()) + "   " + "时长 :" + movielist.get(row1).getmDuration() + "分钟");	
		}
	}

	private void fillTable(List<Movie> movielist2) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=(DefaultTableModel) movietb.getModel();
		dtm.setRowCount(0); // 设置成0行
		int movieRow= movielist2.size();
		
		for(int i=0;i<movieRow;i++) {
			Vector v=new Vector();
			v.add(movielist2.get(i).getmId());
			v.add(movielist2.get(i).getmName());
			v.add(movielist2.get(i).getMlanguage());
			v.add(movielist2.get(i).getMlocality());
			v.add(movielist2.get(i).getmDuration());
			v.add(movielist2.get(i).getmType());
			v.add(movielist2.get(i).getmGrade());
			dtm.addRow(v);
		
		}
		 
		
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);			
	}

	protected void ticktablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		Session csession;
		
		row = ticktb.getSelectedRow();
		if(row!=-1) {
			csession=sessionservice.querySessionById(ticketlist.get(row).getsId());
			ccomment=new Comment(user.getUid(),csession.getmId());
			ccomment=commentservice.queryComment(ccomment);
			if(ccomment!=null) {
				jcommentcontent.setText(ccomment.getComment());
				jcommentcontent.setLineWrap(true);
				jcommentcontent.setEditable(false);
				jIscomment.setText("您已评论");
			}else {
				jcommentcontent.setEditable(true);
				jIscomment.setText("您还未评论");
				jcommentcontent.setText("");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==isrecharge) {
			rechargeinfo.setVisible(true);
			 recharge.setVisible(true);
			 charge.setVisible(true);
		}
		if(obj==recharge) {
			if("".equals(charge.getText())) {
				LoginUi.winMessage("您还未输金额！");
			}else {
				try {
					double reprice=Double.parseDouble(charge.getText());
					this.user.setBalance(this.user.getBalance()+reprice);
					if(uo.updateUser(user)) {
						LoginUi.winMessage("充值成功");
						card0_label[1].setText("用户名 :" + user.getuName()+"余额："+user.getBalance()+"元");
					}else {
						LoginUi.winMessage("充值失败");
					}
				}
				catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "输入格式错误");
				}
				
			}
		}
		if(obj==moviecard1_btn) {
			if(row1!=-1) {
				new MovieUi(movielist.get(row1),this.user);
				 jf.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "请选择电影");
			}
		}
		if(obj==jsearch_jbutton) {
			
			movielist=mo.queryMovieBymovieName(jsearch_nametext.getText());
			if(movielist!=null) {
				
			fillTable(movielist);
			}
		}
		if(obj==jupdatere) {
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "未选择影票");
			}else {
			if("".equals(jcommentcontent.getText())) {
				JOptionPane.showMessageDialog(null, "您还未参与评论");
			}else {
				jcommentcontent.setEditable(true);
			}
			}
		}
		if(obj==jreport) {
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "未选择影票");
			}else {
			if("".equals(jcommentcontent.getText())) {
				JOptionPane.showMessageDialog(null, "评论不能为空");
			}else {
				ccomment.setComment(jcommentcontent.getText());				
				if(commentservice.updateComment(ccomment)) {
					JOptionPane.showMessageDialog(null, "修改评论成功");
					jcommentcontent.setEditable(false);
				}else {
					JOptionPane.showMessageDialog(null, "系统错误");
				}
				
			}
			}
		}
		if(obj==delTicket) {
			Ticket ticket;
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "未选择影票");
			}else {
				ticket=ticketlist.get(row);
				if(ticketservice.delTicket(ticket.gettId())) {
				Session desession=sessionservice.querySessionById(ticket.getsId());
				desession.setRemain(desession.getRemain()+1);
				   if(sessionservice.updateSession(desession)) {
					JOptionPane.showMessageDialog(null, "退票成功");
					this.user.setBalance(this.user.getBalance()+desession.getPrice());
					uo.updateUser(this.user);
					ticketlist.remove(row);
					fillticktable(ticketlist);
				   }else {
					   JOptionPane.showMessageDialog(null, "退票失败");
				   }										
				}	
				else {
					JOptionPane.showMessageDialog(null, "退票失败");
				}
			}
		}
		for(int i=0;i<size;i++) {
			if(obj==card1_btn[i]) {
				new MovieUi(list.get(i),this.user);
				jf.dispose();
				
			}
		}
		for(int i=0;i<size1;i++) {
			if(obj==card1_btn1[i]) {
				new MovieUi(sciencelist.get(i),this.user);
				jf.dispose();
				
			}
		}
		for(int i=0;i<size2;i++) {
			if(obj==card1_btn2[i]) {
				new MovieUi(actionlist.get(i),this.user);
				jf.dispose();
			}
		}
		for(int i=0;i<size3;i++) {
			if(obj==card1_btn3[i]) {
				new MovieUi(lovelist.get(i),this.user);
				jf.dispose();
			}
		}
		if (e.getSource() == this.updatepass) {//修改按钮
			this.oldjl.setVisible(true);
			this.oldpass.setVisible(true);
			this.newjl.setVisible(true);
			this.newpass.setVisible(true);
			this.cancel.setVisible(true);
			this.confirmUp.setVisible(true);
		}else if(e.getSource() == this.btnexit) {//退出登录
			new LoginUi();
			jf.dispose();
		}else if(e.getSource() == this.reFresh) {//刷新
			jf.dispose();
			new UserUi(user, this.defaultcard);
		}else if(e.getSource() == this.confirmUp) {
			//修改密码
			
			String oldpassw = new String(this.oldpass.getPassword());
			String newpassw = new String(this.newpass.getPassword());
			if("".equals(oldpassw) || "".equals(newpassw)) {
				LoginUi.winMessage("信息不完整！");
			} else if(!oldpassw.equals(user.getuPass())) {
				LoginUi.winMessage("原密码错误，无法更改！");
			}
			else {
				this.user.setuPass(newpassw);
				
				if(uo.updateUser(this.user)) {
					LoginUi.winMessage("密码修改成功！");
					this.oldjl.setText("");
					this.oldpass.setText("");
					this.newjl.setText("");
					this.newpass.setText("");
					
					this.oldjl.setVisible(false);
					this.oldpass.setVisible(false);
					this.newjl.setVisible(false);
					this.newpass.setVisible(false);					
					this.cancel.setVisible(false);
					this.confirmUp.setVisible(false);
				} else {
					LoginUi.winMessage("密码修改失败！");
				}
			}
			
		} else if(e.getSource() == this.cancel) {
			this.oldjl.setText("");
			this.oldpass.setText("");
			this.newjl.setText("");
			this.newpass.setText("");
			
			this.oldjl.setVisible(false);
			this.oldpass.setVisible(false);
			this.newjl.setVisible(false);
			this.newpass.setVisible(false);
			
			this.cancel.setVisible(false);
			this.confirmUp.setVisible(false);
		}
	}

	public static void main(String[] args) {
		User u = new User();
		new UserUi(u, 1);
		

	}
}
 
 

