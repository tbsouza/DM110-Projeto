package br.inatel.dm110.ibge.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.StateTO;
import br.inatel.dm110.hello.dao.IbgeDao;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.ibge.interfaces.IbgeLocal;
import br.inatel.dm110.ibge.interfaces.IbgeRemote;

@Stateless
@Remote(IbgeRemote.class)
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal, IbgeRemote {

	@EJB
	private IbgeDao dao;

	@Override
	public void saveState(StateTO state) {
		dao.insert(stateMapper(state));
	}

	@Override
	public List<StateTO> listAllStates() {
		
		List<State> stList = dao.listAll();
		List<StateTO> stToList = new ArrayList<StateTO>();
		
		for (State state : stList) {
			
			stateToMapper(stToList, state);
		}
		
		return stToList;
	}

	private void stateToMapper(List<StateTO> stToList, State state) {
		StateTO st = new StateTO();
		
		st.setArea(state.getArea());
		st.setIbge(state.getIbge());
		st.setNome(state.getNome());
		st.setSigla(state.getSigla());
		
		stToList.add(st);
	}

	private State stateMapper(StateTO state) {
		State st = new State();

		st.setArea(state.getArea());
		st.setIbge(state.getIbge());
		st.setNome(state.getNome());
		st.setSigla(state.getSigla());
		return st;
	}
	
}
