package view;

import model.RoomType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JTextField roomNumberTf, roomVistorIdTf, visitorIdTf, visitorNameTf, visitorFirstNameTf;
    private JLabel bedLabel;
    private JButton getRoomButton, checkinButton, saveVisitorButton, deleteVisitorButton;

    private JComboBox<RoomType> roomTypeComboBox;

    public MainView(int width, int height){
        setSize(width, height);
        setTitle("Hotelmanager");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addUIComponents();
        setVisible(true);
        pack();
    }

    private void addUIComponents(){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(10,2));
        centerPanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel bottomPanel = new JPanel();



        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);

        //Button
        saveVisitorButton = new JButton("Besucher anlegen");

        checkinButton = new JButton("Einchecken");
        checkinButton.setEnabled(false);

        getRoomButton = new JButton("Zimmer anfordern");
        deleteVisitorButton = new JButton("Gastdaten löschen");

        //Textfields
        roomNumberTf = new JTextField();
        roomVistorIdTf = new JTextField();
        roomVistorIdTf.setEditable(false);

        visitorIdTf = new JTextField();
        visitorNameTf = new JTextField();
        visitorFirstNameTf = new JTextField();

        //Label
        bedLabel = new JLabel();
        roomTypeComboBox = new JComboBox<RoomType>( RoomType.values() );

        //Add UI Components
        bottomPanel.add(getRoomButton);
        bottomPanel.add(checkinButton);
        bottomPanel.add(saveVisitorButton);
        bottomPanel.add(deleteVisitorButton);

        centerPanel.add(new JLabel("Zimmernummer"));
        centerPanel.add(roomNumberTf);

        centerPanel.add(new JLabel("Bettenanzahl"));
        //centerPanel.add(bedLabel);
        centerPanel.add(roomTypeComboBox);

        centerPanel.add(new JLabel("Gast-ID"));
        centerPanel.add(roomVistorIdTf);


        //Visitors
        centerPanel.add(new JLabel());
        centerPanel.add(new JLabel());
        centerPanel.add(new JLabel("Gastdaten"));
        centerPanel.add(new JLabel());


        centerPanel.add(new JLabel("Gast-ID"));
        centerPanel.add(visitorIdTf);

        centerPanel.add(new JLabel("Name"));
        centerPanel.add(visitorNameTf);

        centerPanel.add(new JLabel("Vorname"));
        centerPanel.add(visitorFirstNameTf);




    }

    //Eventhandler----------------------------------------------
    public void addGetRoomHandler(ActionListener listener){
        getRoomButton.addActionListener(listener);
    }

    public void addCheckInHandler(ActionListener listener){
        checkinButton.addActionListener(listener);
    }

    public void addSaveVisitorHandler( ActionListener listener) { saveVisitorButton.addActionListener(listener);}

    public void addDeleteVisitorHandler( ActionListener listener) { deleteVisitorButton.addActionListener(listener);}


    //Aufgabe
    //ToDo: Handler für das anlegen eines Nutzers
    //ToDo: Getter für Textfelder von Visitor
    //ToDO: im Controller Funktion für Hinzufügen eines Nutzers

    //<editor-fold desc="Textfield Getter">

    /**
     * Gets current room number from text field
     * @return room number
     */
    public int getRoomNumberValue(){

        int nr = 0;
        try {
            nr = Integer.parseInt( roomNumberTf.getText() );
            if (nr <= 0){
                nr = 0;
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ungültiger Wert für Raumnummer");
            //Fehlermeldung an Nutzer ausgeben
        }

        return nr;
    }

    /**
     * Gets current visitorID from text field
     * @return visitorID
     */
    public String getVisitorIdValue(){
        return visitorIdTf.getText();
    }

    /**
     * Gets Visitor Name from text field
     * @return name
     */
    public String getVisitorName(){
           return visitorNameTf.getText();
    }

    /**
     * Gets Visitor First Name from text field
     * @return name
     */
    public String getVisitorFirstName(){
        return visitorFirstNameTf.getText();
    }


    //</editor-fold>

    //<editor-fold desc="Textfield Setter">

    public void setBedLabel( int bedCount ){
        bedLabel.setText( String.valueOf(bedCount) );
    }

    public void setBedComboBox( RoomType bed ){
        roomTypeComboBox.setSelectedItem( bed );
    }

    public void setRoomVisitorIdTf( String visitorId ){
        roomVistorIdTf.setText( visitorId );
    }

    public void setVisitorIdTf( String visitorId ){
        visitorIdTf.setText( visitorId );
    }

    public void setVisitorNameTf( String visitorName ){
        visitorNameTf.setText( visitorName );
    }

    public void setVisitorFirstNameTf( String visitorFirstName ){
        visitorFirstNameTf.setText( visitorFirstName );
    }

    //</editor-fold>

    public void showInfoMessage(String message){
        JOptionPane.showMessageDialog(this, message,"Info",
                                        JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message,"Fehler",
                JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmDialog(String message){
     return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
                this, message,
                "Bitte bestätigen",
                JOptionPane.YES_NO_OPTION);
    }




}
