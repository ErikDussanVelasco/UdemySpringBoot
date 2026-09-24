package usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.entity.Alumno;
// es obligatorio porque permite que spring boot lo identifique
import models.entity.repository.AlumnoRepository;
import usuarios.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
//la anotacion override se usa para decir que se va a sobreescribir 
	 //nos permite importar el repository crud de JPA
	
	@Autowired	
	private AlumnoRepository repository;
		//instanciamos un objeto repository que hereda de la interface CRUDrepository


	@Override
	@Transactional(readOnly=true )
	public Iterable<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional()
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return repository.save(alumno);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	@Override
	public Optional<Alumno> findById(Long id) {
		
		return repository.findById(id);
	}

}








