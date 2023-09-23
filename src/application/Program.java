package application;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: Seller findById: ===");
        Seller seller = sellerDao.findById(4);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findById: ===");
        Department departmentTest = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(departmentTest);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findAll: ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller Insert: ===");
        Seller newSeller = new Seller(null,"Greg","Greg@gmail.com",new Date(),2300.00,departmentTest);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: Seller Update: ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed.");

        System.out.println("\n=== TEST 5: Seller Update: ===");
        System.out.print("Enter id for delete test:");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deletion complete!");

        sc.close();
    }
}
