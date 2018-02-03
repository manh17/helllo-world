/********************************************* 
Save this file as MyCalculator.java 
to compile it use 
    javac MyCalculator.java 
to use the calcuator do this 
    java MyCalculator 
 
**********************************************/  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
/*********************************************/  
  
public class MyCalculator extends Frame  
{  
  
public boolean setClear=true;  
double number, memValue;  
char op;  
  
String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "+/-", "0", "." };
String operatorButtonText0[] = {"%","sqrt", "X^2", "1/X" };  
String operatorButtonText[] = {"/", "*", "-", "+", "=", "sqrt", "%", "1/X" };  
String memoryButtonText[] = {"MC", "MR", "M+", "M-", "MS","M'" };  
String specialButtonText[] = {"CE", "C", "Backspc" };  
  
MyDigitButton digitButton[]=new MyDigitButton[digitButtonText.length];  
MyOperatorButton operatorButton0[]=new MyOperatorButton[operatorButtonText0.length]; 
MyOperatorButton operatorButton[]=new MyOperatorButton[operatorButtonText.length];  
MyMemoryButton memoryButton[]=new MyMemoryButton[memoryButtonText.length];  
MySpecialButton specialButton[]=new MySpecialButton[specialButtonText.length];  
  
Label displayLabel=new Label("0",Label.RIGHT);  
Label memLabel=new Label(" ",Label.RIGHT);  
  
final int FRAME_WIDTH=337,FRAME_HEIGHT=542;  
final int HEIGHT=50, WIDTH=75, H_SPACE=3,V_SPACE=3;  
final int TOPX=15, TOPY=65;  
/*
H_SPACE: khoang cach giua cac nut chieu ngang
V_SPACE: khoang cach giua cac nut chieu doc

HEIGHT: chieu cao nut
WIDTH: chieu rong nut

TOPX :khoang cach le trai
TOPY :khoang cach le tren

*/
///////////////////////////  
MyCalculator(String frameText)//constructor  
{  
super(frameText);  
  
int tempX=TOPX, y=TOPY+37;  
displayLabel.setBounds(tempX,y,FRAME_WIDTH-2*TOPX,3*HEIGHT/2);// o ket qua 
displayLabel.setBackground(new Color(31,31,31));
displayLabel.setFont(new Font("SANS_SERIF", Font.TYPE1_FONT, 47));   
displayLabel.setForeground(Color.WHITE);  
add(displayLabel);  
  
memLabel.setBounds(TOPX,  TOPY+HEIGHT+ V_SPACE,WIDTH, HEIGHT); 
// o hien thi 
add(memLabel);  

MenuBar mbar=new MenuBar();//Tao thanh thuc don
setMenuBar(mbar);
		
Menu fileMenu=new Menu("Standard");//KHai bao File
mbar.add(fileMenu);//Them File vao tren mbar;
		
MenuItem StandardItem=new MenuItem("Standard");//Them Exit vao tren File
fileMenu.add(StandardItem);

MenuItem ScientificItem=new MenuItem("Scientific");//Them Exit vao tren File
fileMenu.add(ScientificItem);

MenuItem ProgrammerItem=new MenuItem("Programmer");//Them Exit vao tren File
fileMenu.add(ProgrammerItem);

MenuItem DateCalculationItem=new MenuItem("Date Calculation");//Them Exit vao tren File
fileMenu.add(DateCalculationItem);

MenuItem ConverterItem=new MenuItem("Converter");//Them Exit vao tren File
fileMenu.add(ConverterItem);

MenuItem CurrencyItem=new MenuItem("Currency");//Them Exit vao tren File
fileMenu.add(CurrencyItem); 

MenuItem VolumeItem=new MenuItem("Volume");//Them Exit vao tren File
fileMenu.add(VolumeItem); 

MenuItem LengthItem=new MenuItem("Length");//Them Exit vao tren File
fileMenu.add(LengthItem); 

MenuItem WeightandMassItem=new MenuItem("Weight and Mass");//Them Exit vao tren File
fileMenu.add(WeightandMassItem); 

MenuItem TemperatureItem=new MenuItem("Temperature");//Them Exit vao tren File
fileMenu.add(TemperatureItem); 

MenuItem EnergyItem=new MenuItem("Energy");//Them Exit vao tren File
fileMenu.add(EnergyItem); 

MenuItem AreaItem=new MenuItem("Area");//Them Exit vao tren File
fileMenu.add(AreaItem); 

MenuItem SpeedItem=new MenuItem("Speed");//Them Exit vao tren File
fileMenu.add(SpeedItem); 

MenuItem TimeItem=new MenuItem("Time");//Them Exit vao tren File
fileMenu.add(TimeItem); 

MenuItem PowerItem=new MenuItem("Power");//Them Exit vao tren File
fileMenu.add(PowerItem); 

MenuItem DataItem=new MenuItem("Data");//Them Exit vao tren File
fileMenu.add(DataItem); 

MenuItem PressureItem=new MenuItem("Pressure");//Them Exit vao tren File
fileMenu.add(PressureItem); 

MenuItem AngleItem=new MenuItem("Angle");//Them Exit vao tren File
fileMenu.add(AngleItem); 
 

// set Co-ordinates for Memory Buttons 
int digitX=TOPX;  
int digitY=TOPY+4*(HEIGHT+V_SPACE)+43; 
tempX=TOPX*2;    
y=TOPY+2*(HEIGHT+V_SPACE)+HEIGHT/2-10;  
for(int i=0; i<memoryButton.length; i++)  
{  
memoryButton[i]=new MyMemoryButton(tempX,y,WIDTH/2,HEIGHT/2,memoryButtonText[i], this);  
memoryButton[i].setForeground(Color.WHITE);  
memoryButton[i].setBackground(new Color(19,19,19));
tempX+=47+H_SPACE;  
}  

//set Co-ordinates for Operator Buttons 0  

tempX=TOPX; 
y=digitY-2*(HEIGHT+V_SPACE);   
for(int i=0;i<operatorButton0.length;i++)  
{    
operatorButton0[i]=new MyOperatorButton(tempX,y,WIDTH,HEIGHT,operatorButtonText0[i], this);  
operatorButton0[i].setForeground(Color.WHITE);  
operatorButton0[i].setBackground(new Color(19,19,19));
tempX+=WIDTH+H_SPACE;  
} 
  
//set Co-ordinates for Special Buttons  
 
tempX=TOPX; 
y=digitY-(HEIGHT+V_SPACE);  
for(int i=0;i<specialButton.length;i++)  
{  
specialButton[i]=new MySpecialButton(tempX,y,WIDTH,HEIGHT,specialButtonText[i], this);  
specialButton[i].setForeground(Color.WHITE);  
specialButton[i].setBackground(new Color(19,19,19));
tempX+=WIDTH+H_SPACE; 
}  
  
//set Co-ordinates for Digit Buttons  
 
tempX=digitX;  
y=digitY;  
for(int i=0;i<digitButton.length;i++)  
{  
digitButton[i]=new MyDigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);  
digitButton[i].setForeground(Color.WHITE); 
digitButton[i].setBackground(new Color(6,6,6)); 
tempX+=WIDTH+H_SPACE;  
if((i+1)%3==0){tempX=digitX; y+=HEIGHT+V_SPACE;}  
}  
  
//set Co-ordinates for Operator Buttons  
int opsX=digitX+2*(WIDTH+H_SPACE);  
int opsY=digitY-(HEIGHT+V_SPACE);  
tempX=opsX;  y=opsY;  
for(int i=0;i<operatorButton.length;i++)  
{  
tempX+=WIDTH+H_SPACE;  
operatorButton[i]=new MyOperatorButton(tempX,y,WIDTH,HEIGHT,operatorButtonText[i], this);  
operatorButton[i].setForeground(Color.WHITE);  
operatorButton[i].setBackground(new Color(19,19,19));
if((i+1)%1==0){tempX=opsX; y+=HEIGHT+V_SPACE;}  
}  
  
addWindowListener(new WindowAdapter()  
{  
public void windowClosing(WindowEvent ev)  
{System.exit(0);}  
});  
  
setLayout(null);  
setSize(FRAME_WIDTH,FRAME_HEIGHT);  
setVisible(true);  
}  
//////////////////////////////////  
static String getFormattedText(double temp)  
{  
String resText=""+temp;  
if(resText.lastIndexOf(".0")>0)  
    resText=resText.substring(0,resText.length()-2);  
return resText;  
}  
////////////////////////////////////////  
public static void main(String []args)  
{  
MyCalculator c = new MyCalculator("Calculator"); 
c.setBackground(new Color(31,31,31));  
}  
}  
  
/*******************************************/  
  
class MyDigitButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
//////////////////////////////////////////  
MyDigitButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
////////////////////////////////////////////////  
static boolean isInString(String s, char ch)  
{  
for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;  
return false;  
}  
/////////////////////////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
String tempText=((MyDigitButton)ev.getSource()).getLabel();  
  
if(tempText.equals("."))  
{  
 if(cl.setClear)   
    {cl.displayLabel.setText("0.");cl.setClear=false;}  
 else if(!isInString(cl.displayLabel.getText(),'.'))  
    cl.displayLabel.setText(cl.displayLabel.getText()+".");  
 return;  
}  
  
int index=0;  
try{  
        index=Integer.parseInt(tempText);  
    }catch(NumberFormatException e){return;}  
  
if (index==0 && cl.displayLabel.getText().equals("0")) return;  
  
if(cl.setClear)  
            {cl.displayLabel.setText(""+index);cl.setClear=false;}  
else  
    cl.displayLabel.setText(cl.displayLabel.getText()+index);  
}//actionPerformed  
}//class defination  
  
/********************************************/  
  
class MyOperatorButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
MyOperatorButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
///////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
String opText=((MyOperatorButton)ev.getSource()).getLabel();  
  
cl.setClear=true;  
double temp=Double.parseDouble(cl.displayLabel.getText());  
  
if(opText.equals("1/x"))  
    {  
    try  
        {double tempd=1/(double)temp;  
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));}  
    catch(ArithmeticException excp)  
                        {cl.displayLabel.setText("Divide by 0.");}  
    return;  
    }  
if(opText.equals("sqrt"))  
    {  
    try  
        {double tempd=Math.sqrt(temp);  
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));}  
            catch(ArithmeticException excp)  
                    {cl.displayLabel.setText("Divide by 0.");}  
    return;  
    }  
if(!opText.equals("="))  
    {  
    cl.number=temp;  
    cl.op=opText.charAt(0);  
    return;  
    }  
// process = button pressed  
switch(cl.op)  
{  
case '+':  
    temp+=cl.number;break;  
case '-':  
    temp=cl.number-temp;break;  
case '*':  
    temp*=cl.number;break;  
case '%':  
    try{temp=cl.number%temp;}  
    catch(ArithmeticException excp)  
        {cl.displayLabel.setText("Divide by 0."); return;}  
    break;  
case '/':  
    try{temp=cl.number/temp;}  
        catch(ArithmeticException excp)  
                {cl.displayLabel.setText("Divide by 0."); return;}  
    break;  
}//switch  
  
cl.displayLabel.setText(MyCalculator.getFormattedText(temp));  
//cl.number=temp;  
}//actionPerformed  
}//class  
  
/****************************************/  
  
class MyMemoryButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
/////////////////////////////////  
MyMemoryButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
////////////////////////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
char memop=((MyMemoryButton)ev.getSource()).getLabel().charAt(1);  
  
cl.setClear=true;  
double temp=Double.parseDouble(cl.displayLabel.getText());  
  
switch(memop)  
{  
case 'C':   
    cl.memLabel.setText(" ");cl.memValue=0.0;break;  
case 'R':   
    cl.displayLabel.setText(MyCalculator.getFormattedText(cl.memValue));break;  
case 'S':  
    cl.memValue=0.0;  
case '+':   
    cl.memValue+=Double.parseDouble(cl.displayLabel.getText());  
    if(cl.displayLabel.getText().equals("0") || cl.displayLabel.getText().equals("0.0")  )  
        cl.memLabel.setText(" ");  
    else   
        cl.memLabel.setText("M");     
    break;  
}//switch  
}//actionPerformed  
}//class  
  
/*****************************************/  
  
class MySpecialButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
MySpecialButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
//////////////////////  
static String backSpace(String s)  
{  
String Res="";  
for(int i=0; i<s.length()-1; i++) Res+=s.charAt(i);  
return Res;  
}  
  
//////////////////////////////////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
String opText=((MySpecialButton)ev.getSource()).getLabel();  
//check for backspace button  
if(opText.equals("Backspc"))  
{  
String tempText=backSpace(cl.displayLabel.getText());  
if(tempText.equals(""))   
    cl.displayLabel.setText("0");  
else   
    cl.displayLabel.setText(tempText);  
return;  
}  
//check for "C" button i.e. Reset  
if(opText.equals("C"))   
{  
cl.number=0.0; cl.op=' '; cl.memValue=0.0;  
cl.memLabel.setText(" ");  
}  
  
//it must be CE button pressed  
cl.displayLabel.setText("0");cl.setClear=true;  
}//actionPerformed  
}//class  
  
/********************************************* 
Features not implemented and few bugs 
 
i)  No coding done for "+/-" button. 
ii) Menubar is not included. 
iii)Not for Scientific calculation 
iv)Some of the computation may lead to unexpected result 
   due to the representation of Floating point numbers in computer 
   is an approximation to the given value that can be stoWHITE 
   physically in memory. 
***********************************************/  