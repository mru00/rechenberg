package ui;

import phonebook.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame 
    extends JFrame
{

    private PhoneBook phonebook;
    private JTextField displayEntry;
    private JTextField searchEntry;
    private JTextField firstCharEntry;


    private JTextField nameEntry;
    private JTextField areaCodeEntry;
    private JTextField numberEntry;


    private final String filename = "phonebook.txt";

    public MainFrame(PhoneBook phonebook) {
	super ( "Phonebook" );
	this.phonebook = phonebook;

	loadData();
	setupUI();

	updateDisplay ( phonebook.firstEntry() );
    }

    private void loadData() {
	phonebook.loadFromFile(filename);
    }

    private void setupMenu() {
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	menuBar.add(fileMenu);

	fileMenu.add(new JMenuItem(saveAction));
	fileMenu.add(new JMenuItem(exitAction));

	setJMenuBar(menuBar);
    }

    private void setupUI() {
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setupMenu();

	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	JTabbedPane tp = new JTabbedPane();

	contentPane.add(tp, BorderLayout.CENTER);

	setupPaneBrowse(tp);
	setupPaneInsert(tp);

	switch(a){
	case 1:
	    break;
	case 2:
	    break;
	default:
	}

	for (int i=0; i<4; i++) {
	}

	do {
	} while(true);

	while(true){
	}

	i = 5+4*5/3%4;

	pack();
    }

    private void setupPaneBrowse(JTabbedPane parent) {

	searchEntry = new JTextField(10);
	displayEntry = new JTextField(20);
	firstCharEntry = new JTextField(1);

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();


	p1.add(displayEntry);

	p2.add( new JButton(firstButtonAction) );
	p2.add( new JButton(nextButtonAction) );
	p2.add( new JLabel("Starts with:"));
	p2.add( firstCharEntry );
	
	p3.add( searchEntry );
	p3.add( new JButton(searchButtonAction) );


       	p4.setLayout(new GridLayout(4,1));
	p4.add(displayEntry);
	p4.add(p2);
	p4.add(p3);

	firstCharEntry.addActionListener(startsWithButtonAction);
	searchEntry.addActionListener(searchButtonAction);
	displayEntry.setEditable(false);

	parent.add("Browse", p4);
    }

    private void setupPaneInsert(JTabbedPane parent) {

	nameEntry = new JTextField(10);
	areaCodeEntry = new JTextField(10);
	numberEntry = new JTextField(10);

	JPanel p1 = new JPanel();
	JPanel p;

	p1.setLayout(new GridLayout(4,1));

	p = new JPanel();
	p.add(new JLabel("Name:"));
	p.add(nameEntry);
	p1.add(p);

	p = new JPanel();
	p.add(new JLabel("Area Code:"));
	p.add(areaCodeEntry);
	p1.add(p);

	p = new JPanel();
	p.add(new JLabel("Number:"));
	p.add(numberEntry);
	p1.add(p);

	p = new JPanel();
	p.add(new JButton(insertButtonAction));
	p1.add(p);

	parent.add("Insert", p1);
    }

    public void run() {
	setLocation(100,100);
	setVisible(true);
    }

    private void updateDisplay(phonebook.Entry e) {
	if ( e != null ) 
	    displayEntry.setText ( e.toString() );
	else 
	    displayEntry.setText ( "no item" );
    }
    
    /* sdaf 
xcv


zxcv
*/

    // action implementations
    private Action exitAction = new AbstractAction("Exit") {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		System.exit(0);
	    }
	};


    private Action saveAction = new AbstractAction("Save") {
	    public void actionPerformed(ActionEvent e) {		
		phonebook.saveToFile(filename);
	    }
	};

    private Action nextButtonAction = new AbstractAction("Next") {
	    public void actionPerformed(ActionEvent e) {		
		updateDisplay(phonebook.nextEntry());
	    }
	};

    private Action firstButtonAction = new AbstractAction("First") {
	    public void actionPerformed(ActionEvent e) {
		updateDisplay(phonebook.firstEntry());
	    }
	};

    private Action searchButtonAction = new AbstractAction("Search") {
	    public void actionPerformed(ActionEvent e) {		
		updateDisplay(
		   phonebook.lookupEntry(
		       searchEntry.getText()));
	    }
	};

    private Action startsWithButtonAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {		
		updateDisplay(
		   phonebook.firstEntryWithChar(
                      firstCharEntry.getText().charAt(0)));
	    }
	};

    private Action insertButtonAction = new AbstractAction("Insert") {
	    public void actionPerformed(ActionEvent e) {
		try {
		    phonebook.insertEntry ( 
			nameEntry.getText(),
		        Integer.parseInt(areaCodeEntry.getText()),
		        Integer.parseInt(numberEntry.getText()));
		}
		catch (NumberFormatException excep) {
		    JOptionPane.showMessageDialog(MainFrame.this, "Wrong number format!");
		    
		}
	    }
	};
}
