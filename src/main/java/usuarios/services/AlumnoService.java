 package usuarios.services;

import java.util.Optional;

import models.entity.Alumno;

public interface AlumnoService {

	
	//Desarrollamos el contrato CRUD para nuestro service
	//Dice que recorre una lista de objetos
	//obtiene todos los alumnos
		public Iterable<Alumno>findAll();
		
		//busca un alumno especificamente por ID
		// el opcional ayuda por si existe ono y no generar errores
		public Optional<Alumno> findById(Long id);
		
		//Dependiendo de la implementacion y del estado del objeto save()
		//puede usarse para crear o para actualizar
		
		public Alumno save(Alumno alumno);
		
		//elimina un alumno mediante ID
		public void deleteById(Long id);
		
}
