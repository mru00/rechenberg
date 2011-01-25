


    public ManhattanEdge(Node start, Node end) {
	super (start, end);
    }

    public void draw() {

	int x1 = getStart().getX();
	int x2 = getEnd().getX();
	int y1 = getStart().getY();
	int y2 = getEnd().getY();

	int y_mid = y2 + (y1 - y2)/2;

	Window.drawLine(x1, y1, x1, y_mid); 
	Window.drawLine(x2, y_mid, x2, y2); 
	Window.drawLine(x1, y_mid, x2, y_mid);

	Window.fillRectangle(x1 - edgeSize/2,
			     y_mid - edgeSize/2,
			     edgeSize,
			     edgeSize,
			     Color.black);

	Window.fillRectangle(x2 - edgeSize/2,
			     y_mid - edgeSize/2,
			     edgeSize,
			     edgeSize,
			     Color.black);
    }
}
