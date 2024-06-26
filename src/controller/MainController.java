package controller;

import dao.RoomDAO;
import dao.TempRoomDAO;
import model.Room;
import model.Visitor;
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
        mainView.addDeleteVisitorHandler(this::deleteVisitor);
        mainView.addCheckInHandler(this::checkIn);

//        Room room = hotelDB.getRoomByRoomNumber(1);
//        System.out.println(room.getBed());
    }

    public static void main(String[] args) {
       new MainController(
             new TempRoomDAO(), new MainView(500, 600)
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
                mainView.setBedComboBox( room.getBed() );
                mainView.setRoomVisitorIdTf(room.getVisitorId());

                if(room.getVisitorId() != null && room.getVisitorId().contains("Hotel-ID-")){

                    //ToDo: Besucherdaten anzeigen
                    String visitorId = room.getVisitorId();
                    Visitor visitor = hotelDB.getVisitorById(visitorId);

                    if(visitor != null){
                        mainView.setRoomVisitorIdTf(visitorId);
                        mainView.setVisitorIdTf(visitorId);
                        mainView.setVisitorNameTf(visitor.getName());
                        mainView.setVisitorFirstNameTf(visitor.getFirstName());
                    }
                }
                else{
                    mainView.showInfoMessage("Raum ist nicht belegt");
                    mainView.setVisitorNameTf("");
                    mainView.setVisitorFirstNameTf("");
                    mainView.setVisitorIdTf("");
                    mainView.setRoomVisitorIdTf("");
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

        String name  = mainView.getVisitorName();
        String firstName  = mainView.getVisitorFirstName();
        String visitorId = createVisitorId(name, firstName);

        if( visitorId != null && visitorId.contains("Hotel-ID-") ){
            boolean success = hotelDB.addVisitor(visitorId, name, firstName );

            if(success){
                mainView.showInfoMessage("Neuer Gast wurde angelegt:\n"+name+", "+firstName+
                                         "\nKundennummer: "+visitorId);
                mainView.setVisitorIdTf( visitorId );
                mainView.setRoomVisitorIdTf( visitorId );
                mainView.enableCheckIn(true);
            }
            else{
                mainView.showErrorMessage("Neuer Gast konnte nicht angelegt werden");
            }
        }
    }

    public void deleteVisitor(ActionEvent event){

         String visitorId = mainView.getVisitorIdValue();
         Visitor visitor = hotelDB.getVisitorById( visitorId );

         if(visitor == null){
             mainView.showInfoMessage("Ein Gast mit der ID: "
                      +visitorId+ " ist nicht eingetragen");

             return;
         }

         String text = "Soll dieser Nutzer wirklich gelöscht werden?\n" +
                       "Id: "+visitor.getId() + "\n"+
                       "Name: "+visitor.getName() +"\n"+
                       "Vorname: "+visitor.getFirstName() +"\n";

         if(mainView.confirmDialog(text)){
             if(hotelDB.deleteVisitorById(visitorId)){
                 mainView.showInfoMessage("Der Nutzer wurde gelöscht");
             }
             else{
                 mainView.showErrorMessage(
                         "Der Nutzer konnte nicht gelöscht werden"
                          );
             }
         }
    }

    public void checkIn( ActionEvent event ){
        String visitorId = mainView.getVisitorIdValue();
        int roomNumber = mainView.getRoomNumberValue();
        Room room = hotelDB.getRoomByRoomNumber( roomNumber );

        if(room != null){
            if( hotelDB.checkIn( roomNumber, visitorId)){
                mainView.showInfoMessage("Gast mit der Id: "+visitorId+
                        "erfolgreich eingecheckt"
                        );
            }
            else{
                mainView.showErrorMessage("Einchecken nicht möglich");
            }
        }
    }

    public String createVisitorId( String name, String firstName){

         return "Hotel-ID-" + name.substring(0,2)
                 + firstName.substring(0,2)
                 + (int)(Math.random() * 999999 );
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

//Aufgabe 4
//Fügen Sie einen Button hinzu "Benutzer löschen"
//und sorgen Sie dafür, dass der Nutzer mit der eingegebenen ID gelöscht wird.
//Holen Sie zuvor die Einwilligung ein und zeigen Sie dazu auch schon alle Daten des Nutzers an
//Löschen Sie den Nutzer nur nach Bestätigung, ansonsten nicht.
