package com.lxs.cp.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Genre")
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "G_Id")
	private Long id;
	
	@NotNull
	@Column(name = "G_Name")
	private String name;
	
	@Column(name = "G_Description")
	private String description;
	
	@NotNull
	@Column(name = "G_Enable")
	private Byte enable;
}
