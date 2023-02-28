package com.doconnect.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserType {

	@Id
	private String userType;
	private String usertypedescription;

	public String getUsertype() {
		return userType;
	}

	public void setUsertype(String usertype) {
		this.userType = usertype;
	}

	public String getUsertypedescription() {
		return usertypedescription;
	}

	public void setUsertypedescription(String usertypedescription) {
		this.usertypedescription = usertypedescription;
	}
	
	
}
