package com.example.demo51.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
	private String name;
	@Min(10)
	private int age;
	@Email (message = "넌 이메일 형식도 모르니?")
	private String email;
	private String phoneNumber;
	
}
