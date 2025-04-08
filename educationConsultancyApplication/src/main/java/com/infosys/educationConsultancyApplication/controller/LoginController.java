////package com.infosys.educationConsultancyApplication.controller;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.infosys.educationConsultancyApplication.bean.EduconUser;
////import com.infosys.educationConsultancyApplication.config.EncoderConfig;
////import com.infosys.educationConsultancyApplication.service.EduconUserService;
////
////@RestController
////@RequestMapping("/edu-con/")
////@CrossOrigin(origins="http://localhost:3636")
////public class LoginController {
////	@Autowired
////	private EduconUserService service;
////	
////	@Autowired
////	private EncoderConfig econfig;
////	
////	@Autowired
////	private AuthenticationManager authenticationManager;	
////	
////	@PostMapping("/login")
////	public void registerNewUser(@RequestBody EduconUser eduUser) {
////		 
////		PasswordEncoder bCrypt=econfig.passwordEncoder();
////		String encoderPassword=bCrypt.encode(eduUser.getPassword());
////	    eduUser.setPassword(encoderPassword);
////	    service.save(eduUser);
////	}
////	@GetMapping("/login/{userId}/{password}")
////	public String checkLogin(@PathVariable String userId,@PathVariable String password) {
////		String category="false";
////		try{
////		   	 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
////	 	    category=service.getCategory();
////	        SecurityContextHolder.getContext().setAuthentication(authentication);
////			}catch(Exception ex) {}
////		 return category;
//// 
////	}		
////
////	
////}
//
//
//package com.infosys.educationConsultancyApplication.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.infosys.educationConsultancyApplication.bean.EduconUser;
//import com.infosys.educationConsultancyApplication.config.EncoderConfig;
//import com.infosys.educationConsultancyApplication.service.EduconUserService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//@RestController
//@RequestMapping("/edu-con/")
//@CrossOrigin(origins = "http://localhost:3636")
//public class LoginController {
//	@Autowired
//	private EduconUserService service;
//	
//	@Autowired
//	private EncoderConfig econfig;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@PostMapping("/login")
//	public void registerNewUser(@RequestBody EduconUser eduUser) {
//		System.out.println("Hello 1");
//		PasswordEncoder bCrypt=econfig.passwordEncoder();
//		String encodedPassword=bCrypt.encode(eduUser.getPassword());
//		System.out.println("Hello 2");
//		
//		eduUser.setPassword(encodedPassword);
//		service.save(eduUser);
//	
//	}
//	@GetMapping("/login/{userId}/{password}")
//	public String validUser(@PathVariable String userId,@PathVariable String password) {
//		String category="false";
//		try{
//		   	 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
//	 	    category=service.getCategory();
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//			}catch(Exception ex) {}
//		 return category;
// 
//	}	
//}


package com.infosys.educationConsultancyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.educationConsultancyApplication.bean.EduconUser;
import com.infosys.educationConsultancyApplication.config.EncoderConfig;
import com.infosys.educationConsultancyApplication.service.EduconUserService;

@RestController
@RequestMapping("/edu-con/")
@CrossOrigin(origins = "http://localhost:3636")
public class LoginController {
	@Autowired
	private EduconUserService service;
	
	@Autowired
	private EncoderConfig econfig;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public void registerNewUser(@RequestBody EduconUser eduUser) {
		PasswordEncoder bCrypt = econfig.passwordEncoder();
		String encodedPasssword = bCrypt.encode(eduUser.getPassword());
		eduUser.setPassword(encodedPasssword);
		service.save(eduUser);
	}
	
	@GetMapping("/login/{userId}/{password}")
	public String validateUser(@PathVariable String userId,@PathVariable String password) {
		String category="false";
		try{
		   	 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
	 	    category=service.getCategory();
	        SecurityContextHolder.getContext().setAuthentication(authentication);
			}catch(Exception ex) {}
		 return category;
	}		
}