package mx.gob.salud.seguro.popular.cnpss.inventario.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Area;

@ApplicationScoped
@ManagedBean(name="areaService")
public class AreaService {
	private final static String[] colors;
    
    private final static String[] brands;
     
    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";
         
        brands = new String[10];
        brands[0] = "BMW";
        brands[1] = "Mercedes";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Fiat";
        brands[6] = "Volkswagen";
        brands[7] = "Honda";
        brands[8] = "Jaguar";
        brands[9] = "Ford";
    }
     
    public List<Area> createAreas(int size) {
        List<Area> list = new ArrayList<Area>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Area(getRandomYear(), getRandomBrand()));
            System.out.println(list.get(i));
        }
         
        return list;
    }
     
    private BigDecimal getRandomYear() {
        return BigDecimal.valueOf(Long.valueOf(String.valueOf((Math.random() * 50))));
    }
     
    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

}
