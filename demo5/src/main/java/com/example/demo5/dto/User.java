package com.example.demo5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
	private String name;
	private int age;
	private String email;
	private String phoneNumber;
	
}
