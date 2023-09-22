package application;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: Seller findById: ===");
        Seller seller = sellerDao.findById(4);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findById: ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2,null));
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findAll: ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }


    }
}
