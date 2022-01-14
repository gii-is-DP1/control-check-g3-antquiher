package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class RecoveryRoomController {
	
	private static final String VIEWS_RECOVERY_ROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
    private RecoveryRoomService recoveryRoomService;
    
    
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_RECOVERY_ROOM_CREATE_FORM;
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_RECOVERY_ROOM_CREATE_FORM;
		}
		else {
			this.recoveryRoomService.save(recoveryRoom);
			return "redirect:/";
		}
	}
	
}
