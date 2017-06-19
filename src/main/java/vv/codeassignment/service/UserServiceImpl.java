package vv.codeassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vv.codeassignment.model.ClientId;
import vv.codeassignment.model.User;
import vv.codeassignment.repository.ClientRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	ClientRepository clientRepository; 

	@Override
	public User getClientById(Long userId) {
		return clientRepository.findOne(userId);
	}

	@Override
	public User getClientByClientId(ClientId clientId) {
		return clientRepository.getClientByClientId(clientId);
	}

}
