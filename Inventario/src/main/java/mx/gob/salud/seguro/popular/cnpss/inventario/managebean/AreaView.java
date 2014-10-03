package mx.gob.salud.seguro.popular.cnpss.inventario.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.gob.salud.seguro.popular.cnpss.inventario.dao.AreaDAO;
import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Area;
import mx.gob.salud.seguro.popular.cnpss.inventario.service.AreaService;

@ManagedBean(name="areaView")
@ViewScoped
public class AreaView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Area> areas = new ArrayList<Area>();
    
    @ManagedProperty("#{areaService}")
    private AreaService service;
 
    @PostConstruct
    public void init() {
        areas = service.createAreas(10);
    }
     
    public List<Area> getAreas() {
        return areas;
    }
 
    public void setService(AreaService service) {
        this.service = service;
    }

	private AreaDAO areaDao = new AreaDAO();

	
	public AreaDAO getAreaDao() {
		return areaDao;
	}
	public void setAreaDao(AreaDAO areaDao) {
		this.areaDao = areaDao;
	}



}
