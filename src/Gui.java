import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;



public class Gui extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3;
    //JTextField textField1, textField2;
    JPanel panelBG;
    JTextArea textArea1, textArea2;
    JScrollPane scrollPane1, scrollPane2;
    Font font1 = new Font("MV Boli",Font.BOLD,20);
    createWord createWord = new createWord();
    StringBuilder builder ;
    JComboBox comboBox, comboBox2;
    JPanel jPanel;

    Gui(){
        panelBG = new JPanel();
        panelBG.setPreferredSize(new Dimension(800,800));
        
        
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(font1);
        textArea1.setPreferredSize(new Dimension(750,300));
        scrollPane1 = new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea1.setLineWrap(true);
        panelBG.add(scrollPane1);

        String[] theme = {"Gray theme","Hacker theme","drak theme"};
        comboBox2 = new JComboBox<>(theme);
        comboBox2.setSelectedIndex(0);
        comboBox2.setPreferredSize(new Dimension(200,50));
        comboBox2.addActionListener(this);
        comboBox2.setFont(font1);
        panelBG.add(comboBox2);

        panelBG.add(new JLabel("                                                     "));
        Integer[] word = {5,10,15,20,30};
        comboBox = new JComboBox<>(word);
        comboBox.setPreferredSize(new Dimension(100,50));
        comboBox.addActionListener(this);
        comboBox.setFont(font1);
        panelBG.add(comboBox);

        btn1 = new JButton("Word");
        btn1.setFocusable(false);
        btn1.setFont(font1);
        btn1.setPreferredSize(new Dimension(100,50));
        btn1.addActionListener(this);
        panelBG.add(btn1);

        textArea2 = new JTextArea();
        textArea2.setFont(font1);
        textArea2.setPreferredSize(new Dimension(750,300));
        scrollPane2 = new JScrollPane(textArea2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea2.setLineWrap(true);
        panelBG.add(scrollPane2);

        btn2 = new JButton("Done");
        btn2.setFocusable(false);
        btn2.setFont(font1);
        btn2.setPreferredSize(new Dimension(100,50));
        btn2.addActionListener(this);
        panelBG.add(new JLabel("                                                                                                                                                           "));
        
        panelBG.add(btn2);
        
        this.setTitle("Yuri Type");
        this.add(panelBG);
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if(e.getSource()==btn1){
            createWord.generateRandomWords((int)comboBox.getSelectedItem());
            textArea1.setText(createWord.arrToString());

        }else if(e.getSource()==btn2){
            StringBuilder builder =new StringBuilder();
            builder.append(textArea2.getText());
            if(createWord.arrToString().equals(builder.toString())){
                textArea1.setText("");
                textArea2.setText("");
                btn1.setVisible(true);
                JOptionPane.showMessageDialog(this, "excellent");
            }else{
                JOptionPane.showMessageDialog(this, "word mismatch");
            }
        
    

        }else if(comboBox2.getSelectedIndex()==0){
            panelBG.setBackground(Color.LIGHT_GRAY);
            textArea1.setForeground(Color.BLACK);
            textArea1.setBackground(Color.WHITE);
            textArea2.setForeground(Color.BLACK);
            textArea2.setBackground(Color.WHITE);
            
        }else if(comboBox2.getSelectedIndex()==1){
            panelBG.setBackground(Color.black);
            textArea1.setForeground(Color.green);
            textArea1.setBackground(new Color(202020));
            textArea2.setForeground(Color.green);
            textArea2.setBackground(new Color(202020));
        }else if(comboBox2.getSelectedIndex()==2){
            panelBG.setBackground(Color.black);
            panelBG.setBackground(Color.black);
            textArea1.setForeground(Color.white);
            textArea1.setBackground(new Color(77,73,89));
            textArea2.setForeground(Color.white);
            textArea2.setBackground(new Color(77,73,89));
            
       }
    }catch(Exception ullPointerException){
        JOptionPane.showMessageDialog(this, "Please create text");
    }

    }

}
