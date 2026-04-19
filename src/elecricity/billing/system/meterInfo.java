package elecricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener{

    Choice meterLocCho, meterTypCho, phaseCodeCho, billTypCho;
    JButton submit;

    String meternumber;

    meterInfo(String meternumber){
        this.meternumber=meternumber;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(237, 155, 5));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meterNumberText = new JLabel(meternumber);
        meterNumberText.setBounds(180,80,150,20);
        panel.add(meterNumberText);

        JLabel meterLoc= new JLabel("Meter");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        meterTypCho = new Choice();
        meterTypCho.add("Electric Meter");
        meterTypCho.add("Solar Meter");
        meterTypCho.add("Smart Meter");
        meterTypCho.setBounds(180,160,150,20);
        panel.add(meterTypCho);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("07");
        phaseCodeCho.add("014");
        phaseCodeCho.add("021");
        phaseCodeCho.add("028");
        phaseCodeCho.add("035");
        phaseCodeCho.add("042");
        phaseCodeCho.add("049");
        phaseCodeCho.add("056");
        phaseCodeCho.add("063");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        JLabel billTyp = new JLabel("Bill Type");
        billTyp.setBounds(50,240,100,20);
        panel.add(billTyp);

        billTypCho = new Choice();
        billTypCho.add("Normal");
        billTypCho.add("Industrial");
        billTypCho.setBounds(180,240,150,20);
        panel.add(billTypCho);

        JLabel day = new JLabel("30 Days Billing Time...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("By default bill is calculated for 30 days only");
        note1.setBounds(50,340,260,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,20);
        submit.setBackground(Color.lightGray);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLable = new JLabel(i3);
        add(imgLable, "East");



        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String smeterNum = meternumber;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterTyp = meterTypCho.getSelectedItem();
            String sphasecode = phaseCodeCho.getSelectedItem();
            String sbillTyp = billTypCho.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info values('"+smeterNum+"','"+smeterLoc+"', '"+smeterTyp+"', '"+sphasecode+"', '"+sbillTyp+"', '"+sday+"')";
            try {
                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null,"Meter Information submitted successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new meterInfo("");

    }
}
