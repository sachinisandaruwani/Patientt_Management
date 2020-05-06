package util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import Dtos.PatientDto;

public class Mapper {
	
	public PatientDto mapRequestToDto(HttpServletRequest httpRequest) {
		PatientDto dto = new PatientDto();
		dto.setAddress(httpRequest.getParameter("address"));
		dto.setAge(Integer.parseInt(httpRequest.getParameter("age")));
		dto.setEmail(httpRequest.getParameter("email"));
		dto.setId(UUID.randomUUID().toString());
		dto.setName(httpRequest.getParameter("name"));
		dto.setTelNumber(httpRequest.getParameter("telNumber"));
		return dto;
	}
}
