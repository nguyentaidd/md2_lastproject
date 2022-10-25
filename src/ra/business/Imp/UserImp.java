package ra.business.Imp;

import ra.business.config.ShopConstant;
import ra.business.config.ShopValidate;
import ra.business.design.IUser;
import ra.business.entity.User;
import ra.business.file.FileAll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserImp implements IUser<User,Integer> {
    public static List<User> readFromFile (){
        FileAll<User> fileAll = new FileAll<>();
        List<User> listUser =  fileAll.readFromFile(ShopConstant.USER_URL);
        return listUser;
    }
    public static boolean writeToFile (List<User> list){
        FileAll<User> fileAll = new FileAll<>();
        boolean returnData = fileAll.writeFromFile(list,ShopConstant.USER_URL);
        return returnData;
    }

    @Override
    public boolean create(User user) {
        List<User> listCatalog = readFromFile();
        if (listCatalog== null){
            listCatalog = new ArrayList<>();
        }
        listCatalog.add(user);
        boolean result = writeToFile(listCatalog);
        return result;
    }

    @Override
    public boolean update(User user) {
        List<User> listCatalog = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < listCatalog.size(); i++) {
            if (listCatalog.get(i).getUserId() == user.getUserId()) {
                listCatalog.set(i, user);
                returnData = true;
                break;
            }
        }
        boolean result = writeToFile(listCatalog);
        if (result && returnData) {
            return true;
        }
        return false;

    }

    @Override
    public List<User> findAll() {
        return readFromFile();
    }

    @Override
    public User inputData(Scanner sc) {
        List<User> list = readFromFile();
        if (list == null){
            list = new ArrayList<>();
        }
        //Khoi tao doi tuong de nhap thong tin
        int  userId;
        String username;
        String fullname;
        String password;
        String repassword;
        String email;
        String phoneNumber;
        String createdDate;
        boolean status=true;
        boolean isPermission=false;


        System.out.println("Nhập username: ");
        do{
            username= sc.nextLine();
            boolean checkName = ShopValidate.checkValidateName(username);
            if (checkName){
                break;
            }
        }while (true);
        System.out.println("Nhap password : ");
        do {
            password = sc.nextLine();
            boolean check = ShopValidate.checkPassword(password);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhap lai password : ");
        do {
            repassword = sc.nextLine();
            if (!repassword.equals(password)) {
                System.err.println("mat khau khong giong nhau, nhap lai");
            }else {
                break;
            }
        }while (true);
        System.out.println("Nhap email : ");
        do {
            email = sc.nextLine();
            boolean check = ShopValidate.checkEmail(email);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhập số điện thoại(84-xxxxxxxxx): ");
        do {
            phoneNumber = sc.nextLine();
            boolean check = ShopValidate.checkPhoneNumber(phoneNumber);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhập tên đầy đủ: ");
        fullname = sc.nextLine();
        userId = getnewId();
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        createdDate = dateFormat.format(date);

        User user = new User(userId,username,password,fullname,email,phoneNumber,isPermission,createdDate,status);
        return  user;
    }

    @Override
    public void displayData(User user) {
        List<User> users = readFromFile();
        System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", "ID", "Tên đăng nhập","Tên tài khoản" ,"Loại tài khoản", "Trạng thái");
        for (User u : users) {
            String permission = u.isPermission()?"Quản trị viên":"Khách hàng";
            String status = u.isUserStatus()?"Hoạt động":"Bị khóa";
            System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", u.getUserId(),u.getUserName(),u.getFullName(), permission, status);

        }
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }


    @Override
    public List<User> searchByName(String str) {
        List<User> listUserFull = readFromFile();
        List<User> list = new ArrayList<>();
        for (User u : listUserFull) {
            if (u.getUserName().contains(str)) {
                list.add(u);
            }
        }
        return list;
    }

    public int getnewId(){
        List<User> list = readFromFile();
        int id;
        if (list == null){
            id=1;
        }else {
            int maxId = 1;
            for (User f:list) {
                if (f.getUserId()>maxId){
                    maxId= f.getUserId();
                }
            }
            id=maxId+1;
        }
        return id;
    }

    public User checkLogin(String userName, String password) {
        List<User> listUser = readFromFile();
        for (User user : listUser) {
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}

