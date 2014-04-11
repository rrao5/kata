package gov.dhs.uscis.kata.repository;

import gov.dhs.uscis.kata.domain.ApplicationPacket;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationPacketRepository extends CrudRepository<ApplicationPacket, Long> {

}
