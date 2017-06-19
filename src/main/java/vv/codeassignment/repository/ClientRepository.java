package vv.codeassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vv.codeassignment.model.ClientId;
import vv.codeassignment.model.User;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<User, Long> {

	public User getClientById(Long userId);
	public User getClientByClientId(ClientId clientId);
}
