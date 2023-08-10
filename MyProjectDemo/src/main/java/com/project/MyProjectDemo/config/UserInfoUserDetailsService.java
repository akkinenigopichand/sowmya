package com.project.MyProjectDemo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.MyProjectDemo.Entity.UserInfo;
import com.project.MyProjectDemo.Repo.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo=repository.findByName(username);
		
		return userInfo.map(UserInfoUserDeatails::new)
				.orElseThrow(()->new UsernameNotFoundException("User Not Found"+username));
	}

}
