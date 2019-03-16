package com.zyp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import com.zyp.service.CinemaService;
import com.zyp.service.HallService;
import com.zyp.service.SessionService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.HallServiceImpl;
import com.zyp.service.impl.SessionServiceImpl;

public class HallManage extends JInternalFrame {
	private JTable cinematable;
	private JTable halltable;
	private JTextField hallnametext;
	private JTextField cIdtext;
	private JTextField capacitytext;
    private List<Cinema> cinemalist;
    private List<Hall> halllist;
    private Font font = new Font("楷体", 0, 20);
    private CinemaService cinemaservice=new CinemaServiceImpl();
    private HallService hallservice=new HallServiceImpl();
    private SessionService sessionservice=new SessionServiceImpl();
    private int halrow=-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HallManage frame = new HallManage();
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
	public HallManage() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 1200, 900);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("大厅名字:");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		hallnametext = new JTextField();
		hallnametext.setFont(new Font("楷体", Font.PLAIN, 20));
		hallnametext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("影院编号:");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		
		cIdtext = new JTextField();
		cIdtext.setFont(new Font("楷体", Font.PLAIN, 20));
		cIdtext.setEditable(false);
		cIdtext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("场厅容量:");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		
		capacitytext = new JTextField();
		capacitytext.setFont(new Font("楷体", Font.PLAIN, 20));
		capacitytext.setColumns(10);
		
		JButton addhallButton = new JButton("添加场厅");
		addhallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addactionPerformed(e);
			}
		});
		addhallButton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton updatehallButton = new JButton("修改场厅");
		updatehallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateactionPerformed(e);
			}
		});
		updatehallButton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton delhallButton = new JButton("删除场厅");
		delhallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delactionPerformed(e);
			}
		});
		delhallButton.setFont(new Font("楷体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addGap(121)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(268)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hallnametext, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cIdtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(capacitytext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(290)
							.addComponent(addhallButton)
							.addGap(112)
							.addComponent(updatehallButton)
							.addGap(120)
							.addComponent(delhallButton)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane_1, Alignment.LEADING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(hallnametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(cIdtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(capacitytext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addhallButton)
						.addComponent(updatehallButton)
						.addComponent(delhallButton))
					.addContainerGap(155, Short.MAX_VALUE))
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
			cinemalist=cinemaservice.queryAllCinema();
			fillCinemaTable(cinemalist);
		scrollPane.setViewportView(cinematable);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		cinematable.setDefaultRenderer(Object.class, r);
		cinematable.setRowHeight(70);
		cinematable.setFont(font);
		cinematable.getTableHeader().setFont(new Font("楷体", 1, 20));
		cinematable.getTableHeader().setBackground(Color.orange);
		cinematable.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
		cinematable.getTableHeader().setResizingAllowed(false);
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
		getContentPane().setLayout(groupLayout);

	}

	protected void delactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(judge()) {
			try {
				int cId=Integer.parseInt(cIdtext.getText());
				int capacity=Integer.parseInt(capacitytext.getText());
				String hName=hallnametext.getText();
				if(halrow!=-1) {
					halllist.get(halrow).setCapacity(capacity);
					halllist.get(halrow).setcId(cId);
					if(cinemaservice.queryCinemaById(cId)!=null) {
						if(sessionservice.querySessionByHid(halllist.get(halrow).gethId()).size()==0) {
						halllist.get(halrow).sethName(hName);
						if(hallservice.delHall(halllist.get(halrow).gethId())) {
							JOptionPane.showMessageDialog(null, "删除成功");
							halllist.remove(halrow);
							fillhalltableTable(halllist);
						}
						}else {
							JOptionPane.showMessageDialog(null, "该场厅有场次，无法删除");
						}
					}else {
						JOptionPane.showMessageDialog(null, "不存在此影院");
					}
					
				}
				
			}catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "格式错误");
			}
		}
	}

	protected void updateactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(judge()) {
			try {
				int cId=Integer.parseInt(cIdtext.getText());
				int capacity=Integer.parseInt(capacitytext.getText());
				String hName=hallnametext.getText();
				if(halrow!=-1) {
					halllist.get(halrow).setCapacity(capacity);
					halllist.get(halrow).setcId(cId);
					if(cinemaservice.queryCinemaById(cId)!=null) {
						halllist.get(halrow).sethName(hName);
						if(hallservice.updateHall(halllist.get(halrow))) {
							JOptionPane.showMessageDialog(null, "修改成功");
							fillhalltableTable(halllist);
						}
					}else {
						JOptionPane.showMessageDialog(null, "不存在此影院");
					}
					
				}
				
			}catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "格式错误");
			}
			}
	}

	protected void addactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(judge()) {
			try {
				int cId=Integer.parseInt(cIdtext.getText());
				int capacity=Integer.parseInt(capacitytext.getText());
				String cName=hallnametext.getText();
				
				Hall hall=new Hall(cName,cId,capacity);
				int judge=hallservice.addHall(hall);
				if(judge==1) {
					JOptionPane.showMessageDialog(null, "添加场厅成功");
					halllist=hallservice.queryAllHallcId(cId);
					
					fillhalltableTable(halllist);
				}else if(judge==2) {
					JOptionPane.showMessageDialog(null, "添加场厅失败");
				}else {
					JOptionPane.showMessageDialog(null, "已存在此场厅");
				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "输入格式错误");
			}
		}
		
	}

	protected void halltablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
		halrow=halltable.getSelectedRow();
		if(halrow!=-1) {
			hallnametext.setText(halllist.get(halrow).gethName());
			capacitytext.setText(String.valueOf(halllist.get(halrow).getCapacity()));
		}
	}

	private void fillhalltableTable(List<Hall> halllist2) {
		// TODO Auto-generated method stub
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

	protected void cinematablemousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int cinemarow=-1;
		cinemarow=cinematable.getSelectedRow();
		if(cinemarow!=-1) {
			cIdtext.setText(String.valueOf(cinemalist.get(cinemarow).getCid()));
			halllist=hallservice.queryAllHallcId(cinemalist.get(cinemarow).getCid());
			fillhalltableTable(halllist);
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
	public boolean judge() {
		if("".equals(hallnametext.getText())) {
			JOptionPane.showMessageDialog(null, "场厅名不能为空");
			return false;
		}
		if("".equals(cIdtext.getText())) {
			JOptionPane.showMessageDialog(null, "影院编号不能为空");
			return false;
		}
		if("".equals(capacitytext.getText())) {
			JOptionPane.showMessageDialog(null, "场厅容量不能为空");
			return false;
		}
		return true;
	}

}
