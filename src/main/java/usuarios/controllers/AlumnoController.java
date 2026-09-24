package usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.entity.Alumno;
import usuarios.services.AlumnoService;
//CONTROLADOR COMPLETO CON EL CRUD
//CREATE,READ,UPADATE,DELETE

//GET(LEER,CONSULTAR,TRAER)
//POST(CREAR)
//PUT(ACTUALIZA COMPLETAMENTE UN DATO) 
//PATCH (ACTUALIZA UNA PARTE DEL DATO)
//DELETE(ELIMINA UN RECURSO)

//marca la clase como un controlador tipo REST FULL 
//la respuesta se traduce a formato JSON
@RestController
public class AlumnoController {
	
	//la anotacion me permite hacer la inyeccion de dependencias automatico
	@Autowired
	private AlumnoService service;
	
	//nos permite mapear una ruta URL al metodo
	//la peticion el request es de tipo get
	//listar los alumnos 
	@GetMapping
	
	// es un objeto que nos permite contruir las respuestas
	//nos permite darle un http status
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
		
	}
	@GetMapping("/{id")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Alumno> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno){
		Alumno alumnoDb =service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	@PutMapping("/{id}")
	//el requestbody trae los atributos que tenemos que debemos actualizar porque ya hacen parte del objeto alumno
	
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		
		//primero lo buscamos a la base de datos mediante el ID
		Optional<Alumno> o = service.findById(id);
		
		//este condicional valida que exista
		if(o.isEmpty()) {
			
			//not found es un status 404
			return ResponseEntity.notFound().build();
			
		//si se encuentra lo traemos (get) y modificamos los datos que vienen como requisito en el request
		}
		Alumno alumnoDb = o.get();
		//cambiar datos nombre
	
		alumnoDb.Setnombre(alumno.getNombre());
		
		//cambiar apellido
		alumnoDb.setApellido(alumno.getApellido());
		
		//cambiar email
		alumnoDb.setEmail(alumno.getEmail());
		//tenemos que pasarle el objeto al body pero primero hay que persistirlo(guardar)
		//primero hay que guardar el objeto alumno Db 
		
		//luego el objeto acualizado (alumnoDb lo guardamos y se lo pasamos al body
		//EL CREATED es un http 201
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
		@DeleteMapping("/{id}")
		
		public ResponseEntity<?> eliminar(@PathVariable Long id){
			service.deleteById(id);
			
			//no content es de tipo http status 204
			return ResponseEntity.noContent().build();
		}
	
}
