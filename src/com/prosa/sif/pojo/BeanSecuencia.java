package com.prosa.sif.pojo;

public class BeanSecuencia {
	
	private Number secuencia;

	public BeanSecuencia() {
		
	}

	public BeanSecuencia(Number secuencia) {
		super();
		this.secuencia = secuencia;
	}

	public Number getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Number secuencia) {
		this.secuencia = secuencia;
	}

	@Override
	public String toString() {
		return "BeanSecuencia [secuencia=" + secuencia + "]";
	}

}
