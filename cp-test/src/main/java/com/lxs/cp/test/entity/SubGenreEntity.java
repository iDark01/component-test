package com.lxs.cp.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SubGenre")
public class SubGenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SG_Id")
	private Long id;
	
	@NotNull
	@Column(name = "SG_GenreId")
	private Long genreId;
	
	@NotNull
	@Column(name = "SG_Name")
	private String name;
	
	@Column(name = "SG_Description")
	private String description;
	
	@NotNull
	@Column(name = "SG_Enable")
	private Byte enable;
	
	@JoinColumn(name = "SG_GenreId", referencedColumnName = "G_Id", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private GenreEntity genre;
}
