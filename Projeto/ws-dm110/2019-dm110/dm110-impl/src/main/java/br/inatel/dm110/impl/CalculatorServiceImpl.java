package br.inatel.dm110.impl;

import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.CalculatorService;

@RequestScoped
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public String soma(String op1, String op2) {
		
		float opr1 = Float.parseFloat(op1);
		float opr2 = Float.parseFloat(op2);
		float result = 0;
		
		result = opr1 + opr2;
		
		return "<h1>SOMA = " + result + "</h1>";
	}

}
