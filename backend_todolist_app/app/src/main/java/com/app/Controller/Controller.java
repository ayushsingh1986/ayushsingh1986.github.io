package com.app.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Schedule;
import com.app.model.ScheduleAPI;
@Service
@RestController
@RequestMapping(value = "/greeting", method = {RequestMethod.GET, RequestMethod.POST})
public class Controller {

@CrossOrigin(origins = "http://localhost:3000")
   // @CrossOrigin(origins = "http://localhost:8081")

	//Ayush's code
	@GetMapping("/greeting")
//@Autowired
	
	
	@PostMapping("/greeting")
	public ArrayList<Schedule> greeting(@RequestBody ScheduleAPI body) {
		
		switch (getAction()) {
		case 1:
			System.err.print("Requested batch -- ");
			if (body.getChanged().size() > 0) {
				System.err.println("change");
				updateSchedules(body.getChanged());
			}
			if (body.getDeleted().size() > 0) {
				System.err.println("delete");
				deleteSchedules(body.getDeleted());
			}
			if (body.getAdded().size() > 0) {
				System.err.println("add");
				addSchedules(body.getAdded());
			}
			break;
		case 0:
			System.err.println("Requested read");
			ArrayList<Schedule> schedules = getSchedule(body.getStartDate(), body.getEndDate());
			return schedules;
		default:
			break;
		}
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		return schedules;
	}

	private int getAction() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void addSchedules(ArrayList<Schedule> added) {
		// TODO Auto-generated method stub
//Ayush's code
		// TODO Auto-generated method stub
				System.err.println("This schedule has been added --> ");
				System.err.println("Id -> "+ added.get(0).getId());
				System.err.println("Subject -> "+ added.get(0).getSubject());
				System.err.println("End time -> "+ added.get(0).getEndTime());
				System.err.println("Start time -> "+ added.get(0).getStartTime());
				// Need to execute query --> 
				// update schedule set actintobeperformed = 'changed.get(0).getSubject()' where id = changed.get(0).getId()
			}
	

	private void deleteSchedules(ArrayList<Schedule> deleted) {
		// TODO Auto-generated method stub
		//Ayush's code
		// TODO Auto-generated method stub
				System.err.println("This schedule has been deleted --> ");
				System.err.println("Id -> "+ deleted.get(0).getId());
				System.err.println("Subject -> "+ deleted.get(0).getSubject());
				System.err.println("End time -> "+ deleted.get(0).getEndTime());
				System.err.println("Start time -> "+ deleted.get(0).getStartTime());
				// Need to execute query --> 
				// update schedule set actintobeperformed = 'changed.get(0).getSubject()' where id = changed.get(0).getId()
			}

	

	private void updateSchedules(ArrayList<Schedule> changed) {
		// TODO Auto-generated method stub
		System.err.println("This schedule has changed --> ");
		System.err.println("Id -> "+ changed.get(0).getId());
		System.err.println("Subject -> "+ changed.get(0).getSubject());
		System.err.println("End time -> "+ changed.get(0).getEndTime());
		System.err.println("Start time -> "+ changed.get(0).getStartTime());
		// Need to execute query --> 
		// update schedule set actintobeperformed = 'changed.get(0).getSubject()' where id = changed.get(0).getId()
	}

	private ArrayList<Schedule> getSchedule(String StartDate, String EndDate) {
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "3");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from activity_ where start_time>=cast ('" + StartDate
					+ "' as timestamp) and end_time <=cast ('" + EndDate + "' as timestamp);");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("actiontobeperformed");
				Date startdate = rs.getDate("start_time");
				Date enddate = rs.getDate("end_time");
				schedules.add(new Schedule(id, name, startdate, enddate, true));
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return schedules;
	}

}
