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
        mainView.addSaveVisitorHandler(this::saveVisitor);

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
                    mainView.showInfoMessage("Raum ist nicht belegt");
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

    public void saveVisitor(ActionEvent event){
        int visitorId = mainView.getVisitorIdValue();
        String name  = mainView.getVisitorName();
        String firstName  = mainView.getVisitorFirstName();

        if(visitorId > 0){
            boolean success = hotelDB.addVisitor(visitorId, name, firstName );

            if(success == true){
                mainView.showInfoMessage("Neuer Gast wurde angelegt:\n"+name+", "+firstName+
                                         "\nKundennummer: "+visitorId);
            }
            else{
                mainView.showErrorMessage("Neuer Gast konnte nicht angelegt werden");
            }
        }
    }
}

//Aufgabe 1
//ToDo: Holen Sie die ID des Gastes nicht mehr vom Textfeld sondern schreiben Sie
//ToDo: eine zusätzliche Methode, die aus dem String "Hotel-ID-" und den ersten
//ToDo: beiden Buchstaben von Vor und Nachnamen und einer 6 stelligen Zufallszahl
//      eine Id erzeugt
//ToDo: Sie müssen anschließend alle Typen dieser ID sowie Getter und Setter abändern,
//TODO: den die ID ist nun ein String

//Aufgabe 2
//Todo: Tragen Sie die erzeugte GastID auch gleich in beide GastID-Felder ein

//Aufgabe 3
//Todo: Ändern Sie anschließend die addVisitorMethode in RoomDAO so ab, dass bei
//ToDo: bereits vorhandener ID ein Eintrag nicht möglich ist