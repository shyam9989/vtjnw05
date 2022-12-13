package com.project.vtnw05.DTO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	
	int userId;
	@NotBlank(message="UserName cannot be empty")
	String userName;
	@NotBlank(message="Password cannot be empty")
	String userPassword;
	@NotBlank(message="Emailid cannot be empty")
	String emailId;
	String gender;
	long mobileNumber;
	Date date;
	String userType;

}
