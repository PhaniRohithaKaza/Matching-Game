import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class game extends Frame implements ActionListener {
    Panel p;
    Frame f;

    String[] List1 = { "a", "a", "b", "b", "c", "c", "d", "d", "e", "e",
            "f", "f" };
    String[] List2;

    Button[][] buttons;

    boolean flipping = true;

    int i = 0;
    int one;
    int sec;
    public static void main(String[] args) {
                game app = new game();
                app.memc();
            }

    public void mcards(Panel panel) {
        buttons = new Button[3][]; 
List<String> list = Arrays.asList(List1);
        Collections.shuffle(list);
        List2 = list.toArray(new String[list.size()]);
        for (int i = 0; i < 3* 4; i++) { 
                                      
            if (i % 4 == 0)
                buttons[i / 4] = new Button[4];
            buttons[i / 4][i % 4] = new Button("Play"); 
            buttons[i / 4][i % 4].addActionListener(this);
            panel.add(buttons[i / 4][i % 4]);
buttons[i/4][i%4].setBackground(Color.cyan) ;       
}
  }

    public void memc() {
        Frame frame = new Frame("Memory Game");        
        p = new Panel(new GridLayout(3, 4));
        p.setPreferredSize(new Dimension(500, 300));
        mcards(p);
        frame.setLayout(new BorderLayout());
        frame.add(p, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
frame.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent ee)
{
System.exit(0);
}
});

    }
  public void actionPerformed(ActionEvent e) 
{
 int r, c;
 if (i < 2) 
{ 
for (r = 0; r < 3; r++) 
{
for (c = 0; c < 4; c++) 
{
 if ((e.getSource() == buttons[r][c])&& (buttons[r][c].getLabel().equals("Play")) )
{  
buttons[r][c].setLabel(List2[(r * 4 + c)]);
i++; 
if (i == 1)
 one = (r * 4 + c); 
else
sec = (r * 4 + c);
 return;                 
}
}
}
}
else 
{
 for (r = 0; r < 3; r++)
 {
 for (c = 0; c < 4; c++) 
{
if(List2[one].equals(List2[sec])) 
{
if(!buttons[r][c].getLabel().equals("Play"))
{  
buttons[r][c].setLabel("Done");
buttons[r][c].setBackground(Color.magenta);                    
} 
}
 else if ((!buttons[r][c].getLabel().equals("Done"))&& (!buttons[r][c].getLabel().equals("Play")))
 {
  buttons[r][c].setLabel("Play");
   }
   i = 0; 
            }
        }
    }
}
}
