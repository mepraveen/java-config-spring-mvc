package com.praveen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.praveen.model.SignUp;


@Transactional(readOnly=true)
public interface SignUpRepository extends JpaRepository<SignUp,Integer>{
	
	public List<SignUp> findByUsername(String username);
	
	public List<SignUp> findByEmailAndPassword(String email, String password);
	public List<SignUp> findByUsernameAndPassword(String username , String password );
	
	

}
