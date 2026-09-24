package models.entity.repository;

import org.springframework.data.repository.CrudRepository;

import models.entity.Alumno;

//Como predeterminado siempre me pide que añada el nombre de la clase
//y el nombre tipo de ID para relacionar la interfz con el entity
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

	
}
