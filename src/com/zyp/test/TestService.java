package com.zyp.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.zyp.entity.Cinema;
import com.zyp.entity.Movie;
import com.zyp.entity.Ticket;
import com.zyp.entity.User;
import com.zyp.service.CinemaService;
import com.zyp.service.MovieService;
import com.zyp.service.TicketService;
import com.zyp.service.UserService;
import com.zyp.service.impl.CinemaServiceImpl;
import com.zyp.service.impl.MovieServiceImpl;
import com.zyp.service.impl.TicketServiceImpl;
import com.zyp.service.impl.UserServiceImpl;

class TestService {

	@Test
	void test() {
		Cinema cinema=new Cinema("恒大绿洲影城","南京");
		CinemaService c=new CinemaServiceImpl();
		int a=c.addCinema(cinema);
		if(a==1) {
			System.out.println("添加成功");
		}else if(a==2) {
			System.out.println("添加失败");
		}else {
			System.out.println("重复");
		}
	}
	@Test
	void test1() {
		User user=new User("zyp","123",0);
		UserService u=new UserServiceImpl();
	 user=u.login(user);
	 System.out.println(user.toString());
		
	}
	@Test
	void test2() {
		UserService u=new UserServiceImpl();
		User user=new User("zyp","111",0);
		int i=u.register(user);
		System.out.println(i);
	}
	//修改密码
	@Test
	void test3() {
		UserService u=new UserServiceImpl();
		User user=new User("zyp","111",0);
		u.updateUserPass(user, "156");
	}
	//
	@Test//所有电影
	void test4() {
		MovieService m=new MovieServiceImpl();
		List<Movie>list=m.queryAllMovie();
		for (Movie movie : list) {
			System.out.println(movie.toString());
		}
	}
	@Test//所有电影
	void test5() {
		MovieService m=new MovieServiceImpl();
		Movie mo=m.queryMovieById(1);
		System.out.println(mo.toString());
	}
	@Test//所有电影
	void test6() {
		MovieService m=new MovieServiceImpl();
		Movie mo=new Movie("df","yi","gg","sg","sdg",200,"gd",8.3);
		System.out.println(m.addMovie(mo));
	}
	@Test
	void test7() {
		CinemaService cinemaService=new CinemaServiceImpl();
		List<Cinema> list=cinemaService.queryCinemaByCinemaName("影");
		for (Cinema cinema : list) {
			System.out.println(cinema.toString());
		}
	}
	@Test
	void test8() {
		CinemaService cinemaService=new CinemaServiceImpl();
		List<Cinema> list=cinemaService.queryCinemaByCinemaNameAndCinemaAddress("影", "南");
		for (Cinema cinema : list) {
			System.out.println(cinema.toString());
		}
	}
	@Test
	void test9() {
		  
		TicketService ticketservice=new TicketServiceImpl();
	     List<Ticket> tlist=ticketservice.queryAllTicketsId(20);
	     if(tlist==null) {
	    	 System.out.println("无");
	     }else {
	    	 System.out.println("有");
	    	 for (Ticket ticket : tlist) {
				System.out.println(ticket.toString());
			}
	     }
	}
}
