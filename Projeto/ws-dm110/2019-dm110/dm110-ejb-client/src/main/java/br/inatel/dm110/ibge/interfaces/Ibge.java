package br.inatel.dm110.ibge.interfaces;

import java.util.List;

import br.inatel.dm110.api.StateTO;

public interface Ibge {

	public void saveState(StateTO state);

	public List<StateTO> listAllStates();
}
