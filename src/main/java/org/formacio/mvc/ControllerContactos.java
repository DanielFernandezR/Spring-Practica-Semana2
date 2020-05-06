package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerContactos {
	
	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(path="/nombre", method = RequestMethod.GET)
	@ResponseBody
	public int numeroTotalContactos() {
		return agenda.nombreContactes();
	}
	
	@RequestMapping(path="/telefon", method = RequestMethod.GET)
	@ResponseBody
	public String obtenerTelefonoContacto(@RequestParam String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping(path="/contacte/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Persona obtenerContactoJSON(@PathVariable String id) {
		if ( agenda.recupera(id) != null) {
			return agenda.recupera(id);
		}else {
			throw new OperacionesDeExcepcion();
		}
	}
	
	@RequestMapping(path="/afegir", method = RequestMethod.POST)
	@ResponseBody
	public void añadirNuevoContacto(@RequestParam String id, @RequestParam String nom, @RequestParam String telefon) {
		agenda.inserta(id, nom, telefon);
	}
}