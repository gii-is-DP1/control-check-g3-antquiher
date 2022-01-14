package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, String>{
	
    List<RecoveryRoom> findAll();
    
    @Query("SELECT DISTINCT ROOM_TYPE FROM RECOVERY_ROOMS")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT * FROM RECOVERY_ROOMS WERE RECOVERY_ROOM.ID LIKE :id% ")
    Optional<RecoveryRoom> findById(int id);
    
    @SuppressWarnings("unchecked")
	@Modifying
	@Query(
	  value = 
	    "insert into RECOVERY_ROOMS values :p",
	  nativeQuery = true)
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT * FROM RECOVERY_ROOM_TYPE WERE RECOVERY_ROOM_TYPE.NAME LIKE :name% ")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("Select * FROM RECOVERY_ROOMS WERE SIZE > :size%")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
