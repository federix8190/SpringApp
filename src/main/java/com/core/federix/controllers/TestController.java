package com.core.federix.controllers;

import com.core.federix.models.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

	static List<Persona> personas = new ArrayList<>();
	static {
		personas.add(new Persona(1, "Juan", "Perez", 18));
		personas.add(new Persona(2, "Fernando", "Saucedo", 8));
		personas.add(new Persona(3, "Fede", "Torres", 31));
		personas.add(new Persona(4, "Carlos", "Aquino", 37));
		personas.add(new Persona(5, "Franco", "Cubilla", 5));
		personas.add(new Persona(6, "Roberto", "Gonzalez", 79));
	}

	@GetMapping
	public String get() {
		return "Holaaa";
	}

	@GetMapping(value="/persons")
	public List<Persona> persons() {
		return personas;
	}

	/**
	 * 1 - Ejemplo funcion lambda
	 */
	@GetMapping(value="/persons/resumen")
	public List<String> resumen() {

		List<String> res = new ArrayList<>();
		personas.forEach(p -> res.add("Persona " + p.getId() + " : " + p.getNombre() + " " + p.getApellido()));
		//personas.forEach(p -> res.add(getDatos(p))); // ---> Forma mas facil de leer
		return res;
	}

	/**
	 * 2 - Ejemplo de map
	 */
	@GetMapping(value="/persons/nombres")
	public List<String> mayusculas() {

		List<String> res = new ArrayList<>();
		List<String> collect = personas.stream().map(Persona::saludo).collect(Collectors.toList());
		return collect;
	}

	/**
	 * 3 - Ejemplo de reduce
	 */
	@GetMapping(value="/nros/mayor")
	public Integer getMayor() {

		List<Integer> nros = Arrays.asList(45, 10, 25, 67, 31, 40, 5, 16, 7);
		Optional<Integer> mayor = nros.stream().reduce((nro1, nro2) -> nro1 > nro2 ? nro1 : nro2);
		return mayor.get();
	}

	/**
	 * 4 - Ejemplo de filtro
	 */
	@GetMapping(value="/persons/mayores")
	public List<Persona> getMayores() {

		return personas.stream().filter(p -> p.getEdad() > 17).collect(Collectors.toList());
	}

	/**
	 * 5 - Los predicados son expresiones que reciben un argumento y devuelven un valor logico
	 */
	private boolean esMayor(Persona persona) {
		Predicate<Persona> predicate = (p) -> p.getEdad() > 17;
		return predicate.test(persona);
	}

	/**
	 * 6 - Las funciones son expresiones que reciben un argumento y devuelven un resultado
	 */
	private int testFuncion(Persona p) {
		Function<String, Integer> length = str -> str.length();
		return length.apply(p.getNombre());
	}

	/**
	 * 7 - Ejemplo de Consumer, tienen un sólo argumento de entrada y no devuelven ningún valor
	 */
	private void testConsumidor() {
		Consumer<Persona> persona = (p) -> System.out.println("Hola, " + p.getNombre());
		persona.accept(new Persona(99, "Jorge", "Valladares",15));
	}

	/**
	 * 8 - Proveedores
	 * Las expresiones Lambda de este tipo no tiene parámetros de entrada, pero si devuelven un resultado
	 */
	private Persona testProveedor() {

		Supplier<Persona> supplier = () -> new Persona();
		return supplier.get();
	}

	public interface Deportista {
		public String entrenar();
	}

	@GetMapping(value="/example/supplier")
	public String testProveedor2(@RequestParam(value = "deporte", required = false) Integer deporte) {

		Supplier<String> supplier = null;

		if (deporte == null) {
			Deportista d = getDeportista("Debes espescificar un deporte (1: Tennis, 2: Futbol, 3: Basquetball)");
			supplier = () -> d.entrenar();
		}
		else if (deporte == 1) {
			Deportista tennista = getDeportista("Estoy practicando mi saque !!!");
			supplier = () -> tennista.entrenar();

		} else if (deporte == 2) {
			Deportista futbolista = getDeportista("Estoy pateando tiros libres");
			supplier = () -> futbolista.entrenar();

		} else if (deporte == 3) {
			Deportista basquetbolista = getDeportista("Estoy lanzando canastas");
			supplier = () -> basquetbolista.entrenar();
		} else {
			Deportista basquetbolista = getDeportista("Deporte no definido");
			supplier = () -> basquetbolista.entrenar();
		}

		return supplier.get();
	}

	private Deportista getDeportista(String msg) {

		Deportista deportista = new Deportista() {
			@Override
			public String entrenar() {
				return msg;
			}
		};
		return deportista;
	}

	private String getDatos(Persona p) {
		return "Persona " + p.getId() + " : " + p.getNombre() + " " + p.getApellido();
	}

	/**
	 * Para probar --> {"id":1,"edad":20,"nombre":"luis","apellido":""}
	 * @param p
	 */
	@PostMapping(value="/persons")
	public void save(@RequestBody Persona p) {//@RequestHeader("Authorization") String authorization) {
		System.err.println("Persona : " + p);
	}

}
