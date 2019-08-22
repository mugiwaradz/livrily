package com.zinou.Livrily.service;

import com.zinou.Livrily.model.Utilisateur;
import com.zinou.Livrily.repository.LoginRepository;
import com.zinou.Livrily.repository.LoginRepositoryImpl;

public class LoginServiceImpl implements LoginService {

	
	LoginRepository repository=new LoginRepositoryImpl();

	@Override
	public boolean Login(Utilisateur utilisateur) {

		return repository.Login(utilisateur.getLogin(),utilisateur.getPasword());

	}

}
