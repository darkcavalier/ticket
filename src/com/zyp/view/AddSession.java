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
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.zyp.entity.Cinema;
import com.zyp.entity.Hall;
import com.zyp.entity.Session;
import com.zyp.service.CinemaService;
import com.zyp.service.HallService;
import com.zyp.service.MovieService;
import com.zyp.service.SessionService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.HallServiceImpl;
import com.zyp.service.impl.MovieServiceImpl;
import com.zyp.service.impl.SessionServiceImpl;

public class AddSession extends JInternalFrame {
	private JTable halltable;
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
	private JTable cinematable;

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
	public AddSession() {
		setIconifiable(true);
		setClosable(true);
		setTitle("添加场次");
		setBounds(100, 100, 1400, 900);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
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
		
		JButton btnNewButton = new JButton("添加场次");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addsessionactionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("电影院");
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_7 = new JLabel("场厅");
		lblNewLabel_7.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_8 = new JLabel("场次");
		lblNewLabel_8.setFont(new Font("楷体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(254)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED, 751, Short.MAX_VALUE)
					.addComponent(lblNewLabel_7)
					.addGap(297))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(269)
					.addComponent(lblNewLabel_8)
					.addContainerGap(1093, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(jmIdText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(9)
											.addComponent(jtimeText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(jremainText, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(jpriceText, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(135)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jcIdText, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(52)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jhallText, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(lblNewLabel_8)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(jcIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(jhallText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(jmIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(jpriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(jremainText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(jtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(65))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		cinematable = new JTable(){
			  public boolean isCellEditable( int row, int column) {
					return false;
				}

			};
			cinematable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"影院编号", "影院名", "影院地址"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(cinematable);
		cinemalist=cinemaservice.queryAllCinema();
		fillCinemaTable(cinemalist);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		cinematable.setDefaultRenderer(Object.class, r);
		cinematable.setRowHeight(70);
		cinematable.setFont(font);
		cinematable.getTableHeader().setFont(new Font("楷体", 1, 20));
		cinematable.getTableHeader().setBackground(Color.orange);
		cinematable.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		cinematable.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		cinematable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				cinematablemousePressed(me);
			}
		});
		halltable = new JTable(){
			  public boolean isCellEditable( int row, int column) {
					return false;
				}

			};
			halltable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"场厅编号", "场厅名", "影院编号","场厅容量"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			
		halllist=hallservice.queryAllHall();
		fillhalltableTable(halllist);
		r.setHorizontalAlignment(JLabel.CENTER);
		halltable.setDefaultRenderer(Object.class, r);
		halltable.setRowHeight(70);
		halltable.setFont(font);
		halltable.getTableHeader().setFont(new Font("楷体", 1, 20));
		halltable.getTableHeader().setBackground(Color.orange);
		halltable.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		halltable.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		halltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				halltablemousePressed(me);
			}
		});
		
		scrollPane_1.setViewportView(halltable);
		fillhalltableTable(halllist);
		
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
			sessiontable.setFont(new Font("楷体", 0, 10));
			sessiontable.getTableHeader().setFont(new Font("楷体", 1, 15));
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

	}
	protected void addsessionactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(judge()) {
			try {
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
							if(sessionservice.addSession(session)==1) {
								JOptionPane.showMessageDialog(null, "添加成功"); 
								reset();
							}else {
								JOptionPane.showMessageDialog(null, "添加失败"); 
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

	protected void cinematablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int cinemarow=-1;
		cinemarow=cinematable.getSelectedRow();
		if(cinemarow!=-1) {
			jcIdText.setText(String.valueOf(cinemalist.get(cinemarow).getCid()));
			halllist=hallservice.queryAllHallcId(cinemalist.get(cinemarow).getCid());
			fillhalltableTable(halllist);
		}
	}

	protected void sessiontablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int sessionrow=-1;
		sessionrow=sessiontable.getSelectedRow();
		if(sessionrow!=-1) {
			jtimeText.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sessionlist.get(sessionrow).getBeginTime()));
			jpriceText.setText(String.valueOf(sessionlist.get(sessionrow).getPrice()));
			jmIdText.setText(String.valueOf(sessionlist.get(sessionrow).getmId()));
		}
	}

	protected void halltablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int halrow=-1;
		halrow=halltable.getSelectedRow();
		if(halrow!=-1) {
			jhallText.setText(String.valueOf(halllist.get(halrow).gethId()));
			jremainText.setText(String.valueOf(halllist.get(halrow).getCapacity()));
			sessionlist=sessionservice.querySessionByHid(halllist.get(halrow).gethId());
			fillsessiontable(sessionlist);
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
	private void fillCinemaTable(List<Cinema> cinemalist2) {
		DefaultTableModel dtm=(DefaultTableModel) cinematable.getModel();
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
		DefaultTableModel dtm=(DefaultTableModel) halltable.getModel();
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
		
	}
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
