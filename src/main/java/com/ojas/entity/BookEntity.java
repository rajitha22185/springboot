package com.ojas.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="book")
public class BookEntity {
	@Id
	@Column
	@GenericGenerator(name="myGenerator",strategy="increment")
	@GeneratedValue(generator="myGenerator" , strategy=GenerationType.AUTO)
	private int bid;
	@Column
	private String name;
	@Column
	private String author;
}
