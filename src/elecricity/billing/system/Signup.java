package elecricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
        Choice loginACho;
        TextField meterText, EmployerText, userNameText, nameText, passwordText;
        JButton create, back;
    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);


        loginACho = new Choice();
        loginACho.add("Admin");
        loginACho.add("Customer");
        loginACho.setBounds(170,50,125,20);
        add(loginACho);


        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        setVisible(false);
        add(meterText);

        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30,100,125,20);
        Employer.setVisible(true);
        add(Employer);

        EmployerText = new TextField();
        EmployerText.setBounds(170,100,125,20);
        EmployerText.setVisible(true);
        add(EmployerText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup where meter_no = '"+meterText.getText()+"'");
                    if (resultSet.next());
                        nameText.setText(resultSet.getString("name"));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText = new TextField("");
        nameText.setBounds(170,180,125,20);
        add(nameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);


        loginACho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginACho.getSelectedItem();
                if (user.equals("Customer")){
                    Employer.setVisible(false);
                    nameText.setEditable(false);
                    EmployerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                } else {
                    Employer.setVisible(true);
                    EmployerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        create = new JButton("Create");
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.BLACK);
        create.setBounds(50,285,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(66, 127, 219));
        back.setForeground(Color.BLACK);
        back.setBounds(190,285,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon boy = new ImageIcon(ClassLoader.getSystemResource("icon/add.png"));
        Image boyImg = boy.getImage().getScaledInstance(240,240,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyJLabel = new JLabel(boyIcon2);
        boyJLabel.setBounds(305,30,280,280);
        add(boyJLabel);


        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String sloginAs = loginACho.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();

            // Validation
            if (susername.isEmpty() || sname.isEmpty() || spassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields!");
                return;
            }

            try {
                database c = new database();
                if (loginACho.equals("Admin")) {
//                    JOptionPane.showMessageDialog(this, "Database connection failed! Please check MySQL server.");
//                    return;

                } else {
//                    query = "update Signup set username = '"+susername+"', password = '"+spassword+"', usertype = '"+sloginAs+"', where meter_no = '"+smeter+"'";
                }
                String query = "insert into Signup (meter_no, username, name, password, usertype) values ('"+smeter+"' , '"+susername+"','"+sname+"','"+spassword+"','"+sloginAs+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Account created successfully!");
                setVisible(false);
                new Login();
            }catch (Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + E.getMessage());
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();

        }
    }

    public static void main(String[] args){
        new Signup();
    }
}
