package com.ust.lib.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	

}
