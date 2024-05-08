package controller;

import dao.RoomDAO;
import model.Room;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private RoomDAO hotelDB;
    private MainView mainView;

    public MainController(RoomDAO hotelDB, MainView mainView){
        this.hotelDB = hotelDB;
        this.mainView = mainView;

        mainView.addGetRoomHandler(this::getRoom);

//        Room room = hotelDB.getRoomByRoomNumber(1);
//        System.out.println(room.getBed());
    }

    public static void main(String[] args) {
       new MainController(
             new RoomDAO(), new MainView(500, 600)
       );
    }

    /**
     * Obtains the room data of the currently entered room number
     * and passes it to the user interface
     * @param event
     */
    public void getRoom( ActionEvent event){
        int roomNumber = mainView.getRoomNumberValue();

        if(roomNumber > 0){
            Room room = hotelDB.getRoomByRoomNumber(roomNumber);

            if(room != null){
                mainView.setBedLabel(room.getBed());
                mainView.setRoomVisitorIdTf(room.getVisitorId());

                if(room.getVisitorId()!=0){
                    //Raum ist belegt
                    //ToDo: Besucherdaten anzeigen
                }
                else{
                    //Raum ist leer
                    //ToDo:Fenstermeldung ausgeben, dass Raum leer ist
                }
            }
            else{
                System.out.println("Raum existiert nicht");
            }
        }
        else{
            System.out.println("Raum existiert nicht");
        }



    }

}