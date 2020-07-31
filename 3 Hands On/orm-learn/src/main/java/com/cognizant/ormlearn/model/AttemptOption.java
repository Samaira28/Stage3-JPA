package com.cognizant.ormlearn.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Table(name = "attempt_option")
@Entity
public class AttemptOption {

	@Id
	@Column(name = "ao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ao_op_id")
	private Options options;

	@ManyToOne
	@JoinColumn(name = "ao_aq_id")
	private AttemptQuestion attemptQuestion;

	@Column(name = "ao_selected")
	private boolean selected;

	public AttemptOption() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Options getOptions() {
		return options;
	}

	public void setOption(Options options) {
		this.options = options;
	}

	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}