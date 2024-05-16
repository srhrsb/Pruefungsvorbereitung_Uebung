package dao;

import model.Room;
import model.RoomType;
import model.Visitor;

public interface RoomDAO {

    public boolean addRoom( int roomNumber, RoomType bed);

    public boolean addVisitor( String visitorId, String name, String firstName );

    public boolean visitorIdIsUnique( String visitorId);

    public Room getRoomByRoomNumber( int roomNumber);

    public Visitor getVisitorById( String visitorId );

    public  boolean deleteVisitorById( String visitorId );

}
