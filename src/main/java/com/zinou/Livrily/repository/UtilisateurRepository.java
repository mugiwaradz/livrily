package com.zinou.Livrily.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Full_User;

@Service
public interface UtilisateurRepository {
		
	List<Full_User> getUtilsateurs(int type_user, String sql);

	Full_User createutilisateurs(Full_User full_user);
	
	boolean deleteutilisateurs(int id_utilisateur);



}
