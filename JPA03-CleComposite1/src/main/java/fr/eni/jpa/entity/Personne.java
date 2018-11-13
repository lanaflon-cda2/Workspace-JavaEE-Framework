package fr.eni.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="PERSONNES_COMPOSITE")
@IdClass(PersonnePK.class)
public class Personne implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name= "NOM", length=50, nullable=false)
	private String nom;
	
	@Id
	@Column(name= "PRENOM", length=50, nullable=false)
	private String prenom;
	
	@Column(name= "DDN", length=50, nullable=true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	@Transient
	private int age;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Calendar getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(Calendar dateNaissance) {
		if(dateNaissance!=null) {
			this.dateNaissance = dateNaissance;
		}
		else {
			this.dateNaissance = new GregorianCalendar();
		}
		this.setAge(new GregorianCalendar().get(Calendar.YEAR) - this.dateNaissance.get(Calendar.YEAR));
	}
	
	public int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	public Personne() {
		super();
	}
	
	public Personne(String nom, String prenom, Calendar dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.setDateNaissance(dateNaissance);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
	

}
