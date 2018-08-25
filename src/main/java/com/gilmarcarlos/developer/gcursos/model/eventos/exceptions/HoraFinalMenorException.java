package com.gilmarcarlos.developer.gcursos.model.eventos.exceptions;

public class HoraFinalMenorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HoraFinalMenorException() {
		super("hora final menor que hora inicial");
	}
	
	public HoraFinalMenorException(String msg) {
		super(msg);
	}

}
