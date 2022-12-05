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
public class TeacherController {
	
	@GetMapping("/GetTeachers")
	public String getTeachers(Model model) {
		
		List<Teacher> t1=new ArrayList<>();
		Connection con= DatabaseConnection2.getConnection();
		String query = "select * from teacher";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Teacher t2=new Teacher();
				
				t2.setAge(resultSet.getInt(1));
				t2.setFname(resultSet.getString(2));
				t2.setLname(resultSet.getString(3));
			
				t1.add(t2);
			}

		}
		catch (SQLException e) {

			e.printStackTrace();


		}
		
		Teacher t2=new Teacher();
		t2.setAge(24);
		t2.setFname("kotholla");
		t2.setLname("vinthi");
		t1.add(t2);
		model.addAttribute("Teachers", t1);
		
		return "Teacher";
		
	}

}
