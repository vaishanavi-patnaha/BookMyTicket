import java.util.*;
public class IRCTCAPP {
    private final Scanner scanner=new Scanner(System.in);

    private final UserService userService=new UserService();

    private final BookingService bookingService=new BookingService();

    public static void main(String[] args){
        new IRCTCAPP().start();
    }
    public void start(){
          while(true){
              System.out.println("-------Welcome to IRCTC APP------- ");
              if(!userService.islogIn()){

                  System.out.println("1.  Register");
                  System.out.println("2.  Login");
                  System.out.println("3.  Exit.");
                  System.out.println("Enter Choice ");
                  int choice=scanner.nextInt();
                 switch(choice){

                     case 1->Register();
                     case 2->Login();
                     case 3->exitApp();
                     default-> System.out.println("Invalid Choice");
                 }

              }
              else{
                  showUserMenu();
              }
          }
    }


    public void Register(){
        System.out.print("Enter username : ");
        String username=scanner.next();

        System.out.print("Enter password : ");
        String password=scanner.next();

        System.out.print("Enter fullname : ");
        scanner.nextLine();
        String full_name=scanner.nextLine();

        System.out.print("Enter contactno : ");
        String contact=scanner.next();
       boolean registered=userService.registerUser(username,password,full_name,contact);
       if(registered){
           userService.logIn(username,password);
           System.out.println("Registered and logged in as "+ username);
           showUserMenu();
       }
       else{
           System.out.println("Registration failed!!!! try again.....");
       }


    }

    public void Login(){
        System.out.print("Enter username : ");
        String username=scanner.next();

        System.out.print("Enter password : ");
        String password=scanner.next();

        userService.logIn(username,password);
    }

    private void showUserMenu(){

        while(userService.islogIn())
        {
                System.out.println("\n----------User Menu-------------");
                System.out.println("1. Search Trains.");
                System.out.println("2. Book Ticket");
                System.out.println("3. View My Tickets");
                System.out.println("4. Cancel Tickets");
                System.out.println("5. View All Trains");
                System.out.println("6. Logout:");
                System.out.println("Enter Choice : ");
                int choice=scanner.nextInt();
                 switch(choice){

                case 1->searchTrain();
                case 2->bookTicket();
                case 3->viewMyTicket();
                case 4->cancelTicket();
                case 5->bookingService.lisOfAllTrain();
                case 6->userService.logout();
                default->System.out.println("Invalid Choice");

            }

            }

        }

    private void exitApp(){
        System.out.println("Thank you for using IRCTC App");
        System.exit(0);
    }

    private void searchTrain(){
        System.out.print("Enter source : ");
        String source=scanner.next();

        System.out.print("Enter destination : ");
        String destination=scanner.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.print("No Trains Found between "+source +"and"+destination);
        }
        System.out.println("Trains Found");
        for(Train train:trains){
            System.out.print(train);
        }
        System.out.println("Do you want to book Ticket ? (yes/no)");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.print("Enter TrainId to Book : ");
            int trainID=scanner.nextInt();

            System.out.println("Enter number of seats : ");
            int seats=scanner.nextInt();

            Ticket ticket=bookingService.bookTicket(userService.getcurrentuser(),trainID,seats);
            if(ticket!=null){
               System.out.println("Booking Successful :");
               System.out.println(ticket);
            }

        }
        else{
            System.out.println("Returning to userMenu");
        }
    }
    public void bookTicket(){
        System.out.print("Enter source : ");
        String source=scanner.next();

        System.out.print("Enter destination : ");
        String destination=scanner.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.print("No Trains Available between "+source +"and"+destination);
        }
        System.out.println("Trains Available :");
        for(Train train:trains){
            System.out.print(train);
        }
            System.out.println("Enter TrainId to Book : ");
            int trainID=scanner.nextInt();

            System.out.println("Enter number of seats : ");
            int seats=scanner.nextInt();

            Ticket ticket=bookingService.bookTicket(userService.getcurrentuser(),trainID,seats);
            if(ticket!=null){
                System.out.println("Booking Successful :");
                System.out.println(ticket);
            }

    }
private void viewMyTicket(){
    List<Ticket> ticketbyUser=bookingService.getTicketByuser(userService.getcurrentuser());
    if(ticketbyUser.isEmpty()){
        System.out.print("No Ticket Bokked yet");
    }
    else{
        for(Ticket ticket:ticketbyUser){
            System.out.print(ticket);
        }
    }
}

private void cancelTicket(){
        System.out.println("Enter trainId to cancel");
        int ticketId=scanner.nextInt();
        bookingService.cancelTicket(ticketId,userService.getcurrentuser());

}


}
