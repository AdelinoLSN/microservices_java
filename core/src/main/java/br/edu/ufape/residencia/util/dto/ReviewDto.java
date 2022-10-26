package br.edu.ufape.residencia.util.dto;

import lombok.Data;

@Data
public class ReviewDto {
	private long id;
	private String author;
	private String title;
	private String body;
	private int grade;
	private long productId;

}
