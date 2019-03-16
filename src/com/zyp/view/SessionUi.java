package com.zyp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.zyp.entity.Cinema;
import com.zyp.entity.Hall;
import com.zyp.entity.Movie;
import com.zyp.entity.Session;
import com.zyp.entity.User;
import com.zyp.service.CinemaService;
import com.zyp.service.HallService;
import com.zyp.service.SessionService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.HallServiceImpl;
import com.zyp.service.impl.SessionServiceImpl;

public class SessionUi {
	private Movie mo;
	private User ue;
	private SessionService seser = new SessionServiceImpl();
	private CinemaService cinema = new CinemaServiceImpl();
	private HallService hall = new HallServiceImpl();
	private Font font = new Font("楷体", 0, 20);
	private Font font1 = new Font("楷体", 0, 28);
	private JFrame jf = new JFrame("电影购票系统");
	private JLabel jb = new JLabel();
	private JTable tb;// 表
	private int row = -1;// 行
	private Container con = jf.getContentPane();
	private JPanel p = new JPanel();
	private JButton jBuyticket = new JButton("选座购票");
	private JButton jreturn=new JButton("返回上一层");
	private List<Session> sessionlist;
    private JLabel search=new JLabel("影院名");
    private JTextField serchText=new JTextField();
    private JButton serbtn=new JButton("搜索场次");
	public SessionUi(Movie mo, User ue) {
		this.mo = mo;
		this.ue = ue;
		p.setLayout(null);
		sessionlist = seser.querySessionBymId(mo.getmId());
		int sessionRow = sessionlist.size();
		Hall h = new Hall();
		Cinema ci = new Cinema();
	/*	String[][] rinfo = new String[sessionRow][8];
		for (int i = 0; i < sessionRow; i++) {
			h = hall.queryHallById(sessionlist.get(i).gethId());
			ci = cinema.queryCinemaById(sessionlist.get(i).getcId());
			rinfo[i][0] = String.valueOf(sessionlist.get(i).getsId());
			rinfo[i][1] = h.gethName();
			rinfo[i][2] = ci.getCname();
			rinfo[i][3] = ci.getCaddress();
			rinfo[i][4] = mo.getmName();
			rinfo[i][5] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sessionlist.get(i).getBeginTime());
			rinfo[i][6] = String.valueOf(sessionlist.get(i).getPrice());
			rinfo[i][7] = String.valueOf(sessionlist.get(i).getRemain());
		}
		// 加上影院地址
		String[] tbheadnames = { "场次编号", "场厅名称", "影院名称", "影院地址", "电影名称", "开始时间", "价格", "剩余座位数" };*/
		tb = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		tb.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"场次编号", "场厅名称", "影院名称","影院地址","电影名称","开始时间","价格","剩余座位数"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false,false,false,false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		fillsessiontable(sessionlist);
		r.setHorizontalAlignment(JLabel.CENTER);
		tb.setDefaultRenderer(Object.class, r);
		tb.setRowHeight(90);
		tb.setFont(font);
		/* tb.setEnabled(true); */
		tb.getTableHeader().setFont(new Font("楷体", 1, 20));
		tb.getTableHeader().setBackground(Color.orange);
		tb.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		tb.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		tb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				tablemousePressed(me);
			}
		});
		JScrollPane sPane = new JScrollPane(tb);
		jb.setBounds(0, 100, 1788, 795);
		sPane.setBounds(0, 100, 1800, 800);
		sPane.setVisible(true);
		search.setBounds(200, 60, 150, 60);
		search.setFont(font1);
		serchText.setBounds(400, 60, 250, 60);
		serchText.setFont(font1);
		serbtn.setBounds(700, 60, 200, 60);
		serbtn.setFont(font1);
		serbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				serachactionPerformed(e);
			}
		});
		jreturn.setBounds(980, 60, 250, 60);
		jreturn.setFont(font1);
		jreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				returnActionPerformed(e);
			}
		});
		//1400
		jBuyticket.setBounds(0, 60, 150, 60);
		jBuyticket.setFont(font1);
		jBuyticket.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buyActionPerformed(e);
			}
		});
		jb.add(sPane);
		p.add(serbtn);
		p.add(serchText);
		p.add(search);
		p.add(jreturn);
		p.add(jBuyticket);
		p.add(jb);

		con.add(p);
		con.setVisible(true);
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void serachactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("".equals(serchText.getText())) {
			JOptionPane.showMessageDialog(null, "请输入影院名字");
		}else {
			String cName=serchText.getText();
			List<Session> sesslist =new ArrayList<Session>();
			List<Cinema> cinemalist = cinema.queryCinemaByCinemaName(cName);
			if(cinemalist!=null) {
				for (Cinema cinema : cinemalist) {
					List<Session> sesslist1;
					sesslist1=seser.querySessionBycIdandmId(cinema.getCid(), this.mo.getmId());
					sesslist.addAll(sesslist1);
				}
			}
			sessionlist=sesslist;
			fillsessiontable(sessionlist);
		}
		
	}

	private void fillsessiontable(List<Session> sessionlist2) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=(DefaultTableModel) tb.getModel();
		dtm.setRowCount(0); // 设置成0行
		Hall h = new Hall();
		Cinema ci = new Cinema();
		int sessionRow=sessionlist2.size();
		for(int i=0;i<sessionRow;i++) {
			h = hall.queryHallById(sessionlist2.get(i).gethId());
			ci = cinema.queryCinemaById(sessionlist2.get(i).getcId());
			Vector v=new Vector();
			v.add(sessionlist2.get(i).getsId());
			v.add(h.gethName());
			v.add(ci.getCname());
			v.add(ci.getCaddress());
			v.add(mo.getmName());
			v.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sessionlist2.get(i).getBeginTime()));
			v.add(sessionlist2.get(i).getPrice());
			v.add(sessionlist2.get(i).getRemain());
			dtm.addRow(v);
		}
	}

	protected void returnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		new MovieUi(mo,ue);
		jf.dispose();
	}

	protected void buyActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(ue.toString());

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择电影场次");
		} else {
			Hall h1 = hall.queryHallById(sessionlist.get(row).gethId());
			
			new BuyTicketUi(ue, sessionlist.get(row), mo, h1);
			jf.dispose();
		}
	}

	protected void tablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		row = tb.getSelectedRow();

	}

	public static void main(String[] args) {

	}
}
