package dao;

import model.Room;
import model.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private List<Room> rooms = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();

    public RoomDAO(){
         addRoom(1, 2);
         addRoom(2,2);
         addRoom(3,4);
         addRoom(4, 1);

         addVisitor(1, "Glunk","Frank");
         addVisitor(2, "Dittmar","Till");
         addVisitor(3, "Jovanova","Jana");
         addVisitor(4, "Tetteh","Jonathan");
         addVisitor(5, "Hollmann","Tilman");
    }

    public boolean addRoom( int roomNumber, int bed){
        Room room = new Room(roomNumber, bed);
        boolean changed = rooms.add(room);
        return changed;
    }

    public boolean addVisitor( int visitorId, String name, String firstName ){
        Visitor visitor = new Visitor(visitorId, name, firstName);
        boolean changed = visitors.add(visitor);
        return changed;
    }

    public Room getRoomByRoomNumber( int roomNumber){
        for (var room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }
}
