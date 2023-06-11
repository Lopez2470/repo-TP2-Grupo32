package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
@Service
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	private ListaServicio listaServicios;
	@Autowired
	private Servicio servicio;
	//Método que retornará todos los objetos Servicio a la vista.
	@Override
	public List<Servicio> getServicios() {
		return listaServicios.getServicios();
	}
	//Método que retornará el objeto Servicio a la vista.
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	/*
	 *Método que guardará el objeto servicio enviado como parámetro por la vista.
	 */
	@Override
	public void guardarServ(Servicio servicio) {
		getServicios().add(servicio);
	}
	/*
	 *Método que buscará un objeto servicio por medio de su atributo codigo de servicio
	 *enviado por la vista.
	 *Devuelve el objeto encontrado a la vista
	 */
	@Override
	public Servicio buscarServicioById(int id) {
		Servicio servicioAux = new Servicio();
		for (Servicio servi : getServicios()) {
			if (servi.getCodigoServ() == id) {
				servicioAux = servi;
				break;
			}
		}
		return servicioAux;
	}
	/*
	 * Método que guarda los atributos de un objeto servicio enviado como
	 * parámetro desde la vista.
	 * Busca por el atributo codigo de servicio al objeto enviado para guardar
	 * los cambios realizados desde la vista
	 */
	@Override
	public void modificarServ(Servicio servicio) {
		Servicio servicioMod = new Servicio();
		for (Servicio serv : getServicios()) {
			if (serv.getCodigoServ() == servicio.getCodigoServ()) {
				servicioMod = serv;
				break;
			}
		}
		servicioMod.setNombreServ(servicio.getNombreServ());
		servicioMod.setDescripcionServ(servicio.getDescripcionServ());
		servicioMod.setPrecioServ(servicio.getPrecioServ());
		servicioMod.setCategoriaServ(servicio.getCategoriaServ());		
	}
	/*
	 *Método que eliminará el objeto servicio.
	 *El objeto se  buscará por su atributo codigo de servicio enviado como parámetro 
	 *por la vista. El objeto encontrado será borrado.
	 */
	@Override
	public void eliminarServ(int id) {
		Servicio servicioBorrar = new Servicio();
		for (Servicio servic : getServicios()) {
			if (servic.getCodigoServ() == id) {
				servicioBorrar = servic;
				break;
			}
		}
		getServicios().remove(servicioBorrar);
		
	}
	/*
	 *Método que buscará un objeto servicio por medio de su atributo nombre de servicio
	 *enviado por la vista.
	 *Devuelve el objeto encontrado a la vista
	 */
	@Override
	public Servicio buscarServicioByNombre(String nombre) {
		Servicio servicioBuscar = new Servicio();
		for (Servicio serv : getServicios()) {
			if (serv.getNombreServ().equals(nombre)) {
				servicioBuscar = serv;
				break;
			}
		}
		return servicioBuscar;
	}

}
