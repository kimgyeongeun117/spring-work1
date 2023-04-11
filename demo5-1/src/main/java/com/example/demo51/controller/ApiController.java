package com.example.demo51.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo51.dto.User;
/*import com.example.demo51.dto.User.MyBuilder;*/

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		if (user.getAge() < 1 || user.getAge() > 100) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}

//		User user2 = new MyBuilder().setAge(10).setEmail("@").setName("김").setPhoneNumber("010111").build();

		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	// 두번째 연습
	// AOP 기반인 Validation 라이브러리
	// 1. GET 방식일 때 사용 방법과 POST 방식일때 사용법이 약간 다르다.
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user) {

		// AOP 기반의 valid 라이브러리를 활용하면 공통적으로 들어가야
		// 하는 부분의 코드를 분리 시킬 수 있다.
		return ResponseEntity.ok(user);
	}

	// 와일드카드 -> ? 사용가능
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@Valid @RequestBody User user, BindingResult bindingResult) {

		// bindingResult 클래스를 배워 보자.
		// bindingResult가 @Valid에 대한 결과 값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			// 에러발생
			// 필드 - 어떤 필드에서 에러 발생
			// 메세지 - 내용을 반환 처리
			StringBuilder sb = new StringBuilder();
			
			
			bindingResult.getAllErrors().forEach(error->{
				
				System.out.println(error.getCode());
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getArguments());
				System.out.println(error.getObjectName());
				
				sb.append("field : "+error.getCode());
				sb.append("\n");
				sb.append("message : " +error.getDefaultMessage());
			});

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		// 정상처리

		return ResponseEntity.ok(user);
	}
}
