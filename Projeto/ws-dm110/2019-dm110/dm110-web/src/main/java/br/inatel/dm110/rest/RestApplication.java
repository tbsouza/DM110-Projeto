package br.inatel.dm110.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.inatel.dm110.impl.CalculatorServiceImpl;
import br.inatel.dm110.impl.HelloServiceImpl;
import br.inatel.dm110.impl.IbgeServiceImpl;
import br.inatel.dm110.impl.OrderServiceImpl;

@ApplicationPath("/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		classes.add(OrderServiceImpl.class);
		
		return classes;
	}

}
