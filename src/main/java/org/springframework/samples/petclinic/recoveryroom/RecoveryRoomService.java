package org.springframework.samples.petclinic.recoveryroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecoveryRoomService {
	private RecoveryRoomRepository recoveryRoomRepository;
	
	
	
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
		super();
		this.recoveryRoomRepository = recoveryRoomRepository;
	}

    
    //test 5
	public List<RecoveryRoom> getAll(){
        return recoveryRoomRepository.findAll();
    }

	
	//test 6
	public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
    	List<RecoveryRoomType> res = new ArrayList<RecoveryRoomType>();
    	for(RecoveryRoom a : recoveryRoomRepository.findAll()) {
    		if(!res.contains(a.getRoomType())) {
    			res.add(a.getRoomType());
    		}
    	}
        return res;
    }

    //Otra solución mas sencilla a este método sería:
    
	public List<RecoveryRoomType> getAllRecoveryRoomTypes2(){
    	return recoveryRoomRepository.findAllRecoveryRoomTypes();
    }
	
	
    
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
    	RecoveryRoomType res = new RecoveryRoomType();
    	for(RecoveryRoom a : recoveryRoomRepository.findAll()) {
    		if(a.getRoomType().getName().equals(typeName)) {
    			res = a.getRoomType();
    		}
    	}
        return res;
    }

    
    
    //test8
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return recoveryRoomRepository.findAll().stream().filter(x->x.getSize()>size).collect(Collectors.toList());
    }
    
    //Otra solución usando rsu repository
    
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan2(double size) {
    	return recoveryRoomRepository.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return recoveryRoomRepository.save(p);       
    }
    
    
//    public List<RecoveryRoom> findAll() {
//    	return getAll();
//    }
//
//    public Optional<RecoveryRoom> findById(int id){
//    	return recoveryRoomRepository.findAll().stream().filter(x->x.getId().equals(id)).findAny();
//    }
//    
//    public List<RecoveryRoomType> findAllRecoveryRoomTypes() {
//    	return getAllRecoveryRoomTypes();
//    }
    
    
}
