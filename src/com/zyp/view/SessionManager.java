package com.zyp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.zyp.entity.Cinema;
import com.zyp.entity.Hall;
import com.zyp.entity.Movie;
import com.zyp.entity.Session;
import com.zyp.entity.Ticket;
import com.zyp.service.CinemaService;
import com.zyp.service.HallService;
import com.zyp.service.MovieService;
import com.zyp.service.SessionService;
import com.zyp.service.TicketService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.HallServiceImpl;
import com.zyp.service.impl.MovieServiceImpl;
import com.zyp.service.impl.SessionServiceImpl;
import com.zyp.service.impl.TicketServiceImpl;

public class SessionManager extends JInternalFrame {
	private JTable sessiontable;
	private JTextField jcIdText;
	private JTextField jhallText;
	private JTextField jmIdText;
	private JTextField jpriceText;
	private JTextField jtimeText;
	private JTextField jremainText;
	private List<Cinema> cinemalist;
	private List<Hall> halllist;
	private List<Session> sessionlist;
	private Font font = new Font("楷体", 0, 20);
	private CinemaService cinemaservice=new CinemaServiceImpl();
	private HallService hallservice=new HallServiceImpl();
	private SessionService sessionservice=new SessionServiceImpl();
	private MovieService movieservice=new MovieServiceImpl();
	private JTextField jsIdtext;
	private JTextField sernametext;
	int sessionrow=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSession frame = new AddSession();
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
	public SessionManager() {
		setIconifiable(true);
		setClosable(true);
		setTitle("添加场次");
		setBounds(100, 100, 1409, 874);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("影院编号：");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jcIdText = new JTextField();
		jcIdText.setFont(new Font("楷体", Font.PLAIN, 20));
		jcIdText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("场厅编号:");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jhallText = new JTextField();
		jhallText.setFont(new Font("楷体", Font.PLAIN, 20));
		jhallText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("电影编号:");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jmIdText = new JTextField();
		jmIdText.setFont(new Font("楷体", Font.PLAIN, 20));
		jmIdText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("价格:");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jpriceText = new JTextField();
		jpriceText.setFont(new Font("楷体", Font.PLAIN, 20));
		jpriceText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("时间:");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jtimeText = new JTextField();
		jtimeText.setFont(new Font("楷体", Font.PLAIN, 20));
		jtimeText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("剩余座位：");
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 20));
		
		jremainText = new JTextField();
		jremainText.setFont(new Font("楷体", Font.PLAIN, 20));
		jremainText.setColumns(10);
		
		JButton btnNewButton = new JButton("修改场次");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addsessionactionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_8 = new JLabel("电影名");
		lblNewLabel_8.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("删除场次");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delactionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("场次编号");
		
		jsIdtext = new JTextField();
		jsIdtext.setEditable(false);
		jsIdtext.setFont(new Font("楷体", Font.PLAIN, 20));
		jsIdtext.setColumns(10);
		
		sernametext = new JTextField();
		sernametext.setFont(new Font("楷体", Font.PLAIN, 20));
		sernametext.setColumns(10);
		
		JButton serButton = new JButton("搜索");
		serButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchactionPerformed(e);
			}
		});
		serButton.setFont(new Font("楷体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jsIdtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jcIdText, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblNewLabel_1)
							.addGap(1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jtimeText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(jhallText, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jmIdText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(67)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jpriceText, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(117))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jremainText, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))))
					.addGap(118))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 1259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(405)
					.addComponent(lblNewLabel_8)
					.addGap(18)
					.addComponent(sernametext, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addGap(137)
					.addComponent(serButton)
					.addContainerGap(498, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(serButton))
					.addGap(39)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(jmIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(jpriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jhallText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_6)
						.addComponent(jsIdtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(jremainText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(95))
		);
		cinemalist=cinemaservice.queryAllCinema();
		/*fillCinemaTable(cinemalist);
		
			
		halllist=hallservice.queryAllHall();
		fillhalltableTable(halllist);
		r.setHorizontalAlignment(JLabel.CENTER);
		fillhalltableTable(halllist);*/
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		    sessiontable = new JTable(){
			  public boolean isCellEditable( int row, int column) {
					return false;
				}

			};
		
			sessiontable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"场次编号", "场厅编号", "影院编号","电影编号","开始时间","价格","剩余座位"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false,false,false,false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
			sessionlist=sessionservice.queryAllSession();
			fillsessiontable(sessionlist);
			r.setHorizontalAlignment(JLabel.CENTER);
			sessiontable.setDefaultRenderer(Object.class, r);
			sessiontable.setRowHeight(70);
			sessiontable.setFont(font);
			sessiontable.getTableHeader().setFont(new Font("楷体", 1, 20));
			sessiontable.getTableHeader().setBackground(Color.orange);
			sessiontable.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
			sessiontable.getTableHeader().setResizingAllowed(false); // 不可拉动表格
			
			sessiontable.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					sessiontablemousePressed(me);
				}
			});
		scrollPane_2.setViewportView(sessiontable);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);

	}
	protected void searchactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String mName=sernametext.getText();
		Movie movie=movieservice.queryMovieByName(mName);
		if(movie!=null) {
			sessionlist=sessionservice.querySessionBymId(movie.getmId());
			fillsessiontable(sessionlist);
		}
		
		
	}

	protected void delactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(sessionrow!=-1) {
		if(judge()) {
			try {
				int sId=Integer.parseInt(jsIdtext.getText());
				int hId=Integer.parseInt(jhallText.getText());
				int cId=Integer.parseInt(jcIdText.getText());
				int mId=Integer.parseInt(jmIdText.getText());
				String time=jtimeText.getText();
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				 
				 Date beginTime=sdf.parse(time);
				 double price=Double.parseDouble(jpriceText.getText());
				 int remain=Integer.parseInt(jremainText.getText());
				 
				 if(cinemaservice.queryCinemaById(cId)!=null) {
					 if(hallservice.queryHallById(hId)!=null) {
						 if(movieservice.queryMovieById(mId)!=null) {
							Session session=new Session(hId,cId,mId,beginTime,price,remain);
							TicketService ticketservice=new TicketServiceImpl();
						     List<Ticket> tlist=ticketservice.queryAllTicketsId(sId);
						     if(tlist.size()!=0) {
						    	 JOptionPane.showMessageDialog(null, "无法删除,此场次有用户购票"); 	
						     }else {
								if(sessionservice.delSession(sId)) {
									JOptionPane.showMessageDialog(null, "删除成功"); 
									sessionlist.remove(sessionrow);
									fillsessiontable(sessionlist);
								}else {
									JOptionPane.showMessageDialog(null, "删除失败"); 
								}
						     }
						 }else {
							 JOptionPane.showMessageDialog(null, "不存在此电影"); 
						 }
					 }else {
						 JOptionPane.showMessageDialog(null, "不存在此场厅"); 
					 }
				 }else {
					 JOptionPane.showMessageDialog(null, "不存在此影院厅"); 
				 }
				
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "输入格式错误");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "时间输入格式错误");
			}
		}
		}else {
			JOptionPane.showMessageDialog(null, "未选择场次");
		}
	}

	protected void addsessionactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(judge()) {
			try {
				int sId=Integer.parseInt(jsIdtext.getText());
				int hId=Integer.parseInt(jhallText.getText());
				int cId=Integer.parseInt(jcIdText.getText());
				int mId=Integer.parseInt(jmIdText.getText());
				String time=jtimeText.getText();
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				 
				 Date beginTime=sdf.parse(time);
				 double price=Double.parseDouble(jpriceText.getText());
				 int remain=Integer.parseInt(jremainText.getText());
				 if(cinemaservice.queryCinemaById(cId)!=null) {
					 if(hallservice.queryHallById(hId)!=null) {
						 if(movieservice.queryMovieById(mId)!=null) {
							Session session=new Session(sId,hId,cId,mId,beginTime,price,remain);
						
								if(sessionservice.updateSession(session)) {
									JOptionPane.showMessageDialog(null, "修改成功"); 
									
								}else {
									JOptionPane.showMessageDialog(null, "修改失败"); 
								}
						 }else {
							 JOptionPane.showMessageDialog(null, "不存在此电影"); 
						 }
					 }else {
						 JOptionPane.showMessageDialog(null, "不存在此场厅"); 
					 }
				 }else {
					 JOptionPane.showMessageDialog(null, "不存在此影院厅"); 
				 }
				
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "输入格式错误");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "时间输入格式错误");
			}
		}
	}

	protected void sessiontablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
		sessionrow=sessiontable.getSelectedRow();
		if(sessionrow!=-1) {
			jtimeText.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sessionlist.get(sessionrow).getBeginTime()));
			jpriceText.setText(String.valueOf(sessionlist.get(sessionrow).getPrice()));
			jmIdText.setText(String.valueOf(sessionlist.get(sessionrow).getmId()));
			jsIdtext.setText(String.valueOf(sessionlist.get(sessionrow).getsId()));
			jcIdText.setText(String.valueOf(sessionlist.get(sessionrow).getcId()));
			jremainText.setText(String.valueOf(sessionlist.get(sessionrow).getRemain()));
			jhallText.setText(String.valueOf(sessionlist.get(sessionrow).gethId()));
			
		}
	}
    private void fillsessiontable(List<Session> sessionlist2) {
    	DefaultTableModel dtm=(DefaultTableModel) sessiontable.getModel();
		dtm.setRowCount(0); // 设置成0行
		int sessionRow=sessionlist2.size();
		for(int i=0;i<sessionRow;i++) {
			
			Vector v=new Vector();
			v.add(sessionlist2.get(i).getsId());
			v.add(sessionlist2.get(i).gethId());
			v.add(sessionlist2.get(i).getcId());
			v.add(sessionlist2.get(i).getmId());
			v.add(sessionlist2.get(i).getBeginTime());
			v.add(sessionlist2.get(i).getPrice());
			v.add(sessionlist2.get(i).getRemain());
			dtm.addRow(v);
		}
    }
	/*private void fillCinemaTable(List<Cinema> cinemalist2) {
		dtm.setRowCount(0); // 设置成0行
		int cinemaRow= cinemalist2.size();
		for(int i=0;i<cinemaRow;i++) {
			Vector v=new Vector();
			v.add(cinemalist2.get(i).getCid());
			v.add(cinemalist2.get(i).getCname());
			v.add(cinemalist2.get(i).getCaddress());
		
			dtm.addRow(v);
		}
		
	}
	private void fillhalltableTable(List<Hall> halllist2) {
		dtm.setRowCount(0); // 设置成0行
		int hallRow=halllist2.size();
		for(int i=0;i<hallRow;i++) {
			Vector v=new Vector();
			v.add(halllist2.get(i).gethId());
			v.add(halllist2.get(i).gethName());			
			v.add(halllist2.get(i).getcId());
			v.add(halllist2.get(i).getCapacity());		
			dtm.addRow(v);
		}
		
	}*/
	public boolean judge() {
		if("".equals(jcIdText.getText())) {
			JOptionPane.showMessageDialog(null, "影院编号不能为空");
			return false;
		}
		if("".equals(jhallText.getText())) {
			JOptionPane.showMessageDialog(null, "场厅编号不能为空");
			return false;
		}
		if("".equals(jmIdText.getText())) {
			JOptionPane.showMessageDialog(null, "电影编号不能为空");
			return false;
		}
		if("".equals(jpriceText.getText())) {
			JOptionPane.showMessageDialog(null, "电影价格不能为空");
			return false;
		}
		if("".equals(jtimeText.getText())) {
			JOptionPane.showMessageDialog(null, "场次时间不能为空");
			return false;
		}
		if("".equals(jremainText.getText())) {
			JOptionPane.showMessageDialog(null, "剩余座位不能为空");
			return false;
		}
		return true;
	}
	public void reset() {
		jcIdText.setText("");
		jhallText.setText("");
		jmIdText.setText("");
		jpriceText.setText("");
		jtimeText.setText("");
		jremainText.setText("");
		
	}
}