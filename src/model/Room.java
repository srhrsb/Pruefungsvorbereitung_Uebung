package model;

public class Room {

    private int roomNumber;
    private RoomType bed;
    private String visitorId;

    public Room(int roomNumber, RoomType bed) {
        this.roomNumber = roomNumber;
        this.bed = bed;
        this.visitorId = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getBed() {
        return bed;
    }

    public void setBed(RoomType bed) {
        this.bed = bed;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }
}
