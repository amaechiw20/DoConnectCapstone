/**
 * 
 */
package com.doConnect.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String userType;

}
