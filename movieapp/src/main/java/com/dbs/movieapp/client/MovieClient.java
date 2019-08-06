package com.dbs.movieapp.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dbs.movieapp.controller.MovieController;
import com.dbs.movieapp.model.Movie;

public class MovieClient {

	private static  MovieController movieController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        movieController = applicationContext.getBean(MovieController.class);
        Scanner sc=new Scanner(System.in);
        int flag=1;
        while(flag==1) {
        	System.out.println("--------------------------");
            System.out.println("Enter Option:\n1.Insert Movie\n2.Show all Movies"
            		+ "\n3.Find Movie By Id\n4.Delete Movie\n5.Exit");
        	int option=sc.nextInt();
        	switch(option) {
        		case 1:saveMovies();
        				break;
        		case 2:findAllMovies();
        				break;
        		case 3:findMovieById();
        				break;
        		case 4:deleteMovie();
        				break;
        		case 5:System.out.println("Exiting....");
        				flag=0;
        				break;
        		default:System.out.println("Enter only 1-5 as option");     	
        	}
        }
        //saveMovies();
       // listAllEmployees();
        //fetchEmployeeDetailsById(12);
    }

	private static void deleteMovie() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Enter Movie Id");
        long id=sc.nextInt();
        movieController.deleteMovie(id);
	}

	private static void findMovieById() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Enter Movie Id");
        int id=sc.nextInt();
        Movie m=movieController.findById(id);
        if(m!=null)
        	System.out.println(m);
	}

	private static void findAllMovies() {
		List<Movie> result=movieController.listAll();
		System.out.println("----------------------------\nMovies are");
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}

	private static void saveMovies() {
		//Movie movie = new Movie(12,"Endgame", 9,200);
//        movieController.saveMovie(movie);
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Enter Movie Details");
        System.out.print("Enter ID :");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name :");
        String name=sc.nextLine();
        System.out.print("Enter Rating :");
        int rating=sc.nextInt();
        System.out.print("Enter Duration(in min) : ");
        int duration=sc.nextInt();
        Movie movie=new Movie(id,name,rating,duration);
        movieController.saveMovie(movie);
	}
}
