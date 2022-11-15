package com.comdata.automobile.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Automobile {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@NotNull
	@Size(min = 2, message="INSERISCI ALMENO DUE CARATTERI")
	@Column(name="marca")
	private String marca;
	
	
	@NotNull
	@Size(min = 2, message="INSERISCI ALMENO DUE CARATTERI")
	@Column(name="targa", unique = true)
	private String targa;

	public Automobile(UUID id, String marca, String targa) {
		super();
		this.id = UUID.randomUUID();
		this.marca = marca;
		this.targa = targa;
	}

	public Automobile(String marca, String targa) {
		super();
		this.marca = marca;
		this.targa = targa;
	}
	

}
