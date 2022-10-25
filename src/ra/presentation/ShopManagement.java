package ra.presentation;

import ra.business.Imp.*;
import ra.business.config.ShopMessage;
import ra.business.entity.Feedback;
import ra.business.entity.FlowerType;
import ra.business.entity.User;

import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private static CatalogImp catImp = new CatalogImp();
    private static FlowerImp flowerImp = new FlowerImp();
    private static FlowerTypeImp flowerTypeImp = new FlowerTypeImp();
    private static ProductImp productImp = new ProductImp();
    private static UserImp userImp = new UserImp();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*****Cửa hàng hoa*******");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("3. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    sighUp(sc);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println(ShopMessage.NOTIFY_SHOP_CHOICE);
            }

        } while (true);

    }

    public static void login(Scanner sc) {
        do {
            System.out.print("Ten dang nhap: ");
            String userName = sc.nextLine();
            System.out.print("Mat khau: ");
            String password = sc.nextLine();
            User user = userImp.checkLogin(userName, password);
            if (user != null) {
                //Dang nhap thanh cong
                if (user.isPermission()) {
                    //Tai khoan admin
                    displayMenuShopManagement(sc);
                } else {
                    //Tai khoan user
                    displayMenuUser(sc);
                }
                break;
            } else {
                //Dang nhap that bai
                System.err.println(ShopMessage.NOTIFY_LOGIN_FAIL);
                System.out.println("1. Đăng nhập lại");
                System.out.println("2. Đăng ký tài khoản");
                System.out.println("3. Thoát");
                System.out.print("Sự lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 2) {
                    //Chuyen den menu dang ky
                } else if (choice == 3) {
                    break;
                }
            }
        } while (true);
    }

    public static void sighUp(Scanner sc) {
        boolean result = userImp.create(userImp.inputData(sc));
        if (result) {
            System.out.println(ShopMessage.SIGH_UP_SUCCESS);
            login(sc);
        } else
            System.out.println(ShopMessage.SIGH_UP_FAIL);
        sighUp(sc);
    }

    public static void displayMenuShopManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("*****Menu quản lý cửa hàng hoa******");
            System.out.println("1. Quản lý loại hoa");
            System.out.println("2. Quản lý loài hoa");
            System.out.println("3. Quản lý danh mục");
            System.out.println("4. Quản lý sản phẩm");
            System.out.println("5. Quản lý tài khoản");
            System.out.println("6. Quản lý đơn hàng");
            System.out.println("7. Quản lý phản hồi");
            System.out.println("8. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayMenuFlowerTypeManagement(sc);
                    break;
                case 2:
                    displayMenuFlowerManagement(sc);
                    break;
                case 3:
                    displayMenuCatalogManagement(sc);
                    break;
                case 4:
                    displayMenuProductManagement(sc);
                    break;
                case 5:
                    displayMenuUserManagement(sc);
                    break;
                case 6:
                    displayMenuOrderManagement(sc);
                    break;
                case 7:
                    displayMenuFeedbackManagement(sc);
                    break;
                case 8:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_SHOP_MANAGEMENT_CHOICE);
            }
        } while (exit);
    }

    public static void displayMenuUser(Scanner sc) {

    }

    public static void displayMenuFlowerTypeManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******Menu quản lý loại hoa*******");
            System.out.println("1. Danh sách loại hoa");
            System.out.println("2. Tạo mới loại hoa");
            System.out.println("3. Xóa loại hoa");
            System.out.println("4. Tìm kiếm loại hoa theo mã");
            System.out.println("5. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    List<FlowerType> flowerTypeList = flowerTypeImp.findAll();
                    for (FlowerType ftype : flowerTypeList) {
                        flowerTypeImp.displayData(ftype);
                    }
                    break;
                case 2:
                    FlowerType flowerType = flowerTypeImp.inputData(sc);
                     boolean check= flowerTypeImp.create(flowerType);
                     if (check){
                         System.out.println("them moi thanh cong");
                     }else {
                         System.out.println("co loi trong qua trinh xu li");
                     }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit = false;
                    break;
                default:

            }
        } while (exit);
    }

    public static void displayMenuFlowerManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******Menu quản lý loài hoa******");
            System.out.println("1. Danh sách loài hoa");
            System.out.println("2. Tạo mới loài hoa");
            System.out.println("3. Cập nhật thông tin loài hoa");
            System.out.println("4. Xóa loài hoa");
            System.out.println("5. Tìm kiếm loài hoa");
            System.out.println("6. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = false;
                    break;
                default:
            }
        } while (exit);

    }

    public static void displayMenuCatalogManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******Menu quản lý danh mục*******");
            System.out.println("1. Danh sách danh mục sản phẩm");
            System.out.println("2. Tao mới danh mục sản phẩm");
            System.out.println("3. Cập nhật danh mục sản phẩm");
            System.out.println("4. Xóa danh mục sản phẩm");
            System.out.println("5. Tìm kiếm danh mục sản phẩm theo tên");
            System.out.println("6. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = false;
                    break;
                default:
            }
        } while (exit);
    }

    public static void displayMenuProductManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******Menu quản lý sản phẩm******");
            System.out.println("1. Danh sách sản phẩm theo giá bán tăng dần");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit = false;
                    break;
                default:
            }
        } while (exit);
    }

    public static void displayMenuUserManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("*****Menu quản lý người dùng******");
            System.out.println("1. Danh sách tài khoản");
            System.out.println("2. Thêm tài khoản quản trị");
            System.out.println("3. Cập nhật tài khoản quản trị");
            System.out.println("4. Cập nhật trạng thái tài khoản khách");
            System.out.println("5. Tìm kiếm tài khoản khách theo tên đăng nhập hoặc tên chủ tài khoản");
            System.out.println("6. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = false;
                    break;
                default:
            }
        } while (exit);

    }

    public static void displayMenuOrderManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******Menu quản lý đơn hàng******");
            System.out.println("1. Xem chỉ tiết thông tin đơn hàng");
            System.out.println("2. Xem trạng thái đơn hàng");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    exit = false;
                    break;
                default:
            }
        } while (exit);
    }

    public static void displayMenuFeedbackManagement(Scanner sc) {
        Feedback feedb = new Feedback();
        List<Feedback> listfeeb = feedb.readFromFile();
        for (Feedback f : listfeeb) {
            feedb.displayData(f);
        }
    }


}

