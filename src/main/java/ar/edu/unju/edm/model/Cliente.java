package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.Date;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Document(collection="Clientes")
public class Cliente implements Serializable{
	@Id	
	private Integer nroDocumento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	//Calendar
	//private Date fechaUltimCompra = new Date();
	
	private String tipoDocumento;
	private int codigoAreaTelefono;
	private int numTelefono;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	//@DBRef
	//@JsonBackReference
	private List<Producto> productosComprados = new ArrayList<Producto>();
		
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEdad() {		
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		edad = periodo.getYears();		
		return edad;
	}
	
	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		return " T Desde Ultima Compra  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;		
		 	
	}
	
	
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public List<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(List<Producto> productosComprados) {
		this.productosComprados = productosComprados;
	}

	@Override
	public String toString() {
		return "Cliente [nroDocumento=" + nroDocumento + ", fechaNacimiento=" + fechaNacimiento + ", tipoDocumento="
				+ tipoDocumento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", numTelefono=" + numTelefono
				+ ", email=" + email + ", fechaUltimaCompra=" + fechaUltimaCompra + ", productosComprados="
				+ productosComprados + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAreaTelefono;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((fechaUltimaCompra == null) ? 0 : fechaUltimaCompra.hashCode());
		result = prime * result + ((nroDocumento == null) ? 0 : nroDocumento.hashCode());
		result = prime * result + numTelefono;
		result = prime * result + ((productosComprados == null) ? 0 : productosComprados.hashCode());
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigoAreaTelefono != other.codigoAreaTelefono)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (fechaUltimaCompra == null) {
			if (other.fechaUltimaCompra != null)
				return false;
		} else if (!fechaUltimaCompra.equals(other.fechaUltimaCompra))
			return false;
		if (nroDocumento == null) {
			if (other.nroDocumento != null)
				return false;
		} else if (!nroDocumento.equals(other.nroDocumento))
			return false;
		if (numTelefono != other.numTelefono)
			return false;
		if (productosComprados == null) {
			if (other.productosComprados != null)
				return false;
		} else if (!productosComprados.equals(other.productosComprados))
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}



}
