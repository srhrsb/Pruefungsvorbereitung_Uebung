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

         addVisitor("Hotel-ID-GlFr123456", "Glunk","Frank");
         addVisitor("Hotel-ID-DiTi123456", "Dittmar","Till");
         addVisitor("Hotel-ID-JoJa123456", "Jovanova","Jana");
         addVisitor("Hotel-ID-TeJo123456", "Tetteh","Jonathan");
         addVisitor("Hotel-ID-HoTi123456", "Hollmann","Tilman");
    }

    public boolean addRoom( int roomNumber, int bed){
        Room room = new Room(roomNumber, bed);
        boolean changed = rooms.add(room);
        return changed;
    }

    public boolean addVisitor( String visitorId, String name, String firstName ){
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
