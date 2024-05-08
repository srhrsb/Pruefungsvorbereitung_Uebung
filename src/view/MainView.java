package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JTextField roomNumberTf, roomVistorIdTf, visitorIdTf, visitorNameTf, visitorFirstNameTf;
    private JLabel bedLabel;
    private JButton getRoomButton, checkinButton, saveVisitorButton;

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

        //Textfields
        roomNumberTf = new JTextField();
        roomVistorIdTf = new JTextField();
        roomVistorIdTf.setEditable(false);

        visitorIdTf = new JTextField();
        visitorNameTf = new JTextField();
        visitorFirstNameTf = new JTextField();

        //Label
        bedLabel = new JLabel();

        //Add UI Components
        bottomPanel.add(getRoomButton);
        bottomPanel.add(checkinButton);
        bottomPanel.add(saveVisitorButton);

        centerPanel.add(new JLabel("Zimmernummer"));
        centerPanel.add(roomNumberTf);

        centerPanel.add(new JLabel("Bettenanzahl"));
        centerPanel.add(bedLabel);

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

    //</editor-fold>

    //<editor-fold desc="Textfield Setter">

    public void setBedLabel( int bedCount ){
        bedLabel.setText( String.valueOf(bedCount) );
    }

    public void setRoomVisitorIdTf( int visitorId ){
        roomVistorIdTf.setText( String.valueOf(visitorId) );
    }

    public void setVisitorIdTf( int visitorId ){
        visitorIdTf.setText( String.valueOf(visitorId) );
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
