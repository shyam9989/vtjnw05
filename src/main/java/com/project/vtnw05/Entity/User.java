package com.project.vtnw05.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue
	int userId;
	String userName;
	String userPassword;
	String emailId;
	String gender;
	long mobileNumber;
	Date date;
	String userType;

}
