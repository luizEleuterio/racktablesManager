package br.jus.trtsp.control;

import br.jus.trtsp.dao.LocationDAO;
import br.jus.trtsp.model.Location;

public class LocationControl {

	public Location pesquisarPorString(String string) {
		LocationDAO ldao = new LocationDAO();
		Location l = ldao.pesquisarPorString(string);
		ldao.close();
		return l;
	}

}
