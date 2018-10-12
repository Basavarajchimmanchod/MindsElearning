package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "examclassmapping")
public class ExamClassMapping 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int ecmId;
		 @Column
			private int examId;
		 @Column
			private int classId;
		 @Column
			private int sectionId;
		 @Column
			private int termId;
		 @Column
			private Date createdAt;
		 @Column
			private Date updatedAt;
		public int getEcmId() {
			return ecmId;
		}
		public void setEcmId(int ecmId) {
			this.ecmId = ecmId;
		}
		public int getExamId() {
			return examId;
		}
		public void setExamId(int examId) {
			this.examId = examId;
		}
		public int getClassId() {
			return classId;
		}
		public void setClassId(int classId) {
			this.classId = classId;
		}
		public int getSectionId() {
			return sectionId;
		}
		public void setSectionId(int sectionId) {
			this.sectionId = sectionId;
		}
		public int getTermId() {
			return termId;
		}
		public void setTermId(int termId) {
			this.termId = termId;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


}
