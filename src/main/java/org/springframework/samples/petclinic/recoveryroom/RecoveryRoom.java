package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RecoveryRooms")
public class RecoveryRoom {
	
	@Id
	@Column(name = "id")
    Integer id;
	
	@Column(name = "name")
    String name;
	
	@Column(name = "size")
    double size;
	
	@Column(name = "secure")
    boolean secure;
	
    @Transient
    @OneToMany
    @JoinColumn(name = "roomType")
    RecoveryRoomType roomType;
}
