/**
 * 
 */
package com.doConnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */

@Entity
@Table(name = "Chats")
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "from_user")
	private String from_user;
	
	@Column(name = "to_user")
	private String to_user;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "datetime")
	private String datetime;
}
