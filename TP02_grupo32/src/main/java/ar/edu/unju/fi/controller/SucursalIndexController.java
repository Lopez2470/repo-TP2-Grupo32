package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SucursalIndexController {
	@GetMapping("/sucursalIndex")
	public String getSucursalIndex() {
		return "sucursales-1";
	}

}
