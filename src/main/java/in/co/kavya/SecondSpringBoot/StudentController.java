package in.co.kavya.SecondSpringBoot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StudentController {
	
	@GetMapping("/GetStudents")
	public String getStudents(Model model) {
		
		
		List<Student> s1=new ArrayList<>();
		Connection con= DatabaseConnection.getConnection();
		String query = "select * from student";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Student s2=new Student();
				s2.setId(resultSet.getInt(1));
				
				s2.setFname(resultSet.getString(2));
				s2.setLname(resultSet.getString(3));
				s2.setAge(resultSet.getInt(4));
				s1.add(s2);
			}

		}
		catch (SQLException e) {

			e.printStackTrace();


		}
		
		
		
		Student s2=new Student();
		s2.setAge(34);
		s2.setId(24);
		s2.setFname("mamilla");
		s2.setLname("kavya");
		s1.add(s2);
		
		
		model.addAttribute("Students", s1);
		return "Students";
		
	}
	
	

}
