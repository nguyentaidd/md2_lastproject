package ra.business.Imp;

import ra.business.config.ShopConstant;
import ra.business.config.ShopValidate;
import ra.business.config.ShopMessage;
import ra.business.entity.Flower;
import ra.business.entity.FlowerProduct;
import ra.business.entity.Product;
import ra.business.design.IProduct;
import ra.business.file.FileAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductImp implements IProduct<Product, String> {
    public static List<Product> readFromFile(){
        FileAll<Product> fileAll = new FileAll<>();
        List<Product> listProduct = fileAll.readFromFile(ShopConstant.PRODUCT_URL);
        return listProduct;
    }

    public static boolean writeFromFile(List<Product> list){
        FileAll<Product> fileAll = new FileAll<>();
        boolean returnData = fileAll.writeFromFile(list, ShopConstant.PRODUCT_URL);
        return returnData;
    }


    @Override
    public List sort(List list) {
        return null;
    }


    @Override
    public boolean create(Product product) {
        List<Product> productList = readFromFile();
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
        boolean result = writeFromFile(productList);
        return result;
    }

    @Override
    public boolean update(Product product) {

        return false;
    }


    @Override
    public List<Product> findAll() {
        return readFromFile();
    }

    @Override
    public Product inputData(Scanner scanner) {
        List<Product> listProduct = readFromFile();
        if (listProduct == null) {
            listProduct = new ArrayList<>();
        }
        Product product = new Product();
        do {
            System.out.print("Nhập mã sản phẩm: ");
            String id = scanner.nextLine();
            boolean check = ShopValidate.checkProductId_length(id);
            if (check) {
                check = ShopValidate.checkProductId(id);
                if (check) {
                    for (Product prod : listProduct) {
                        if (prod.getProductId()==Integer.parseInt(id)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        product.setProductId(Integer.parseInt(id));
                        break;
                    } else {
                        System.err.println(ShopMessage.THIS_ID_ALREADY_EXISTS);
                    }
                } else {
                    System.err.println(ShopMessage.PRODUCT_ID_WRONG);
                }
            } else {
                System.err.println(ShopMessage.ID_LENGTH_WRONG);
            }
        } while (true);
        do {
            System.out.println("Nhập vào tên sản phẩm: ");
            String name = scanner.nextLine();
            boolean check = ShopValidate.checkProductName(name);
            if (check) {
                for (Product pro : listProduct) {
                    if (pro.getProductName().equals(name)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    product.setProductName(name);
                    break;
                } else {
                    System.err.println(ShopMessage.THIS_NAME_ALREADY_EXISTS);
                }
            } else {
                System.err.println("Tên sản phẩm từ 6 - 50 ký tự !!!");
            }
        } while (true);
        int cnt = 0;
        int number = -1;
        do {
            List<Flower> listFlower = FlowerImp.readFromFile();
            System.out.println("Nhập vào số lượng loài hoa cho sản phẩm này: ");

            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập vào số !!! ");
            }
            for (int i = 0; i < number; i++) {
                FlowerProduct flowerProduct = new FlowerProduct();
                while (true) {
                    System.out.println("Vui lòng chọn loài hoa ");
                    System.out.printf("%-10s%-30s\n", "STT", " Tên loài hoa ");
                    for (int j = 0; j < listFlower.size(); j++) {
                        System.out.printf("%-10d%-30s\n", (j + 1), listFlower.get(j).getFlowerName());
                    }
                    System.out.print("Vui lòng chọn số tương ứng: ");
                    int choice = 0;

                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 0 || choice > listFlower.size()) {
                            System.err.println("Vui lòng nhập từ 1 - " + listFlower.size());
                        } else {
                            flowerProduct.setFlower(listFlower.get(choice - 1));
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Vui lòng nhập vào số !!!");
                    }
                }
                while (true){
                    try {
                        System.out.println("Nhập vào số lượng ");
                        int choice  = Integer.parseInt(scanner.nextLine());
                        flowerProduct.setQuantity(choice);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Vui lòng nhập vào số !!! ");
                    }
                }
                product.getListFlower().add(flowerProduct);
                cnt++;
            }
        } while (cnt!= number);
        do {
            float sum = 0;
            for (int i = 0; i < product.getListFlower().size(); i++) {
                sum+= product.getListFlower().get(i).getFlower().getImportFlower()*product.getListFlower().get(i).getQuantity();
            }
            System.out.println("Nhập vào giá bán của sản phẩm : ");
            System.out.println("Tổng giá nhập hoa dùng trong sản phẩm là:  " + sum);
            float price = 0;
            try {
                price = Float.parseFloat(scanner.nextLine());
                if (price>sum*1.3f){
                    product.setExportPrice(price);
                    break;
                }else {
                    System.err.println("Vui lòng nhập giá bán cao hơn " + (sum*1.3));
                }
            }catch (NumberFormatException e){
                System.err.println("Vui lòng nhập số !!! ");
            }
        }while (true);
        do {
            System.out.println("Nhập vào mô tả sản phẩm:  ");
            String content = scanner.nextLine();
            boolean check = ShopValidate.checkEmptyString(content);
            if (check){
                product.setContent(content);
                break;
            }else {
                System.err.println(ShopMessage.DO_NOT_LEAVE_IT_BLANK);
            }
        }while (true);
        do {
            System.out.println("Vui lòng chọn trạng thái của loại hoa: ");
            System.out.println("1. Còn bán.");
            System.out.println("2. Không còn bán");
            System.out.print("lựa chọn của bạn: ");
            System.out.print("\n");
            String choice = scanner.nextLine();
            String check = ShopValidate.checkInputStatus(choice);
            if (check.equals("1")){
                product.setProductStatus(true);
                break;
            }else if (check.equals("2")){
                product.setProductStatus(false);
                break;
            }else {
                System.err.println(ShopMessage.PLEASE_CHOOSE_1_OR_2);
            }
        }while (true);
        return product;
    }

    @Override
    public void displayData(Product product) {
        String status  = "";
        if (product.isProductStatus()){
            status = "Còn bán";
        }else {
            status = "Không còn bán. ";
        }
        System.out.printf("Tên sản phẩm %50s\n",product.getProductName());
        System.out.printf("Mã sản phẩm: %-10s Giá tiền bán: %-20f  Trạng thái: %-15s\n",product.getProductId(),product.getExportPrice(),status);
        System.out.print("Hoa được sử dụng: ");
        for (int i = 0; i < product.getListFlower().size(); i++) {
            System.out.print(product.getListFlower().get(i).getFlower().getFlowerName() + " (Số lượng: " +product.getListFlower().get(i).getQuantity() +")  ");
        }
        System.out.print("\n");
        System.out.printf("Mô tả: " +product.getContent());
        System.out.print("\n");
    }

    @Override
    public boolean delete(String str) {
        List<Product> productList = readFromFile();
        for (Product product :productList) {
            if (product.getProductName().equals(str)){
                product.setProductStatus(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeStatus(Product product) {
        return false;
    }

    public static void inputProduct (Scanner scanner) {
        ProductImp productImpl = new ProductImp();
        System.out.println("Nhập vào số danh mục sản phẩm bạn muốn nhập lần này: ");
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(ShopMessage.PLEASE_PRESS_NUMBER);
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập vào loài hoa thứ " + (i+1));
            Product product = new Product();
            product = productImpl.inputData(scanner);
            boolean check = productImpl.create(product);
            if (check){
                System.out.println("Đã thêm mới thành công !");
            }else {
                System.err.println("Thêm mới thất bại !!!");
            }
        }
    }

    public static void displayProduct (){
        ProductImp productImpl = new ProductImp();
        List<Product> list = readFromFile();
        for (Product product: list) {
            productImpl.displayData(product);
        }
    }

    public static void deleteProduct (Scanner scanner){
        ProductImp productImpl = new ProductImp();
        List<Product> list = readFromFile();
        while (true){
            System.out.println("Nhập vào mã loài hoa cần sửa : ");
            String id = scanner.nextLine();
            boolean check = ShopValidate.checkEmptyString(id);
            if (check){
                check = productImpl.delete(id);
                if (check){
                    System.out.println("Xóa thành công ! ");
                    break;
                }else {
                    System.err.println("Không tìm thấy mã này vui lòng nhập vào mã khác !!!");
                }
            }else {
                System.err.println(ShopMessage.DO_NOT_LEAVE_IT_BLANK);
            }
        }
    }

}
