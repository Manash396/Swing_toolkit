import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Card implements ActionListener {
     // id
     int id = 0;// for deletion purpose 
    // constructor for backend purpose 
    JFrame frame;
    Point2D p1,p2;  
    JButton cr,button2,bup,bup2,show,add,del,clear;
    JTextField name1in,name2in;
    JPasswordField key1in,key2in;
    JTextArea area;
    //login page option 
    GradientPanel login,option,cards,card1,card2,card3,signup,signin;
     //Jpanel section okay 
     JPanel Cr,in,user,password,Bsignup,user1,password2,Bsignin,Show,Add,DAcc,upp,Area;
     // JLabel section
     JLabel label,label1,name1,key1,name2,key2;
      //Manager of cards 
      CardLayout Cmanager;
    //
    JScrollPane scroll;
    Container cont;
   // for JDBC conectivity 
    private  String url = "jdbc:mysql://localhost:3306/world";
    private String name ="remote";
    private String key = "passkey";
    private JPanel Clear;


   //

    public void run(){
      frame = new JFrame("Secure Data");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(200, 50);
      frame.setSize(650, 750);
      frame.setVisible(true);
      cont =  frame.getContentPane();

      cont.setLayout(new GridLayout(1, 2));
       // now creating point 

      p1=  new Point2D.Float(0, 0);
      p2=  new Point2D.Float(650, 750);
   
        // option 
          
       login = new GradientPanel(p1, p2, Color.BLUE, Color.ORANGE);
       login.setLayout(new BorderLayout(0, 1) );

        // Jlabel 
        label = new JLabel("Secure Your Data",SwingConstants.CENTER);
        label.setFont(new Font("Serif",Font.BOLD,18));    
        label.setOpaque(true);
        label.setForeground(Color.LIGHT_GRAY);
        label.setBackground(Color.BLUE);
        login.add(label,BorderLayout.NORTH);
        

        // option 
       option = new GradientPanel(p1, p2, Color.BLUE, Color.ORANGE);
       option.setLayout(new GridLayout(8, 1, 0, 50));
       // 
      
      option.add(new JLabel(""));
       
       Cr = new JPanel();
      
       Cr.setOpaque(false);

       cr = new JButton("Sign Up");
       cr.setBackground(Color.BLUE);
       cr.setForeground(Color.WHITE);
       cr.addActionListener(this);
        Cr.add(cr);

       option.add(Cr);
          
 // sign in 

in = new JPanel();
 in.setOpaque(false);
 
  button2 = new JButton("Sign in");
 button2.setBackground(Color.BLUE);
 button2.setForeground(Color.WHITE);
 button2.addActionListener(this);
in.add(button2);
// panel is add to panel
 option.add(in);
///////////////////////////////////////////////////////////////////////////////
       login.add(option,BorderLayout.CENTER);

         

        // card will have three layout // lets work with card now 

        cards = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
        Cmanager = new CardLayout();
       cards.setLayout(Cmanager);
       ////////////////////////////////////////////////////////////////////////////////
        // card1 (sign up)

      card1 = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
        card1.setLayout(new BorderLayout());
         
       label1 = new JLabel("Create An Account",SwingConstants.CENTER);
        label1.setFont(new Font("Serif",Font.BOLD,18));    
        label1.setBackground(Color.BLUE);
        label1.setForeground(Color.WHITE);
        card1.add(label1,BorderLayout.NORTH);

       signup = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
        signup.setLayout(new GridLayout(9, 1, 0, 20));
        // user name 
        user = new JPanel(new FlowLayout(1)); 
       user.setOpaque(false);
        name1 = new JLabel("Username:");
        name1.setFont(new Font("arial", Font.BOLD, 14));
         name1in = new JTextField(20);
        user.add(name1);
        user.add(name1in);
         // add gap 
//     password
      password = new JPanel(new FlowLayout(1));
      password.setOpaque(false);
       key1 = new JLabel("Key            :");
      name1.setFont(new Font("arial", Font.PLAIN, 14));
       key1in = new JPasswordField(20);
      password.add(key1);
      password.add(key1in);
// BUTTON TO  to create an account 
 Bsignup = new JPanel(new FlowLayout(1));
 Bsignup.setOpaque(false);
 bup = new JButton("Create");
 bup.setBackground(Color.ORANGE);
 bup.addActionListener(this);
 Bsignup.add(bup);


        signup.add(new JLabel(""));
        signup.add(user);
        signup.add(password);
        signup.add(Bsignup);// adding panel with button 
        
          


   card1.add(signup, BorderLayout.CENTER);
        

             // card2 (sign in)

             card2 = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
             card2.setLayout(new BorderLayout());
              
             JLabel label2 = new JLabel("Get Your Data",SwingConstants.CENTER);
             label2.setFont(new Font("Serif",Font.BOLD,18));    
             label2.setForeground(Color.WHITE);
             card2.add(label2,BorderLayout.NORTH);
   
             signin = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
             signin.setLayout(new GridLayout(9, 1, 0, 20));
             // user name 
             user1 = new JPanel(new FlowLayout(1)); 
            user1.setOpaque(false);
            name2 = new JLabel("Username:");
             name2.setFont(new Font("arial", Font.BOLD, 14));
              name2in = new JTextField(20);
             user1.add(name2);
             user1.add(name2in);
             
             // add gap 
             // password

           password2 = new JPanel(new FlowLayout(1));
           password2.setOpaque(false);
            key2 = new JLabel("Key            :");
           name2.setFont(new Font("arial", Font.PLAIN, 14));
         key2in = new JPasswordField(20);
           password2.add(key2);
           password2.add(key2in);
   // BUTTON TO  to create an account 
      Bsignin = new JPanel(new FlowLayout(1));
      Bsignin.setOpaque(false);
      bup2 = new JButton("Sign in");
      bup2.addActionListener(this);
      bup2.setBackground(Color.ORANGE);
      Bsignin.add(bup2);
   
   
             signin.add(new JLabel(""));
             signin.add(user1);
             signin.add(password2);
             signin.add(Bsignin);// adding panel with button 
             
               
   
   
        card2.add(signin, BorderLayout.CENTER);
    ////////////////////////////////////////////////////////////

    // card3 
    card3 = new GradientPanel(p1, p2, Color.ORANGE, Color.BLUE);
    card3.setLayout(new BorderLayout());

    // create three button two on top and one on down
      // up
     Show = new JPanel(new FlowLayout(1));
    Show.setOpaque(false);
    show = new JButton("Show");
    show.addActionListener(this);
    show.setBackground(Color.getHSBColor(30.0f, 0.5f, 0.4f));
    show.setForeground(Color.WHITE);
    Show.add(show);

    //
    Add = new JPanel(new FlowLayout(1));
    Add.setOpaque(false);
    add = new JButton("Add ");
    add.addActionListener(this);
    add.setBackground(Color.getHSBColor(30.0f, 0.5f, 0.4f));
    add.setForeground(Color.white);
    Add.add(add);

    //
    Clear = new JPanel(new FlowLayout(1));
    Clear.setOpaque(false);
    clear = new JButton("Clear");
    clear.addActionListener(this);
    clear.setBackground(Color.getHSBColor(30.0f, 0.5f, 0.4f));
    clear.setForeground(Color.white);
    Clear.add(clear);
    //up
    // down 
     DAcc = new JPanel(new FlowLayout(1));
    DAcc.setOpaque(false);
     del = new JButton("Delete Account");
    del.setBackground(Color.getHSBColor(30.0f, 0.5f, 0.4f));
    del.setForeground(Color.WHITE);
    del.addActionListener(this);
    DAcc.add(del);

    upp = new JPanel(new FlowLayout(1));
     upp.setOpaque(false);
     upp.add(Show);
     upp.add(Add);
     upp.add(Clear);
     // down 

     // center adding field will be added 
      Area = new JPanel(new GridLayout(1, 1));
      Area.setOpaque(false);
     area = new JTextArea("|||  ",20,20);
     area.setBackground(Color.BLUE);
     area.setForeground(Color.LIGHT_GRAY);
     area.setLineWrap(true);
     area.setWrapStyleWord(true);
     // now creating an scroll pane 
     
      scroll = new JScrollPane(area);       
     Area.add(scroll);

 // card three button added to up and down 
     card3.add(upp,BorderLayout.NORTH);
     
     card3.add(DAcc,BorderLayout.SOUTH);
    card3.add(Area,BorderLayout.CENTER);


///////////////////////////////////////////////////////////////////    
  cards.add(card1,"card1");
  cards.add(card2,"card2");
  cards.add(card3,"card3");
  
  cont.add(login);
  cont.add(cards);


    }

    
    public static void main(String args[]) throws InterruptedException{
      
       Card obj = new Card();
       obj.run();
  

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cr){
         Cmanager.show(cards, "card1");
        }
        if(e.getSource()==button2){
          Cmanager.show(cards, "card2");
         }
         if(e.getSource()==bup){//card1
          Boolean naaya = true;
           String naam ="";
      
           String pass;
          try {
            // first load the class 
              Class.forName("com.mysql.cj.jdbc.Driver");
              // get the connection 

              Connection con = DriverManager.getConnection(url,name,key);
              // got it from the fields
              naam = name1in.getText();
              pass = new String(key1in.getPassword());
             // using statement will fire a query 
             Statement st = con.createStatement();
             // for taking input for the programm to implement dynamic query
             String dq ="insert into info1(name,password,data) values(?,?,?)";
             PreparedStatement pst = con.prepareStatement(dq);
             // fire a query
             ResultSet set = st.executeQuery("SELECT * FROM INFO1");
             // search in the result set 

             while(set.next()){
                    
              if(naam.equals(set.getString("name"))){
                JOptionPane.showMessageDialog(null, "This user's Account Already exist!");
                Cmanager.show(cards, "card2");
                naaya=false;
                break;
              }
               
             }
             if(naam.equals("")){
              JOptionPane.showMessageDialog(null,"Invalid username");
             }
             // reached here means new user is comming 
             if(naaya && !naam.equals("")){
               // setting the values through pr-stmt making ready to fire 
               pst.setString(1, naam);
               pst.setString(2, pass);
               pst.setString(3, "");
             // fire it 
                pst.executeUpdate();
               JOptionPane.showMessageDialog(null, "Account Created Sucessfully");
               Cmanager.show(cards, "card2");
             }


          } catch (Exception e1) {
            e1.printStackTrace();
          }



         }

         // card2

         if(e.getSource()==bup2){
          Boolean naaya = true;
           String naam ="";
      
           String pass;
          try {
            // first load the class 
              Class.forName("com.mysql.cj.jdbc.Driver");
              // get the connection 

              Connection con = DriverManager.getConnection(url,name,key);
              // got it from the fields
              naam = name2in.getText();
              pass = new String(key2in.getPassword());
             // using statement will fire a query 
             Statement st = con.createStatement();
           
             // fire a query
             ResultSet set = st.executeQuery("SELECT * FROM INFO1");
             // search in the result set 

             while(set.next()){
                    
              if(naam.equals(set.getString("name"))){
                if(set.getString("password").equals(pass)){
                      Cmanager.show(cards, "card3");
                      id = set.getInt("id");
                }
                else{
                  JOptionPane.showMessageDialog(null, "Failed Check passkey");
                }
               
                naaya=false;
                break;
              }
               
             }
             // reached here means new user is comming 
             if(naaya){
             
               JOptionPane.showMessageDialog(null, "User's Id not found");
               Cmanager.show(cards, "card1");
             }


          } catch (Exception e1) {
            e1.printStackTrace();
          }



         }

         // card3
         // show 
         if(e.getSource()==show){
         
          try {
            // first load the class 
              Class.forName("com.mysql.cj.jdbc.Driver");
              // get the connection 

              Connection con = DriverManager.getConnection(url,name,key);
              // got it from the fields
             
             // using Prepared statement will fire a dynamic  query 
             String dq = "select * from info1 where id=?";
             PreparedStatement pst =con.prepareStatement(dq);
             // set it 
             pst.setInt(1, id);
             // fire a query
             ResultSet set = pst.executeQuery();
             // insert in the text area using reult set
              set.next();
             area.setText(set.getString("data"));
     
            
           


          } catch (Exception e1) {
            e1.printStackTrace();
          }



         }

         // add 
         if(e.getSource()==add){
          
          try {
            // first load the class 
              Class.forName("com.mysql.cj.jdbc.Driver");
              // get the connection 

              Connection con = DriverManager.getConnection(url,name,key);
              // got it from the fields
             
             // using Prepared statement will fire a dynamic  query 
             String dq = "update  info1 set data=CONCAT(data,'  |--|  ',?) where id=?";
             PreparedStatement pst =con.prepareStatement(dq);
             // set it 
             pst.setString(1, area.getText());
             pst.setInt(2, id);
             // fire a query
             pst.executeUpdate();
             // insert in the text area using reult set
            
          JOptionPane.showMessageDialog(null, "Added");
            
           area.setText("");


          } catch (Exception e1) {
            e1.printStackTrace();
          }



         }
         
         // delete the account

         if(e.getSource()==del){
         
        try {
          // first load the class 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // get the connection 

            Connection con = DriverManager.getConnection(url,name,key);
            // got it from the fields
           
           // using Prepared statement will fire a dynamic  query 
           String dq = "delete from info1 where id=?";
           PreparedStatement pst =con.prepareStatement(dq);
           // set it 
           pst.setInt(1, id);
          
           // fire a query
        
           // insert in the text area using reult set
          
      int choice =  JOptionPane.showOptionDialog(null, "Are you sure !","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,  null, new String[]{"Yes","No","Cancel"}, "Yes");
          
         if(choice==JOptionPane.YES_OPTION){
          pst.executeUpdate();
          Cmanager.show(cards, "card2");
         }


        } catch (Exception e1) {
          e1.printStackTrace();
        }



       }

       if(e.getSource()==clear){
        area.setText("");
       }
       

    }
}
