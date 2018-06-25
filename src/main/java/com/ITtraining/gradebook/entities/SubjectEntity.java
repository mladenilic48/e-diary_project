package com.ITtraining.gradebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "teach_load")
	private Integer teachingLoad;

	@Column(name = "teach_class")
	private Integer teachingClass;

	public SubjectEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTeachingLoad() {
		return teachingLoad;
	}

	public void setTeachingLoad(Integer teachingLoad) {
		this.teachingLoad = teachingLoad;
	}

	public Integer getTeachingClass() {
		return teachingClass;
	}

	public void setTeachingClass(Integer teachingClass) {
		this.teachingClass = teachingClass;
	}

}
