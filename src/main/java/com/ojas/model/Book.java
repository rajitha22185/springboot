package com.ojas.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Book {
		private int bid;
		private String name;
		private String author;
}
