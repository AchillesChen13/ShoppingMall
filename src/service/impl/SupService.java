package service.impl;

import dao.ISupDao;
import dao.impl.SupDao;
import entity.Supermarket;
import service.ISupService;

public class SupService implements ISupService {
	
	ISupDao supdao = new SupDao();

	@Override
	public boolean supLogin(Supermarket sup) {
		// TODO Auto-generated method stub
		return supdao.supLogin(sup);
	}
	
}
