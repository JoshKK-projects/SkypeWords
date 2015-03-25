package Drawthingthing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class MainDraw {
	private static ArrayList <String> thedict;  
	public static void main(String[] args)throws Exception {
		Scanner console = new Scanner(System.in);
		Scanner dict = getFile(console);		
		thedict = readdict(dict);
		//makes the general GUI frame
		final JFrame frame = new JFrame("Skype Grief");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600,200));
		frame.setBackground(Color.WHITE);
		frame.setTitle("Grief The Skype!");
		frame.setLayout(new FlowLayout());
		//text field for the lesser words
		JLabel labelText = new JLabel("Word that will make up The Word, keep it short, unlike this message");
		final JTextField text1 = new JTextField(10);
		text1.setText("      ");
		text1.setToolTipText("I suggest hue");
		frame.add(labelText);
		frame.add(text1);
		//text field for the greater words
		JLabel labelText1 = new JLabel("The Word!!!!!!!!");
		final JTextField text2 = new JTextField(10);
		text2.setText("      ");
		text2.setToolTipText("I suggest hue");
		frame.add(labelText1);
		frame.add(text2);
		//I used a text field so I can just tab and hit enter on it, a button might work but meh
		//For random words
		JLabel labelText2 = new JLabel("Press Enter on this for random words");
		final JTextField text3 = new JTextField(10);
		text3.setText("      ");
		text3.setToolTipText("I suggest 58675");
		frame.add(labelText2);
		frame.add(text3);
		
		JLabel labelText3 = new JLabel("Where we fancy dem up");
		final JTextField text4 = new JTextField(10);
		text4.setText("      ");
		text4.setToolTipText("For emPHAsis");
		frame.add(labelText3);
		frame.add(text4);
		
		JButton prefance1 = new JButton("!**!");
		frame.add(prefance1);
		
		JButton prefance2 = new JButton("$$$$");
		frame.add(prefance2);
		
		JButton prefance3 = new JButton("!~!**!~!");
		frame.add(prefance3);
		
		
		
		frame.setVisible(true);
		//sets the random big and small words for if you wanna us two random words
		Random rando = new Random();
		int smallrand = rando.nextInt(143091)+1;
		int bigrand = rando.nextInt(143091)+1;
		//this bit gets a bit dumb because this final keyword stuff was being a butt
		//holder non butthead final string
		String holder = "";
		//gets it a rando word
		holder = thedict.get(smallrand);
		//if its too long(readability), start the loop
		if(holder.length()>7){
			for(int i=0;i<5;i++){//give it 10 chances to fix it
				smallrand = rando.nextInt(143091)+1;//finds a new word to give it
				holder = thedict.get(smallrand);
				if(holder.length()<7){//if its small enough, give the butthead final variable the word
					final String rsmall = holder;
					break;//found the word, great, dont fuck it up, porkchop sandwiches, lets get outa here!
				}
			}
		}//if it cant find a small enough one, screw it, use it
		final String rsmall = holder;
		
		final String rbig = thedict.get(bigrand);
		
		
		//generates the txt doc if you hit enter while on the first box, taking what you have in both
		text1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String word = text2.getText();
				//gets rid of all the whitespace and makes them lowercase
				grief = grief.toString().replaceAll("\\s","");
				//grief = grief.toLowerCase();
				word = word.toString().replaceAll("\\s","");
				word = word.toLowerCase();
				attack(grief,word);
				frame.dispose();
				
			}
		});
		//generates the txt doc if you hit enter while on the second box, taking what you have in both
		text2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String word = text2.getText();
				//gets rid of all the whitespace and makes them lowercase
				grief = grief.toString().replaceAll("\\s","");
				//grief = grief.toLowerCase();
				word = word.toString().replaceAll("\\s","");
				word = word.toLowerCase();
				attack(grief,word);
				frame.dispose();
				
			}
		});
		text3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String word = text2.getText();
				//gets rid of all the whitespace and makes them lowercase
				grief = rsmall.toString().replaceAll("\\s","");
				//grief = grief.toLowerCase();
				word = rbig.toString().replaceAll("\\s","");
				word = word.toLowerCase();
				attack(grief,word);
				frame.dispose();
				
			}
		});
		//button that fancyies it up 
		text4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String fancay = text4.getText();
				grief.toString().replaceAll("\\s", "");
				fancay.toString().replaceAll("\\s", "");
				fancayup(grief,fancay);
				
			}
		});
		//the fancy buttons
		prefance1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String fancay = "!**!";
				fancayup(grief,fancay);
			}
		});
		
		prefance1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String fancay = "$$$$$";
				fancayup(grief,fancay);
			}
		});
		
		prefance1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String grief = text1.getText();
				String fancay = "!~!***!~!";
				fancayup(grief,fancay);
			}
		});
	}
	public static String spa(String grief,int amount){
		String spaces = "";
		if(amount == 5){
			for(int i =0;i<grief.length()/2;i++){
				spaces+= " ";
			}
		}
		else if(amount == 4){
			for(int i =0;i<grief.length()/1.5;i++){
				spaces+= " ";
			}
		}
		else if(amount == 3){
			for(int i =0;i<grief.length()/1.25;i++){
				spaces+= " ";
			}
		}
		else if(amount == 2){
			for(int i =0;i<grief.length();i++){
				spaces+= " ";
			}
		}
		else if(amount == 1){
			for(int i =0;i<grief.length()*1.5;i++){
				spaces+= " ";
			}
		}
			return spaces;
	}
	public static void fancayup(String grief,String fancay){
		try{
			BufferedWriter draw = new BufferedWriter(new FileWriter("C:\\Users\\ursinewalrus\\Desktop\\Grief\\draw.txt"));
			String thefance = fancay+grief+fancay;
			thefance = thefance.replaceAll("\\s", "");//addings spaces somewhere,weirds
			System.out.println(grief+"1");
			System.out.println(fancay+"1");
			draw.write(thefance);
			draw.close();
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\ursinewalrus\\Desktop\\Grief\\draw.txt");
		}
		 catch (IOException e) {}
		
	}
	public static void attack(String grief,String word){	
		try{
			BufferedWriter draw = new BufferedWriter(new FileWriter("C:\\Users\\ursinewalrus\\Desktop\\Grief\\draw.txt"));
				if(word.equals("<3")){
					Heart(draw,grief);
				}else{
					for(int i=0;i<word.length();i++){
						if(word.charAt(i)=='a'|| word.charAt(i)=='A'){
							A(draw, grief);
						}else if(word.charAt(i)=='b'|| word.charAt(i)=='B'){
							B(draw, grief);
						}else if(word.charAt(i)=='c'|| word.charAt(i)=='C'){
							C(draw, grief);
						}else if(word.charAt(i)=='d'|| word.charAt(i)=='D'){
							D(draw, grief);
						}else if(word.charAt(i)=='e'|| word.charAt(i)=='E'){
							E(draw, grief);
						}else if(word.charAt(i)=='f'|| word.charAt(i)=='F'){
							F(draw, grief);
						}else if(word.charAt(i)=='g'|| word.charAt(i)=='G'){
							G(draw, grief);
						}else if(word.charAt(i)=='h'|| word.charAt(i)=='H'){
							H(draw, grief);
						}else if(word.charAt(i)=='i'|| word.charAt(i)=='I'){
							I(draw, grief);
						}else if(word.charAt(i)=='j'|| word.charAt(i)=='J'){
							J(draw, grief);
						}else if(word.charAt(i)=='k'|| word.charAt(i)=='K'){
							K(draw, grief);
						}else if(word.charAt(i)=='l'|| word.charAt(i)=='L'){
							L(draw, grief);
						}else if(word.charAt(i)=='m'|| word.charAt(i)=='M'){
							M(draw, grief);
						}else if(word.charAt(i)=='n'|| word.charAt(i)=='N'){
							N(draw, grief);
						}else if(word.charAt(i)=='o'|| word.charAt(i)=='O'){
							O(draw, grief);
						}else if(word.charAt(i)=='p'|| word.charAt(i)=='P'){
							P(draw, grief);
						}else if(word.charAt(i)=='q'|| word.charAt(i)=='Q'){
							Q(draw, grief);
						}else if(word.charAt(i)=='r'|| word.charAt(i)=='R'){
							R(draw, grief);
						}else if(word.charAt(i)=='s'|| word.charAt(i)=='S'){
							S(draw, grief);
						}else if(word.charAt(i)=='t'|| word.charAt(i)=='T'){
							T(draw, grief);
						}else if(word.charAt(i)=='u'|| word.charAt(i)=='U'){
							U(draw, grief);
						}else if(word.charAt(i)=='v'|| word.charAt(i)=='V'){
							V(draw, grief);
						}else if(word.charAt(i)=='w'|| word.charAt(i)=='W'){
							W(draw, grief);
						}else if(word.charAt(i)=='x'|| word.charAt(i)=='X'){
							X(draw, grief);
						}else if(word.charAt(i)=='y'|| word.charAt(i)=='Y'){
							Y(draw, grief);
						}else if(word.charAt(i)=='z'|| word.charAt(i)=='Z'){
							Z(draw, grief);
						}else if(word.charAt(i)=='!'){
							Exclamation(draw,grief);
						}else if(word.charAt(i)=='?'){
							QuestionMark(draw,grief);
						}
					}
				}
				draw.close();
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\ursinewalrus\\Desktop\\Grief\\draw.txt");
				//Runtime.getRuntime().exec("C:\\Users\\ursinewalrus\\Desktop\\Folder Fulla Folders\\Spelunky\\Spelunky.exe");
				
		} catch (IOException e) {}

	}
	public static void SPACE(BufferedWriter draw){
		try {
			draw.write("   ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//6 high, 3 across, 7 horizontal spaces for every missed grief, might get odd with big words
	public static void A(BufferedWriter draw,String grief){
		try {
			draw.write(spa(grief,1)+spa(grief,4)+grief+spa(grief,2));
			draw.newLine();
			draw.write(spa(grief,2)+spa(grief,5)+grief+grief+spa(grief,5));
			draw.newLine();
			draw.write(spa(grief,3)+spa(grief,5)+grief+spa(grief,2)+grief);
			draw.newLine();
			draw.write(spa(grief,5)+spa(grief,5)+grief+grief+grief);
			draw.newLine();
			draw.write(spa(grief,5)+grief+spa(grief,1)+spa(grief,4)+grief);
			draw.newLine();
			draw.write(grief+spa(grief,1)+spa(grief,1)+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void B(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"         "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"         "+grief);
			draw.newLine();
			draw.write(grief+"         "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void C(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void D(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief);
			draw.newLine();
			draw.write(grief+"    "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"    "+grief);
			draw.newLine();
			draw.write(grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void E(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void F(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void G(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+"      "+grief+grief);
			draw.newLine();
			draw.write(grief+"            "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void H(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void I(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine(); 
			draw.write("      "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void J(BufferedWriter draw,String grief){
		try {
			draw.write("               "+grief);
			draw.newLine();
			draw.write("               "+grief);
			draw.newLine();
			draw.write("               "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void K(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"              "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief);
			draw.newLine();
			draw.write(grief+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"              "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void L(BufferedWriter draw,String grief){
		try {
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void M(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"                  "+grief);                
			draw.newLine();
			draw.write(grief+grief+"            "+grief);   
			draw.newLine();
			draw.write(grief+"  "+grief+"      "+grief+"  "+grief);    
			draw.newLine();
			draw.write(grief+"    "+grief+"    "+grief+"    "+grief);    
			draw.newLine();
			draw.write(grief+"      "+grief+"  "+grief+"      "+grief);   
			draw.newLine();
			draw.write(grief+"            "+grief+"          "+grief);            
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void N(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"               "+grief);
			draw.newLine();
			draw.write(grief+" "+grief+"         "+grief);
			draw.newLine();
			draw.write(grief+"    "+grief+"      "+grief);
			draw.newLine();
			draw.write(grief+"     "+grief+"     "+grief);
			draw.newLine();
			draw.write(grief+"        "+grief+"    "+grief);
			draw.newLine();
			draw.write(grief+"              "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void O(BufferedWriter draw,String grief){
		try {
			draw.write("    "+grief+grief+grief);
			draw.newLine();
			draw.write("  "+grief+"           "+grief);
			draw.newLine();
			draw.write(grief+"                "+grief);
			draw.newLine();
			draw.write(grief+"                "+grief);
			draw.newLine();
			draw.write("  "+grief+"           "+grief);
			draw.newLine();
			draw.write("    "+grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void P(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Q(BufferedWriter draw,String grief){
		try {
			draw.write("    "+grief+grief+grief);
			draw.newLine();
			draw.write("  "+grief+"           "+grief);
			draw.newLine();
			draw.write(grief+"                "+grief);
			draw.newLine();
			draw.write(" "+grief+"                "+grief);
			draw.newLine();
			draw.write("   "+grief+"           "+grief);
			draw.newLine();
			draw.write("      "+grief+grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void R(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+" "+grief);
			draw.newLine();
			draw.write(grief+"      "+grief);
			draw.newLine();
			draw.write(grief+"        "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void S(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write("            "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void T(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine(); 
			draw.write("      "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void U(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void V(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"           "+grief);
			draw.newLine();
			draw.write(" "+grief+"        "+grief);
			draw.newLine();
			draw.write("   "+grief+"    "+grief);
			draw.newLine();
			draw.write("    "+grief+"  "+grief);
			draw.newLine();
			draw.write("     "+grief+" "+grief);
			draw.newLine();
			draw.write("         "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void W(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"       "+grief+"               "+grief);             
			draw.newLine();
			draw.write(grief+"      "+grief+"  "+grief+"      "+grief);
			draw.newLine();
			draw.write(grief+"    "+grief+"    "+grief+"    "+grief);    
			draw.newLine();
			draw.write(grief+"  "+grief+"      "+grief+"  "+grief);    
			draw.newLine();
			draw.write(grief+grief+"            "+grief);       
			draw.newLine();
			draw.write(grief+"                  "+grief);              
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void X(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"              "+grief);
			draw.newLine();
			draw.write("    "+grief+"       "+grief);
			draw.newLine();
			draw.write("            "+grief);
			draw.newLine();
			draw.write("            "+grief);
			draw.newLine();
			draw.write("    "+grief+"      "+grief);
			draw.newLine();
			draw.write(grief+"             "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void Y(BufferedWriter draw,String grief){
		try {
			draw.write(grief+"              "+grief);
			draw.newLine();
			draw.write("    "+grief+"       "+grief);
			draw.newLine();
			draw.write("            "+grief);
			draw.newLine();
			draw.write("         "+grief);
			draw.newLine();
			draw.write("    "+grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void Z(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write("          "+grief);
			draw.newLine();
			draw.write("        "+grief);
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.write("    "+grief);
			draw.newLine();
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Exclamation(BufferedWriter draw,String grief){
		try {
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.newLine();
			draw.write(grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void QuestionMark(BufferedWriter draw,String grief){
		try {
			draw.write(grief+grief+grief);
			draw.newLine();
			draw.write(grief+"       "+grief);
			draw.newLine();
			draw.write("           "+grief);
			draw.newLine();
			draw.write("        "+grief);
			draw.newLine();
			draw.newLine();
			draw.write("      "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Heart(BufferedWriter draw,String grief){
		try {
			draw.write("    "+grief+"               "+grief);
			draw.newLine();
			draw.write(" "+grief+grief+"      "+grief+grief);
			draw.newLine();
			draw.write(" "+grief+grief+grief+grief+grief);
			draw.newLine();
			draw.write(" "+grief+grief+grief+grief+grief);
			draw.newLine();
			draw.write("   "+grief+grief+grief+grief);
			draw.newLine();
			draw.write("      "+grief+grief+grief);
			draw.newLine();
			draw.write("              "+grief);
			draw.newLine();
			draw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void tabber(BufferedWriter draw, int tabs){
		for(int i=0;i<tabs;i++){
			try {
				draw.write(" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//dictionary reading stuff I don't fully remember 
public static String inputs(){
		
		String string = "";
		Scanner input = new Scanner(System.in);
			
		string = input.next();
		return string;
		
	}
	
	private static ArrayList<String> readdict(Scanner dict){
	
		ArrayList<String> dictArr = new ArrayList<String>();
	
		while(dict.hasNext()){
			dictArr.add(dict.next());

		}
		return dictArr;
	
	}
	public static Scanner getFile(Scanner console){
		Scanner s = null;
		try {
			s = new Scanner(new File("dict/words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Something has gone terribly wrong");
		}
		return s;
	}
}
