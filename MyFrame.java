import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame implements ActionListener, MouseListener
{
	MenuItem exitItem;
	PopupMenu optionsMenu;
	Frame frame;
	//----------------------------------------------------------------------------------
	Label displayLabel=new Label("0",Label.RIGHT);  
	Label memLabel=new Label(" ",Label.RIGHT);
	//----------------------------------------------------------------------------------
	Button btn[];
	String str[]={"C","/","*","-","0","1","2","+","3","4","5","=","6","7","8","9"};
	//----------------------------------------------------------------------------------
	public MyFrame()
	{
		setTitle("Calculator");//Tieu de cua so
		setSize(300,200);//Kich co
		addWindowListener(new WindowAdapter()  //Thoat chuong trinh
		{  
			public void windowClosing(WindowEvent ev)  
			{System.exit(0);}  
		});  
		//----------------------------------------------------------------------------------
		MenuBar mbar=new MenuBar();//Tao thanh thuc don
		setMenuBar(mbar);
		//----------------------------------------------------------------------------------
		Menu fileMenu=new Menu("File");//KHai bao File
		mbar.add(fileMenu);//Them File vao tren mbar;
		fileMenu.addActionListener(this);
		MenuItem exitItem=new MenuItem("Exit");//Them Exit vao tren File
		fileMenu.add(exitItem);
		//----------------------------------------------------------------------------------
		Menu helpMenu=new Menu("Help");//KHai bao Help
		mbar.add(helpMenu);//Them File vao tren mbar;
		helpMenu.addActionListener(this);
		MenuItem aboutItem=new MenuItem("About");//Them About vao tren File
		helpMenu.add(aboutItem);
		//----------------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------------
		setLayout(new GridLayout(4,4));//Tao bo cuc luoi
		btn=new Button[str.length];
		for (int i=0;i<str.length;i++)
		{
			btn[i]=new Button(str[i]);
			add(btn[i]);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
	}
	public void mouseEntered(MouseEvent m){}
	public void mouseExited(MouseEvent m){}
	public void mouseClicked(MouseEvent m)
	{
		optionsMenu.show(this,m.getX(),m.getY());
	}
	public void mouseReleased(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	
	public static void main(String[] args)
	{
		MyFrame frame=new MyFrame();
		frame.setSize(300,200);
		frame.show();
	}
}
	
		