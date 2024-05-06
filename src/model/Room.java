package model;

public class Room {

    private int roomNumber;
    private int bed;
    private int visitorId;

    public Room(int roomNumber, int bed) {
        this.roomNumber = roomNumber;
        this.bed = bed;
        this.visitorId = 0;
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

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }
}
