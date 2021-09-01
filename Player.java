package Music_player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Player extends JPanel implements ActionListener {
	
	JFrame window = new JFrame("Prity music Player");//creating a simple interface
	JLabel info =new JLabel("      Prity            MUSIC             PLAYER");//just for documentation at last section.
	
	JButton addbtn = new JButton("Add");//For adding music to the player.
	JButton plybtn = new JButton("Play");//For play the music
	JButton stopbtn = new JButton("Stop");//For stop the music
	Font cstmfont = new Font("",Font.BOLD,25);// creat a custom font for buttons text
	JComboBox slist = new JComboBox();//this will appre the song list from the desktop.
	
	
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Sounds","wav");
	//taking some instance Variable
	
	//variables for add music
	int returnValue;//to return the value to the browser section.
	int idx= 0;
	String[] music = new String[5];//this is for kept the selected music in an string type array.
	File selectFile;
	
	//variable for play options
	File sound;
	AudioInputStream audio;
	Clip clp;
	
	
	//creating a constructor
	Player(){
		this.setBackground(Color.LIGHT_GRAY);//adding back ground color to the frame.
		
		
		window.add(this);// adding jpanel to it.
		
		//here whatever we write in the button sections they will be add to actionlistener and perform the task.
		addbtn.addActionListener(this);
		plybtn.addActionListener(this);
		stopbtn.addActionListener(this);
		//if we don't add them the button functions will not work.
		
		//jlabel info.
		
		info.setFont(new Font("",Font.BOLD,20));
		window.add(info,BorderLayout.PAGE_END);//adding a lebal at the last section.
		
		
		//adding background color to the buttons
		addbtn.setBackground(Color.BLUE);
		plybtn.setBackground(Color.GREEN);
		stopbtn.setBackground(Color.RED);
		
		//add text color to the buttons
		addbtn.setForeground(Color.WHITE);
		plybtn.setForeground(Color.WHITE);
		stopbtn.setForeground(Color.WHITE);
		
		// adding button to the windows.
		window.add(addbtn,BorderLayout.CENTER);
		window.add(plybtn,BorderLayout.LINE_START);
		window.add(stopbtn,BorderLayout.LINE_END);
		
		//adding Customfont to the buttos texts.
		addbtn.setFont(cstmfont);
		plybtn.setFont(cstmfont);
		stopbtn.setFont(cstmfont);
		
		// adding a combo box and set the background and foreground to combobox
		window.add(slist,BorderLayout.PAGE_START);
		slist.setBackground(Color.YELLOW);
		slist.setForeground(Color.DARK_GRAY);
		
		//for browser search
		browser.setFileFilter(filter);
		
		//window sizing section.
		window.setSize(600, 600);//size of the frame or window or pop up(height and weidth. 
		window.setLocation(300, 100);// x axis =300 and -y axis = 200
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when click the cross button the frame will dismissed.
		window.setVisible(true);//visible the frame.
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		//set the action task for add button 
		//when mouse click on Add then the add btn will start it work
		if(ae.getSource().equals(addbtn)) {
			// oop deals with objects so we compare object to object . that's why equals()method.
			returnValue = browser.showOpenDialog(window);
			//when add btn will be pressed then a new folder panel will be opened at my window.
			//then we can select the songs.for adding them in our player-list.
			
			
			if(returnValue==browser.APPROVE_OPTION) {
				//here we compare objects with instance variable
				selectFile = browser.getSelectedFile();/*when we selected the music that's will be added to the
				music string array and listed inside slist
				at last the value of idx will we increase for next music add*/
				music[idx]= selectFile.toString();
				slist.addItem("Song-"+idx);
				idx++;
				
			}
		}
		
		// now the user play button .when we press the play button
		else if(ae.getSource()==plybtn) {
			
			try {
				if(slist.getSelectedIndex()==0) {
				sound = new File(music[slist.getSelectedIndex()]);
				audio = AudioSystem.getAudioInputStream(sound);
				clp   = AudioSystem.getClip();
				clp.open(audio);
				clp.start();
				}
				else if(slist.getSelectedIndex()==1) {
					sound = new File(music[slist.getSelectedIndex()]);
					audio = AudioSystem.getAudioInputStream(sound);
					clp   = AudioSystem.getClip();
					clp.open(audio);
					clp.start();
				}
				else if(slist.getSelectedIndex()==2) {
					sound = new File(music[slist.getSelectedIndex()]);
					audio = AudioSystem.getAudioInputStream(sound);
					clp   = AudioSystem.getClip();
					clp.open(audio);
					clp.start();
				}
				else if(slist.getSelectedIndex()==3) {
					sound = new File(music[slist.getSelectedIndex()]);
					audio = AudioSystem.getAudioInputStream(sound);
					clp   = AudioSystem.getClip();
					clp.open(audio);
					clp.start();
				}
				else if(slist.getSelectedIndex()==4) {
					sound = new File(music[slist.getSelectedIndex()]);
					audio = AudioSystem.getAudioInputStream(sound);
					clp   = AudioSystem.getClip();
					clp.open(audio);
					clp.start();
				}
				
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		
		// stop button
		else if(ae.getSource().equals(stopbtn)) {
			clp.stop();
			
		}
		/*This programe is developed by 
		 * Shagor Kumar Das 
		 * Green university of Bangladesh
		 * Department of Computer Science and Engineering
		 * ID:201002403
		 * 
		 * phone :01772621944
		 * E-mail:shagorkumardas@gmail.com
		 * 
		 * I took help from youtube and google. 
		 * */
		
		
		
	//main method	
		
	}
	
	public static void main(String[] args) {
		
		Player mp3 = new Player();
		
	}
	//ki kore basba
	

}
