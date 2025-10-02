import java.util.*;
public class UserService {
    private Map<String,User> userMap=new HashMap<>();
    private User currentUser=null;


    public boolean registerUser(String userName,String password,String full_name,String contactNo ){
        if(userMap.containsKey(userName)){
            System.out.print("Username already exist please choose another");
            return false;
        }
        User user=new User(userName,password,contactNo,full_name);
        userMap.put(userName,user);
        System.out.println("Registration successfull");
        return true;
    }

    public boolean logIn(String userName,String password){
        if(!userMap.containsKey(userName)){
            System.out.print("No user found with this name");
            return false;
        }
       User user=userMap.get(userName);
        if(!user.getPassword().equals(password)){
            System.out.print("Incorrect password");
            return false;
        }
        currentUser=user;
        System.out.print("welcome :"+currentUser.getFull_name()+"!");
        return true;
    }

    public void logout(){
        if(currentUser!=null){
            System.out.print("looged out :"+currentUser);
        }
        currentUser=null;
    }

    public User getcurrentuser(){
        return currentUser;
    }

    public boolean islogIn(){
        return currentUser!=null;
    }


}
