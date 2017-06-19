package vv.codeassignment.service;

import vv.codeassignment.model.ClientId;
import vv.codeassignment.model.User;

public interface UserService {

	public User getClientById(Long userId);

	public User getClientByClientId(ClientId clientId);

}
