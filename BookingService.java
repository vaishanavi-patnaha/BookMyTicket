import java.util.*;
public class BookingService {
      private List<Train> trainList=new ArrayList<>();
      private List<Ticket> ticketList=new ArrayList<>();

      public BookingService(){
          trainList.add(new Train(101,"Rajdhani Express","Delhi","nagpur",100));
          trainList.add(new Train(102,"Rewanchal Express","Satna","Bhopal",80));
          trainList.add(new Train(103,"vande Bharat Express","Delhi","Bhopal",100));
          trainList.add(new Train(104,"Itarsi ","Satna","Mumbai",108));
          trainList.add(new Train(105,"Bhopal SF Express","Bhopal","rewa",120));
          trainList.add(new Train(106,"kamayaniExpress","rewa","Mumbai",10));
          trainList.add(new Train(107,"superfast Express","katni","Satna",90));
          trainList.add(new Train(108,"Shatabdi Express","Delhi","Mumbai",110));
      }
    public List<Train> searchTrain(String source,String destination){
          List<Train> res=new ArrayList<>();
          for(Train train:trainList){
              if(train.getSource().equalsIgnoreCase(source)&&train.getDestination().equalsIgnoreCase(destination)){
                  res.add(train);
              }
          }
          return res;
    }
    public Ticket bookTicket(User user,int trainId,int seatCount){
          for(Train train:trainList){
              if(train.getTrain_id()==trainId){
                  if(train.bookSeats(seatCount)){
                      Ticket ticket=new Ticket(user,train,seatCount);
                      ticketList.add(ticket);
                      return ticket;
                  }
                  else{
                      System.out.print("Not enough seats available");
                      return null;
                  }
              }

          }
        System.out.print("TrainID not found");
        return null;

    }

    public List<Ticket> getTicketByuser(User user){
          List<Ticket> res=new ArrayList<>();
          for(Ticket ticket:ticketList){
              if(ticket.getUser().equals(user)){
                  res.add(ticket);
              }
          }
          return res;
      }

      public boolean cancelTicket(int ticketId ,User user){
          Iterator<Ticket> iterator=ticketList.listIterator();
          while(iterator.hasNext()){
              Ticket ticket=iterator.next();
              if(ticket.getTicketId()==ticketId&&
                      ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                  Train train=ticket.getTrain();
                  train.cancel(ticket.getSeatBooked());
                  iterator.remove();
                  System.out.print("Ticket"+ticketId+" cancelled sucessfully");
                  return true;
              }
          }
          System.out.print("Ticket not found or does not belong to current user");
          return false;
      }

      public void lisOfAllTrain(){
          System.out.print("List of all trains : ");
          for(Train train:trainList){
              System.out.print(train);
          }
      }
}
