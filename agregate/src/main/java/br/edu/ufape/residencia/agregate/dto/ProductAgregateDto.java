package br.edu.ufape.residencia.agregate.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufape.residencia.util.dto.ProductDto;
import br.edu.ufape.residencia.util.dto.ReviewDto;
import lombok.Data;

@Data
//@AllArgsConstructor
public class ProductAgregateDto {
	private ProductDto product;
	private List<ReviewDto> reviews;
	private float averageGrade;
	private Map<Integer, Integer> gradesCounter;
	
	public ProductAgregateDto(ProductDto product, List<ReviewDto> reviews) {
		this.product = product;
		this.reviews = reviews;
		
		float sumGrades = 0;
		Map<Integer, Integer> gradesCounter = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= 5; i++) {
			gradesCounter.put(i, 0);
		}
		
		for (ReviewDto review : reviews) {
			int grade = review.getGrade();
			
			sumGrades += grade;
			
			gradesCounter.replace(grade, gradesCounter.get(grade) + 1);
		}
		
		this.averageGrade = sumGrades / reviews.size();
		this.gradesCounter = gradesCounter;
	}
}
