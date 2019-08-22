
package com.zinou.Livrily.repository;

import org.springframework.stereotype.Service;

@Service
public interface LoginRepository {

	boolean Login(String login, String pasword);

}
