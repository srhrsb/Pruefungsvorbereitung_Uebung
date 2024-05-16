package dao;

import model.Room;
import model.RoomType;
import model.Visitor;

import java.util.ArrayList;
import java.util.List;

public class TempRoomDAO implements RoomDAO{
    private List<Room> rooms = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();

    public TempRoomDAO(){
         addRoom(1, RoomType.BED1);
         addRoom(2,RoomType.BED2);
         addRoom(3,RoomType.BED2);
         addRoom(4, RoomType.BED4);

         addVisitor("Hotel-ID-GlFr123456", "Glunk","Frank");
         addVisitor("Hotel-ID-DiTi123456", "Dittmar","Till");
         addVisitor("Hotel-ID-JoJa123456", "Jovanova","Jana");
         addVisitor("Hotel-ID-TeJo123456", "Tetteh","Jonathan");
         addVisitor("Hotel-ID-HoTi123456", "Hollmann","Tilman");
    }

    @Override
    public boolean addRoom( int roomNumber, RoomType bed){
        Room room = new Room(roomNumber, bed);
        boolean changed = rooms.add(room);
        return changed;
    }

    @Override
    public boolean addVisitor( String visitorId, String name, String firstName ){
        if (!visitorIdIsUnique(visitorId))
            return false;

        Visitor visitor = new Visitor(visitorId, name, firstName);
        boolean changed = visitors.add(visitor);
        return changed;
    }

    @Override
    public boolean visitorIdIsUnique( String visitorId){
        for (var visitor : visitors){
            if( visitorId.equals(visitor.getId()) ){
               return false;
            }
        }
        return true;
    }

    @Override
    public Room getRoomByRoomNumber( int roomNumber){
        for (var room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    @Override
    public Visitor getVisitorById( String visitorId ){
        for (var visitor : visitors){
            if(visitor.getId().equals(visitorId)){
                return visitor;
            }
        }
        return null;
    }

    @Override
    public  boolean deleteVisitorById( String visitorId ){
        for (var visitor : visitors){
            if(visitor.getId().equals(visitorId)){
               return visitors.remove(visitor);
            }
        }
        return false;
    }
}
