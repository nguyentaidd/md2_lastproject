package ra.business.config;

import ra.business.entity.FlowerType;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopValidate {
    public static boolean checkEmail(String str) {
        String regex = "^(.+)@(.+)$";
        Pattern path = Pattern.compile(regex);
        Matcher matcher = path.matcher(str);
        return matcher.matches();
    }

    public static boolean checkEmptyString(String str) {
        if (str.trim().length() != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkUserNameLength(String str) {
        if (str.trim().length() >= 6) {
            return true;
        }
        return false;
    }

    public static boolean checkValidateUserName(String str) {
        String regex = "^[a-zA-Z0-9._-]{3,}$";
        Pattern path = Pattern.compile(regex);
        Matcher matcher = path.matcher(str);
        return matcher.matches();
    }

    public static boolean checkPassword(String str) {
        if (str.trim().length() >= 6) {
            return true;
        }
        return false;
    }

    public static boolean checkPhoneNumber(String str) {
        if (str.charAt(0) == '8' && str.charAt(1) == '4' && str.length() == 11) {
            return true;
        }
        return false;
    }

    public static boolean checkInputNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkValidateName (String str){
        if (str.trim().length()>=6&&str.trim().length()<=30){
            return true;
        }
        return false;
    }
    public static String checkInputStatus (String str ){
        if (str.equals("1")){
            return "1";
        }else if (str.equals("2")){
            return "2";
        }else {
            return "3";
        }
    }
    public static boolean checkProductId_length (String str){
        if (str.trim().length()==5){
            return true;
        }
        return false;
    }
    public static boolean checkProductId (String str){
        if (str.charAt(0)=='P'){
            return true;
        }
        return false;
    }
    public static boolean checkId5 (String str){
        if (str.trim().length()==5){
            return true;
        }
        return false;
    }
    public static boolean checkCatalogId (String str){
        if (str.charAt(0)=='T'){
            return true;
        }
        return false;
    }
    public static boolean checkFlowerId (String str){
        if (str.charAt(0)== 'H'){
            return true;
        }
        return false;
    }
    public static boolean checkInputPrice (String str){
        boolean checkExit = true;
        try {
            float check = Float.parseFloat(str);
            if (check>0){
                checkExit =  true;
            }
        }catch (NumberFormatException e){
            checkExit =  false;
        }
        return checkExit;
    }
    public static boolean checkProductName (String str ){
        if (str.trim().length()>=6&&str.trim().length()<=50){
            return true;
        }
        return false;
    }
    public static boolean checkFlowerTypeName(List<FlowerType> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,30}$");
        if (!checkValiDate){
            System.err.println("khong dung dinh dang. nhap lai");
        }else {
            if (list!=null){
                for (FlowerType f : list) {
                    if (f.getFlowerTypeName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check){
            return true;
        }
        return false;
    }
}
