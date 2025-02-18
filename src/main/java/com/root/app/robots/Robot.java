package com.root.app.robots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.root.app.parts.Arm;
import com.root.app.parts.LeftArm;
import com.root.app.parts.RightArm;

@Component
public class Robot {
	
	@Autowired
	private Arm la;
	@Autowired
	@Qualifier("rightArm")
	private Arm ra;
	
	public void attack() {
		System.out.println("Robot");
		la.punch();
		ra.punch();
	}

}
