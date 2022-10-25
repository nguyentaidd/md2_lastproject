package ra.business.entity;

import ra.business.Imp.UserImp;
import ra.business.config.ShopConstant;
import ra.business.design.IShop;
import ra.business.file.FileAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feedback implements IShop<Feedback, Integer> {


    private int id;
    private int userId;
    private String content;

    public Feedback() {
    }

    public Feedback(int id, int userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public boolean create(Feedback feedback) {
        List<Feedback> feedbackList = readFromFile();
        if (feedbackList==null){
            feedbackList = new ArrayList<>();
        }
        feedbackList.add(feedback);
        boolean result = writeFromFile(feedbackList);
        return result;
    }

    @Override
    public boolean update(Feedback feedback) {
        return false;
    }

    @Override
    public List<Feedback> findAll() {
        return readFromFile();
    }

    @Override
    public Feedback inputData(Scanner sc) {
        return null;
    }

    @Override
    public void displayData(Feedback feedback) {
        UserImp userImp = new UserImp();
        List<User> users = userImp.findAll();
        String userName = null;
        for (User u: users) {
            if (u.getUserId()== feedback.getUserId()){
                userName = u.getUserName();
                break;
            }
        }
        
        System.out.printf("Mã id: %-10s  Tên người dùng: %-30s  Nội dung: %-20s\n",
                feedback.getId(),userName, feedback.getContent());
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    public Feedback inputData2(Scanner sc, int userId) {
        Feedback f = new Feedback();
        f.setId(getId());
        f.setUserId(userId);
        System.out.println("Nội dung phản hồi: ");
        do {
            String content = sc.nextLine();
            if (content==""){
                System.err.println("Không được để trống!");
                continue;
            } else{
                f.setContent(content);
                break;
            }
        } while (true);
        return f;
    }
    public int getnewId(){
        List<Feedback> list = readFromFile();
        int id;
        if (list == null){
            id=1;
        }else {
            int maxId = 1;
            for (Feedback f:list) {
                if (f.getId()>maxId){
                    maxId= f.getId();
                }
            }
            id=maxId+1;
        }
        return id;
    }

    public List<Feedback> readFromFile(){
        FileAll<Feedback> fileAll = new FileAll<>();
        List<Feedback> list = fileAll.readFromFile(ShopConstant.FEEDBACK_URL);
        return list;
    }

    public boolean writeFromFile (List<Feedback> list){
        FileAll<Feedback> fileAll = new FileAll<>();
        boolean returnData = fileAll.writeFromFile(list,ShopConstant.FEEDBACK_URL);
        return returnData;
    }



}
