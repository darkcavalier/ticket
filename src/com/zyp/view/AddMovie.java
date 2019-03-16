package com.zyp.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.zyp.entity.Movie;
import com.zyp.service.MovieService;
import com.zyp.service.impl.MovieServiceImpl;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddMovie extends JInternalFrame {
	private JTextField movieNameText;
	private JTextField movielangText;
	private JTextField movieLoaText;
	private JTextField picaddressText;
	private JTextField timeText;
	private JTextField scoreText;
	private JTextArea detailtextArea;
	private JComboBox movietypeBox;
	private MovieService movieservice=new MovieServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie frame = new AddMovie();
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
	public AddMovie() {
		setIconifiable(true);
		setClosable(true);
		setTitle("添加电影");
		setBounds(50, 50, 1239, 737);
		
		JLabel movieNameLabel = new JLabel("电影名字:");
		movieNameLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		movieNameText = new JTextField();
		movieNameText.setFont(new Font("楷体", Font.PLAIN, 20));
		movieNameText.setColumns(10);
		
		JLabel movielanglabel = new JLabel("语言:");
		movielanglabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		movielangText = new JTextField();
		movielangText.setFont(new Font("楷体", Font.PLAIN, 20));
		movielangText.setColumns(10);
		
		JLabel movieLoaLabel = new JLabel("地区：");
		movieLoaLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		movieLoaText = new JTextField();
		movieLoaText.setFont(new Font("楷体", Font.PLAIN, 20));
		movieLoaText.setColumns(10);
		
		JLabel picaddressLabel = new JLabel("海报地址:");
		picaddressLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		picaddressText = new JTextField();
		picaddressText.setFont(new Font("楷体", Font.PLAIN, 20));
		picaddressText.setColumns(10);
		
		JLabel timeLabel = new JLabel("时长:");
		timeLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		timeText = new JTextField();
		timeText.setFont(new Font("楷体", Font.PLAIN, 20));
		timeText.setColumns(10);
		
		JLabel movietypeLabel = new JLabel("类型:");
		movietypeLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		 movietypeBox = new JComboBox();
		 movietypeBox.setFont(new Font("楷体", Font.PLAIN, 20));
		 movietypeBox.addItem("科幻");
		 movietypeBox.addItem("动作");
		 movietypeBox.addItem("爱情");
		 movietypeBox.addItem("剧情");
		 movietypeBox.addItem("动漫");
		JLabel scoreLabel = new JLabel("分数:");
		scoreLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		
		scoreText = new JTextField();
		scoreText.setFont(new Font("楷体", Font.PLAIN, 20));
		scoreText.setColumns(10);
		
		 detailtextArea = new JTextArea();
		 detailtextArea.setFont(new Font("楷体", Font.PLAIN, 20));
		 detailtextArea.setLineWrap(true);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		cancelButton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addactionPerformed(e);
			}
		});
		addButton.setFont(new Font("楷体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(picaddressLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieNameLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(picaddressText)
						.addComponent(movieNameText, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(movielanglabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(movielangText, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(movieLoaLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(timeText, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(movietypeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(movietypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scoreLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scoreText, 0, 0, Short.MAX_VALUE))
						.addComponent(movieLoaText, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(242, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(299)
					.addComponent(detailtextArea, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(309, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(412)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(157)
					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(466, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(movieNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movielanglabel)
						.addComponent(movielangText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieLoaLabel)
						.addComponent(movieLoaText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieNameLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(picaddressLabel)
						.addComponent(picaddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeLabel)
						.addComponent(timeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movietypeLabel)
						.addComponent(movietypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scoreLabel)
						.addComponent(scoreText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addComponent(detailtextArea, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton)
						.addComponent(addButton))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);
	}

	protected void cancelActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

	protected void addactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String movieName=movieNameText.getText();
		String movielang=movielangText.getText();
		String movieloa=movieLoaText.getText();
		String picaddress=picaddressText.getText();
		String time=timeText.getText();
		String score=scoreText.getText();
		String detail=detailtextArea.getText();
		String mType=(String)movietypeBox.getSelectedItem();
		
		if(judge()) {	
		try {
			System.out.println(mType);
			int mtime=Integer.parseInt(time) ;
			double mscore=Double.parseDouble(score);
			Movie movie=new Movie(movieName,movielang,movieloa,picaddress,detail,mtime,mType,mscore);
			if(movieservice.addMovie(movie)==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				reset();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			
			
		} catch (NumberFormatException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "格式错误");
		}
		}
	}
	public boolean judge() {
		if("".equals(movieNameText.getText())) {
			JOptionPane.showMessageDialog(null, "电影名字不能为空");
			return false;
		}
		if("".equals(movielangText.getText())) {
			JOptionPane.showMessageDialog(null, "电影名字不能为空");
			return false;
		}
		if("".equals(movieLoaText.getText())) {
			JOptionPane.showMessageDialog(null, "电影地址不能为空");
			return false;
		}
		if("".equals(picaddressText.getText())) {
			JOptionPane.showMessageDialog(null, "海报地址不能为空");
			return false;
		}
		if("".equals(timeText.getText())) {
			JOptionPane.showMessageDialog(null, "电影时长不能为空");
			return false;
		}
		if("".equals(scoreText.getText())) {
			JOptionPane.showMessageDialog(null, "评分不能为空");
			return false;
		}
		if("".equals(detailtextArea.getText())) {
			JOptionPane.showMessageDialog(null, "评分不能为空");
			return false;
		}
		return true;
	}
	public void reset() {
		movieNameText.setText("");
		movielangText.setText("");
		movieLoaText.setText("");
		picaddressText.setText("");
		timeText.setText("");
		scoreText.setText("");
		detailtextArea.setText("");
	}
}
