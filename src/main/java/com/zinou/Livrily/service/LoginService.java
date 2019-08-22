package com.zinou.Livrily.service;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Utilisateur;

@Service
public interface LoginService {

	boolean Login(Utilisateur utilisateur);

}
