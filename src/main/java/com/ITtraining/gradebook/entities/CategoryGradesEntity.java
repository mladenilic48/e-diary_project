package com.ITtraining.gradebook.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "category_grades")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CategoryGradesEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column
	private String category;

	@OneToMany(mappedBy = "categoryGrade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CreatingGradesEntity> creatingGrades = new ArrayList<>();

	public CategoryGradesEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<CreatingGradesEntity> getCreatingGrades() {
		return creatingGrades;
	}

	public void setCreatingGrades(List<CreatingGradesEntity> creatingGrades) {
		this.creatingGrades = creatingGrades;
	}

}
