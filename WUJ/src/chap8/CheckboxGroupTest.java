package chap8;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//라디오박스도 체크박스의 일종이다 (라디오형 체크박스) - 따라서 item이벤트가 발생한다!!
public class CheckboxGroupTest extends Applet implements ItemListener {
	
	Label myLabel;
	Checkbox myCheckbox1, myCheckbox2, myCheckbox3;
	CheckboxGroup group;
	
	public void init() {
		group = new CheckboxGroup();
		
		myCheckbox1 = new Checkbox("c", false, group);
		myCheckbox1.addItemListener(this);
		add(myCheckbox1);
		
		myCheckbox2 = new Checkbox("c++", false, group);
		myCheckbox2.addItemListener(this);
		add(myCheckbox2);
		
		myCheckbox3 = new Checkbox("java", false, group);
		myCheckbox3.addItemListener(this);
		add(myCheckbox3);
		
		myLabel = new Label("선택하세요", Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == myCheckbox1)	myLabel.setText("C");
		else if(e.getSource() == myCheckbox2)	myLabel.setText("C++");
		else if(e.getSource() == myCheckbox3)	myLabel.setText("java");
	} 
	

}
