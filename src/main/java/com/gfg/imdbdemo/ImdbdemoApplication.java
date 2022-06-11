package com.gfg.imdbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImdbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbdemoApplication.class, args);
	}

}


/**
 *DDL-AUTO
 * {
 *       "name": "spring.jpa.hibernate.ddl-auto",
 *       "values": [
 *         {
 *           "value": "none",
 *           "description": "Disable DDL handling."
 *         },
 *         {
 *           "value": "validate",
 *           "description": "Validate the schema, make no changes to the database."
 *         },
 *         {
 *           "value": "update",
 *           "description": "Update the schema if necessary."
 *         },
 *         {
 *           "value": "create",
 *           "description": "Create the schema and destroy previous data."
 *         },
 *         {
 *           "value": "create-drop",
 *           "description": "Create and then destroy the schema at the end of the session."
 *         }
 *       ]
 *     }
 * */