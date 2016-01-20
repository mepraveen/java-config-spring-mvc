package com.praveen.api;




import java.util.List;

import com.praveen.model.LogIn;
import com.praveen.model.SignUp;

public interface SignUpManager extends CrudManager<SignUp, Integer>{

	public List<SignUp> findByUsername(String username);
	
	public List<SignUp> findValidation(LogIn logIn);

}
