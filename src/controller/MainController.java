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

    public void getRoom( ActionEvent event){
        //Funktion
        System.out.println("get room gedrückt");

    }

}