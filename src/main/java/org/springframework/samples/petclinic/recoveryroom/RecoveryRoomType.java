package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "RecoveryRoom")
public class RecoveryRoomType {
	
	@Id
	@Column(name = "id")
    Integer id;
	
	@Column(name = "name")
    String name;
}
