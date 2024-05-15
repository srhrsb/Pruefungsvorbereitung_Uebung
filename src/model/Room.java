package model;

public class Room {

    private int roomNumber;
    private int bed;
    private String visitorId;

    public Room(int roomNumber, int bed) {
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

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }
}
