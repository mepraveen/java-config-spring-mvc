package com.praveen.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praveen.api.SignUpManager;
import com.praveen.messaging.StudentNotificationSender;
import com.praveen.model.LogIn;
import com.praveen.model.SignUp;
import com.praveen.repository.SignUpRepository;


@Service
public class SignUpImpl implements SignUpManager {

	@Autowired
	private SignUpRepository signUpRepository;
	
     @Autowired
     private StudentNotificationSender studentNotificationSender;
	

	//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
	
	@Override
	@Transactional
	public SignUp addNew(SignUp t) {
	//	t.setPassword(passwordEncoder.encode(t.getPassword()));
		this.studentNotificationSender.sendStudentNotification(t);
		return this.signUpRepository.save(t);
	}

	@Override
	public void addAll(List<SignUp> list) {
	
	}

	@Override
	public SignUp update(SignUp t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(SignUp t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBy(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public SignUp find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SignUp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SignUp> findWithPaging(int pageSize, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SignUp> findByUsername(String username) {

		return this.signUpRepository.findByUsername(username);
	}

	@Override
	public List<SignUp> findValidation(LogIn logIn) {
	
	//	logIn.setPassword(passwordEncoder.encode(logIn.getPassword()));
		if (logIn.getUsernameOrEmail().contains("@")) {
			return this.signUpRepository.findByEmailAndPassword(
					logIn.getUsernameOrEmail(), logIn.getPassword());
		} else {
			return this.signUpRepository.findByUsernameAndPassword(
					logIn.getUsernameOrEmail(), logIn.getPassword());
		}
	}

}
