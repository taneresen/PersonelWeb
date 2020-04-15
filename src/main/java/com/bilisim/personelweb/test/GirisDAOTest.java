
package com.bilisim.personelweb.test;

import com.bilisim.personelweb.dao.GirisDAO;


public class GirisDAOTest {
    
    public static void main(String[] args) {
        
        boolean sonuc = GirisDAO.giriseYetkilimi("taner", "taner1980");
        
        if (sonuc) {
            
            System.out.println("Girise Yetkilidir");
            
        } else {
            System.out.println("Girise Yetkili Degildir");
        }
        
        
    }
    
}
