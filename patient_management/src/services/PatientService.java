package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Dtos.PatientDto;
import data.DbConnection;
import util.Mapper;

public class PatientService {
	
	private DbConnection connection;
	private Mapper mapper;
	
	public PatientService() {
		this.connection = new DbConnection();
		this.mapper = new Mapper();
	}
	
	public boolean saveNewPatient(HttpServletRequest httpServletRequest) {
		PatientDto dto = mapper.mapRequestToDto(httpServletRequest);
		String query = "insert into patients values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getEmail()+"','"+dto.getAddress()+"','"+dto.getTelNumber()+"','"+dto.getAge()+"')";
		try {
			return connection.queryProcess(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<PatientDto> getAllPatients(){
		List<PatientDto> dtos = new ArrayList<>();
		try {
			ResultSet resultSet = connection.getQueryResult("select * from patients");
			while(resultSet.next()) {
				PatientDto dto = new PatientDto();
				dto.setAddress(resultSet.getString("address"));
				dto.setAge(Integer.parseInt(resultSet.getString("age")));
				dto.setEmail(resultSet.getString("email"));
				dto.setId(resultSet.getString("id"));
				dto.setName(resultSet.getString("name"));
				dtos.add(dto);
			}
			return dtos;
		}catch(SQLException exception) {
			return null;
		}
		
	}
}
