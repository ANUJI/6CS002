package wood020;

import java.awt.Color;
import java.awt.Graphics;

import wood020.PictureFrame.DominoPanel;

/**
 * @author Kevan Buckley, maintained by Jamie Wood
 * @version 2.0, 2014
 */

public class Domino implements Comparable<Domino> {
  public int high;
  public int low;
  public int hx;
  public int hy;
  public int lx;
  public int ly;
  public boolean placed = false;

  public Domino(int high, int low) {
    super();
    this.high = high;
    this.low = low;
  }
  
  public void place(int hx, int hy, int lx, int ly) {
    this.hx = hx;
    this.hy = hy;
    this.lx = lx;
    this.ly = ly;
    placed = true;
  }

  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("[");
    result.append(Integer.toString(high));
    result.append(Integer.toString(low));
    result.append("]");
    if(!placed){
      result.append("unplaced");
    } else {
      result.append("(");
      result.append(Integer.toString(hx+1));
      result.append(",");
      result.append(Integer.toString(hy+1));
      result.append(")");
      result.append("(");
      result.append(Integer.toString(lx+1));
      result.append(",");
      result.append(Integer.toString(ly+1));
      result.append(")");
    }
    return result.toString();
  }

  /** turn the domino around 180 degrees clockwise*/
  
  public void invert() {
    int tx = hx;
    hx = lx;
    lx = tx;
    
    int ty = hy;
    hy = ly;
    ly = ty;    
  }

  public boolean ishl() {    
    return hy==ly;
  }


  public int compareTo(Domino arg0) {
    if(this.high < arg0.high){
      return 1;
    }
    return this.low - arg0.low;
  }

public void drawDomino(Graphics g, DominoPanel dominoPanel) {
	if (this.placed) {
		int y = Math.min(this.ly, this.hy);
		int x = Math.min(this.lx, this.hx);
		int w = Math.abs(this.lx - this.hx) + 1;
		int h = Math.abs(this.ly - this.hy) + 1;
		g.setColor(Color.WHITE);
		g.fillRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
		g.setColor(Color.RED);
		g.drawRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
		dominoPanel.drawDigitGivenCentre(g, 30 + this.hx * 20,
				30 + this.hy * 20, 20, this.high, Color.BLUE);
		dominoPanel.drawDigitGivenCentre(g, 30 + this.lx * 20,
				30 + this.ly * 20, 20, this.low, Color.BLUE);
	}
}
  
  
  
}
