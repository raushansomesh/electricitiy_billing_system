package elecricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_information extends JFrame implements ActionListener {
    String view;
    JButton cancel;
    view_information(String view){
        this.view = view;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("View Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Eras Medium ITC",Font.BOLD,20));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(70,80,100,20);
        add(nameLabel);

        JLabel nameLabelText = new JLabel("");
        nameLabelText.setBounds(200,80,150,20);
        add(nameLabelText);

        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(70,140,100,20);
        add(meterno);

        JLabel meternoText = new JLabel("");
        meternoText.setBounds(200,140,150,20);
        add(meternoText);

        JLabel address = new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText = new JLabel("");
        addressText.setBounds(200,200,150,20);
        add(addressText);

        JLabel city = new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText = new JLabel("");
        cityText.setBounds(200,260,150,20);
        add(cityText);

        JLabel state = new JLabel("State");
        state.setBounds(500, 80, 100, 20);
        add(state);

        JLabel stateText = new JLabel("");
        stateText.setBounds(600, 80, 150, 20);
        add(stateText);

        JLabel email = new JLabel("Email");
        email.setBounds(500,140,100,20);
        add(email);

        JLabel emailText = new JLabel("");
        emailText.setBounds(600,140,150,20);
        add(emailText);

        JLabel contactNo = new JLabel("Contact Number");
        contactNo.setBounds(500,200,100,20);
        add(contactNo);

        JLabel contactNoText = new JLabel("");
        contactNoText.setBounds(600,200,150,20);
        add(contactNoText);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meterno = '"+view+"'");
            if (resultSet.next()){
          nameLabelText.setText(resultSet.getString("name"));
          meternoText.setText(resultSet.getString("meterno"));
          addressText.setText(resultSet.getString("address"));
          cityText.setText(resultSet.getString("city"));
          stateText.setText(resultSet.getString("state"));
          emailText.setText(resultSet.getString("email"));
          contactNoText.setText(resultSet.getString("phone_no"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(24, 100,242));
        cancel.setForeground(Color.white);
        cancel.setBounds(220,350,120,25);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon boy = new ImageIcon(ClassLoader.getSystemResource("icon/viewinfo.png"));
        Image boyImg = boy.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyJLabel = new JLabel(boyIcon2);
        boyJLabel.setBounds(100,320,600,300);
        add(boyJLabel);



        setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new view_information("");
    }
}
