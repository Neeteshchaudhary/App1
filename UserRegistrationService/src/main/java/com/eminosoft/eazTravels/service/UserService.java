package com.eminosoft.eazTravels.service;

import com.eminosoft.eazTravels.model.User;
import com.eminosoft.eazTravels.util.StatusMsg;

public interface UserService {

	StatusMsg addUser(User vSeeProviderUser);
	
}
