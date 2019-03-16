package com.zyp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.zyp.dao.CinemaDao;
import com.zyp.dao.CommentDao;
import com.zyp.dao.HallDao;
import com.zyp.dao.MovieDao;
import com.zyp.dao.SessionDao;
import com.zyp.dao.TicketDao;
import com.zyp.dao.UserDao;
import com.zyp.dao.impl.CinemaDaoImpl;
import com.zyp.dao.impl.CommentDaoImpl;
import com.zyp.dao.impl.HallDaoImpl;
import com.zyp.dao.impl.MovieDaoImpl;
import com.zyp.dao.impl.SessionDaoImpl;
import com.zyp.dao.impl.TicketDaoImpl;
import com.zyp.dao.impl.UserDaoImpl;
import com.zyp.entity.Cinema;
import com.zyp.entity.Comment;
import com.zyp.entity.Hall;
import com.zyp.entity.Movie;
import com.zyp.entity.Session;
import com.zyp.entity.Ticket;
import com.zyp.entity.User;

class TestDao {
   //影城添加
	@Test
	void test() {
		Cinema cinema=new Cinema("恒大绿洲影城","恒大");
		CinemaDao cinemadao=new CinemaDaoImpl ();
		cinemadao.addCinema(cinema);
		Cinema cinema2=new Cinema("国际影城","南大");
		CinemaDao cinemadao2=new CinemaDaoImpl ();
		cinemadao.addCinema(cinema2);
	}
	//影城删除
	@Test
	void test1() {
		CinemaDao cinemadao=new CinemaDaoImpl();
		cinemadao.delCinema(2);
	}
    //影城修改
	@Test
	void test2() {
		CinemaDao cinemaDao=new CinemaDaoImpl() ;
		Cinema cinema2=new Cinema(3,"上海国际影城","南大");
		cinemaDao.updateCinema(cinema2);
	
	}
	//展示所有影城
	@Test
	void test3() {
		CinemaDao cinemaDao=new CinemaDaoImpl() ;
		List<Cinema> list=cinemaDao.queryAllCinema();
		for (Cinema cinema : list) {
			System.out.println(cinema.toString());
		}
	}
	@Test
	void test4() {
		User u=new User("zyp","123",0);
		UserDao userDao=new UserDaoImpl();
		User u2=userDao.queryUser(u);
		System.out.println(u2.toString());
		
	}
	@Test
	void test5() {
		User u1=new User("zsg","111",0);
		UserDao userDao=new UserDaoImpl();
		System.out.println(userDao.addUser(u1));
		
	}
	@Test
	void test6() {
		MovieDao m=new  MovieDaoImpl();
		List<Movie> list=m.queryAllMovie();
		for (Movie movie : list) {
			System.out.println(movie.toString());
		}
		
	}
	@Test
	void test7() {
		SessionDao session=new SessionDaoImpl();
		
		List<Session> list=session.querySessionByMid(1);
		for (Session session2 : list) {
			System.out.println(session2.toString());
		}
		
	}
	@Test
	void test8() {
		MovieDao m=new MovieDaoImpl();
		String s="科幻";
		List<Movie>list= m.queryMovieByType(s);
		for (Movie movie : list) {
			System.out.println(movie.toString());
		}
	}
	@Test
	void test10() {
		SessionDao session=new SessionDaoImpl();
		
		Session s=new Session(1);
		s=session.querySessionById(1);
		System.out.println(s.toString());
		
	}
	@Test
	void test11() {
		MovieDao m=new MovieDaoImpl();
		
		
		System.out.println(m.queryMovieById(1).toString());
		
	}
	@Test //场厅
	void test12() {
	  HallDao ha=new HallDaoImpl();
	  Hall h=ha.queryHallById(1);
	  System.out.println(h.toString());
		
	}
	@Test //场厅
	void test13() {
	  CinemaDao cin=new CinemaDaoImpl();
	  System.out.println(cin.queryCinemaById(1).toString());
		
	}
	@Test //评论
	void test14() {
	  CommentDao commentDao=new CommentDaoImpl();
	 
	  SimpleDateFormat format=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  Date date=new Date();
	  try {
		date=format.parse("2018-08-02 12:22:11");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Comment comment=new Comment(1,1,"我喜欢看",date);
	  commentDao.addComment(comment);
		
	}
	@Test //评论
	void test15() {
		CommentDao commentDao=new CommentDaoImpl();
		List<Comment> list=commentDao.queryAllCommentBymId(1);
		for (Comment comment : list) {
			System.out.println(comment.toString());
		}
	}
	@Test
	void test16() {
		UserDao userDao=new UserDaoImpl();
		System.out.println(userDao.queryUserByid(1).toString());
	}
	@Test
	void test17() {
		CommentDao commentDao=new CommentDaoImpl();
		Comment comment=new Comment(1, 3);
		System.out.println(commentDao.queryComment(comment).toString());
	}
	@Test
	void test18() {
		MovieDao moviedao=new MovieDaoImpl();
		List<Movie> list=moviedao.queryMovieBymovieName("号");
		for (Movie movie : list) {
			System.out.println(movie.toString());
		}
	}
	@Test
	void test19() {
		MovieDao moviedao=new MovieDaoImpl();
		Movie mo=new Movie(13,"1","2","3","4","5",6,"7",8);
		moviedao.updateMovie(mo);
	}
	@Test
	void test20() {
		MovieDao moviedao=new MovieDaoImpl();
		List<Movie> list=moviedao.queryMovieByTypeandName("爱情", "泰");
		for (Movie movie : list) {
			System.out.println(movie.toString());
		}
		
	}
	@Test
	void test21() {
		HallDao halldao=new HallDaoImpl();
		List<Hall> list=halldao.queryAllHallcId(1);
		for (Hall hall : list) {
			System.out.println(hall.toString());
		}
	}
	@Test
	void test22() {
		UserDao userdao=new UserDaoImpl();
		User user=userdao.queryUser(new User("xxx","123",1));
		if(user==null) {
			System.out.println("无");
		}else {
			System.out.println("有");
		}
		
	}

  @Test
void test23() {
	SessionDao sessiondao=new SessionDaoImpl();
	List<Session> list=sessiondao.querySessionBycIdandmId(1, 1);
	for (Session session : list) {
		System.out.println(session.toString());
	}
	
}
  @Test
  void test24() {
	  TicketDao ticketDao=new TicketDaoImpl();
	 
	  if(ticketDao.queryAllTicketsId(100)==null) {
		  System.out.println("无");
	  }else {
		  
		  System.out.println("有");
	  }
  }
}
