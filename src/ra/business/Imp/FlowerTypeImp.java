package ra.business.Imp;

import ra.business.design.IFlowerType;
import ra.business.entity.FlowerType;
import ra.business.config.ShopConstant;
import ra.business.config.ShopValidate;
import ra.business.file.FileAll;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowerTypeImp implements IFlowerType<FlowerType,Integer> {
    public static List<FlowerType> readFromFile () {
        FileAll<FlowerType> fileAll = new FileAll<>();
        List<FlowerType> list = fileAll.readFromFile(ShopConstant.FLOWERTYPE_URL);
        return list;
    }
    public static boolean writeFromFile (List<FlowerType> list) {
        FileAll<FlowerType> fileAll = new FileAll<>();
        boolean returnData = fileAll.writeFromFile(list, ShopConstant.FLOWERTYPE_URL);
        return returnData;
    }

    @Override
    public boolean searchByNameOrId(String name, String id) {
        List<FlowerType> list = readFromFile();
        for (FlowerType typeF :list) {
            if (typeF.getFlowerTypeName().contains(name) || (typeF.getFlowerTypeId()+"").contains(id)){
                displayData(typeF);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(FlowerType flowerType) {
        List<FlowerType> list = readFromFile();
        if (list==null){
            list = new ArrayList<>();
        }
        list.add(flowerType);
        boolean result = writeFromFile(list);
        return result;
    }

    @Override
    public boolean update(FlowerType flowerType) {

        return false;
    }



    @Override
    public List<FlowerType> findAll() {
        return readFromFile();
    }

    @Override
    public FlowerType inputData(Scanner sc) {
        List<FlowerType> list = readFromFile();
        if (list == null){
            list = new ArrayList<>();
        }
        int id;
        String name;
        String des;

        System.out.println("Nhập vào tên loại hoa: ");
        do{
            name= sc.nextLine();
            boolean checkName = ShopValidate.checkFlowerTypeName(list,name);
            if (checkName){
                break;
            }
        }while (true);
        System.out.println("Nhập vào mô tả danh mục: ");
        do {
            des = sc.nextLine();
            if (des!= null){
                break;
            }else {
                System.err.println("Xin hãy nhập văn bản!");
            }
        }while (true);
        boolean flowerStatus = true;
        int newid = getnewId();
        FlowerType newF = new FlowerType(newid,name,des,flowerStatus);
        newF.setFlowerTypeId(getnewId());
        return  newF;
    }



    @Override
    public void displayData(FlowerType flowerType) {
        String status  = "";
        if (flowerType.isFlowerTypeStatus()){
            status = "Còn bán";
        }else {
            status = "Không bán";
        }
        System.out.printf("Mã loại hoa: %-5d Tên loại hoa: %-30s Trạng thái: %s\n",flowerType.getFlowerTypeId(),flowerType.getFlowerTypeName(),status);
        System.out.printf("Mô tả: %s\n",flowerType.getFlowerTypeDescription());
    }

    @Override
    public boolean delete(Integer integer) {
        List<FlowerType> list = readFromFile();
        for (FlowerType tyFlower :list) {
            if (tyFlower.getFlowerTypeId()==integer){
                tyFlower.setFlowerTypeStatus(false);
                return true;
            }
        }
        return false;
    }

    public int getnewId(){
        List<FlowerType> list = readFromFile();
        int id;
        if (list == null){
            id=1;
        }else {
            int maxId = 1;
            for (FlowerType f:list) {
                if (f.getFlowerTypeId()>maxId){
                    maxId= f.getFlowerTypeId();
                }
            }
            id=maxId+1;
        }
        return id;
    }


}
