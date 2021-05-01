package com.lxs.cp.test.dto;

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
public class SubGenreDto {
	private Long id;
	private Long genreId;
	private String name;
	private String description;
	private Byte enable;
	private GenreDto genre;
}
