package models.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

//Entidad alumno designado como tabla y cada atributo como una columna
//las tablas deben ir todo en mayuscula o minuscula

@Table(name="alumnos") // se especifica el nombre si no la base de datos asigna el nombre de la clase como predeterminado
@Entity
public class Alumno {
	
	@Id //para indicar que es una clave
	
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	
	
	//Getters and Setters
	//ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	//Nombre
	public String getNombre() {
		return nombre;
	}
	public void Setnombre(String nombre) {
		this.nombre=nombre;
	}
	//Apellido
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	//Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Date
	
	@Column(name = "create_at")
	
	private LocalDateTime createAT;
	
	
	@PrePersist
	//esta anotacion permite que este metodo se ejecute de primero antes que todo
	public void prePersist() {
		this.createAT= LocalDateTime.now();
	}
	public LocalDateTime getCreateAT() {
		return createAT;
	}
	public void setCreateAT(LocalDateTime createAT) {
		this.createAT = createAT;
	}
	
}
