package com.gmail.benrcarver.FinalProject;

/*
 * author: Ben Carver
 * period 5 AP Computer Science
 */

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Canvas extends JFrame {
	/*
	 * Components of the GUI
	 */
    private javax.swing.JCheckBox checkBoxFilled;
    private javax.swing.JButton circleButton;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel coordinatesLabel;
    private javax.swing.JTextField cordTextField;
    private javax.swing.JLabel effectsLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField flucuateSizeTextField;
    private javax.swing.JToggleButton flucuateSizeToggleButton;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JInternalFrame internalCanvas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton morphEffectButton;
    private javax.swing.JTextField morphSpeedTextField;
    private javax.swing.JToggleButton rainbowToggleButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel shapesLabel;
    private javax.swing.JLabel strokeLabel;
    private javax.swing.JTextField strokeTextField;
    private javax.swing.JButton triangleButton;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    
    /*
     * Instance fields 
     */
	private static ArrayList<Shape> shapes = new ArrayList<Shape>(); 
    //private static ArrayList<Integer> sizes = new ArrayList<Integer>();
	
    private Color currentColor;
	private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    
    private int currentHeight = 50;
    private int currentWidth = 50;
    private int currentStroke = 4;
    private int rainbowPos = 0;
    private int sizeFluctuationIndex = 0;
    private int sizeMorphIndexHeight = 0;
    private int sizeMorphIndexWidth = 450;
    private int morphSpeed = 10;
    private int fluctuateSpeed = 10;
	private int activeShape = 2; //1 = circle, 2 = rectangle, 3 = triangle  
    
    private boolean morphUpHeight = true;
    private boolean morphDownWidth = true;
    private boolean fluxUp = true;
    private boolean rainbowEnabeled = false;
    private boolean sizeFluctuation = false;
    private boolean morphEnabeled = false;
    
    /*
     * Constructor 
     */
	public Canvas() {
		initComponents();
	}
	
	/*
	 * Builds and initalizes the GUI
	 */
	private void initComponents() {

        colorChooser = new javax.swing.JColorChooser();
        internalCanvas = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        shapesLabel = new javax.swing.JLabel();
        rectangleButton = new javax.swing.JButton();
        circleButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        resetButton = new javax.swing.JButton();
        heightTextField = new javax.swing.JTextField();
        heightLabel = new javax.swing.JLabel();
        widthLabel = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        checkBoxFilled = new javax.swing.JCheckBox();
        strokeLabel = new javax.swing.JLabel();
        strokeTextField = new javax.swing.JTextField();
        cordTextField = new javax.swing.JTextField();
        coordinatesLabel = new javax.swing.JLabel();
        rainbowToggleButton = new javax.swing.JToggleButton();
        flucuateSizeToggleButton = new javax.swing.JToggleButton();
        flucuateSizeTextField = new javax.swing.JTextField();
        morphEffectButton = new javax.swing.JToggleButton();
        morphSpeedTextField = new javax.swing.JTextField();
        effectsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        colorChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorChooserMouseEntered(evt);
            }
        });
        colorChooser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                colorChooserMouseMoved(evt);
            }
        });

        internalCanvas.setBackground(new java.awt.Color(255, 255, 255));
        internalCanvas.setVisible(true);
        internalCanvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                internalCanvasMouseClicked(evt);
            }
        });
        internalCanvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                internalCanvasMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                internalCanvasMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout internalCanvasLayout = new javax.swing.GroupLayout(internalCanvas.getContentPane());
        internalCanvas.getContentPane().setLayout(internalCanvasLayout);
        internalCanvasLayout.setHorizontalGroup(
            internalCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        internalCanvasLayout.setVerticalGroup(
            internalCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        shapesLabel.setText("Shapes");

        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        circleButton.setText("Circle");
        circleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Clear Ink");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        heightTextField.setText("50");
        heightTextField.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                heightTextFieldMouseWheelMoved(evt);
            }
        });
        heightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightTextFieldActionPerformed(evt);
            }
        });

        heightLabel.setText("Height");

        widthLabel.setText("Width");

        widthTextField.setText("50");
        widthTextField.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                widthTextFieldMouseWheelMoved(evt);
            }
        });
        widthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthTextFieldActionPerformed(evt);
            }
        });

        checkBoxFilled.setText("Filled ");

        strokeLabel.setText("Stroke:");

        strokeTextField.setText("4");
        strokeTextField.setToolTipText("");
        strokeTextField.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                strokeTextFieldMouseWheelMoved(evt);
            }
        });
        strokeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeTextFieldActionPerformed(evt);
            }
        });

        cordTextField.setToolTipText("");

        coordinatesLabel.setText("Coordinates");

        rainbowToggleButton.setText("Rainbow Effect");
        rainbowToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rainbowToggleButtonActionPerformed(evt);
            }
        });

        flucuateSizeToggleButton.setText("Fluctuate Effect");
        flucuateSizeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flucuateSizeToggleButtonActionPerformed(evt);
            }
        });

        flucuateSizeTextField.setText("10");
        flucuateSizeTextField.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                flucuateSizeTextFieldMouseWheelMoved(evt);
            }
        });
        flucuateSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flucuateSizeTextFieldActionPerformed(evt);
            }
        });

        morphEffectButton.setText("Morph Effect");
        morphEffectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                morphEffectButtonActionPerformed(evt);
            }
        });

        morphSpeedTextField.setText("10");
        morphSpeedTextField.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            	morphSpeedTextFieldMouseWheelMoved(evt);
            }
        });
        morphSpeedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	morphSpeedTextFieldActionPerformed(evt);
            }
        });

        effectsLabel.setText("Effects");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(internalCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(circleButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rectangleButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(shapesLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkBoxFilled)
                                        .addGap(18, 18, 18)
                                        .addComponent(strokeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(strokeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(212, 212, 212)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heightLabel)
                                    .addComponent(widthLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heightTextField)
                                    .addComponent(widthTextField)))
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(406, 406, 406)
                                .addComponent(resetButton))
                            .addComponent(coordinatesLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(effectsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rainbowToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(flucuateSizeToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(flucuateSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(morphEffectButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(morphSpeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shapesLabel)
                            .addComponent(heightLabel)
                            .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxFilled)
                            .addComponent(strokeLabel)
                            .addComponent(strokeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(widthLabel)
                                    .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(circleButton)
                                    .addComponent(rectangleButton))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(effectsLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rainbowToggleButton)
                                .addComponent(flucuateSizeToggleButton)
                                .addComponent(flucuateSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(morphEffectButton)
                                .addComponent(morphSpeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(coordinatesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton)
                            .addComponent(cordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(internalCanvas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                                             

	/*
	 * Method that executes when the Rectangle button is clicked
	 * Causes the shape to be drawn to be a rectangle 
	 */
    private void rectangleButtonActionPerformed(ActionEvent evt) {                                                
    	System.out.println("Rectangle Button Clicked!");
    	activeShape = 2;
    	//System.out.println(getActiveShape());
    }  
	
    /*
	 * Method that executes when the Circle button is clicked
	 * Causes the shape to be drawn to be a circle  
	 */
    private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	System.out.println("Circle Button Clicked!");
    	activeShape = 1;
    	//System.out.println(getActiveShape());
    }     
    
    /*
     * Method that executes when the Reset or Clear Ink button is clicked 
     * Removes all shapes from the screen, redraws all componenents 
     */
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Graphics g = getGraphics();
        int count = 0;
        for(Shape s: shapes) {
        	g.clearRect(s.getXCord(), s.getYCord(), s.getHeight() + 100, s.getWidth() + 100);
        	s = null;
        	count++;
        }
        System.out.println(count);
        repaint(); //Redraws all the components 
    }  

    //Changes the current color depending on what color is selected in the color chooser 
    private void colorChooserMouseMoved(java.awt.event.MouseEvent evt) {                                        
    	currentColor = colorChooser.getColor();
    }             
    
    /*
     * The method handles mouse clicking in the drawing canvas. 
     * It determines how and where to draw the shapes, which shape to draw, and draws it.
     */
    private void internalCanvasMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	   int x = evt.getX();
		   int y = evt.getY();
		   BasicStroke stroke = new BasicStroke(getCurrentStroke());
		   Graphics g = getGraphics();
		   if(!rainbowEnabeled) currentColor = colorChooser.getColor();
		   else currentColor = rainbowAlterColor();
		   if(sizeFluctuation) {
			   currentHeight = fluctuateSpeed(getFluctuateSpeed()); //Need a field to enter the parameter 
			   currentWidth = fluctuateSpeed(getFluctuateSpeed()); //Need a field to enter the parameter 
		   } else if(morphEnabeled) {
			   currentHeight = morphSpeedHeight(getMorphSpeed());
			   currentWidth = morphSpeedWidth(getMorphSpeed()); 
		   } else {
			   currentHeight = getCurrentHeight();
			   currentWidth = getCurrentWidth();  
		   }
		   boolean filled = checkBoxFilled.isSelected();
		   System.out.println(x + "," + y);
		   System.out.println(getActiveShape());
		   System.out.println("Height: " + currentWidth + ", Width: " + currentHeight);
		   Lansana l = new Lansana();
		   l.draw(x, y, getGraphics());
		   if(activeShape == 1) {
			   Circle cir = new Circle(currentColor, x, y, currentWidth, currentHeight, filled, stroke);
			   cir.draw((Graphics2D) g);
		   } else if(activeShape == 2) {
			   Rectangle rect = new Rectangle(currentColor, x, y, currentWidth, currentHeight, filled, stroke);
			   getGraphics().setColor(rect.getColor());
			   rect.draw((Graphics2D) g);
		   } else {
			   Triangle tri = new Triangle(Color.RED, x, y, currentWidth, currentHeight, filled, stroke);
			   tri.draw(getGraphics());
		   }
    }    
    
    /*
     * The method handles mouse dragging in the drawing canvas. 
     * It determines how and where to draw the shapes, which shape to draw, and draws it.
     */
    private void internalCanvasMouseDragged(java.awt.event.MouseEvent evt) {                                            
		   int x = evt.getX();
		   int y = evt.getY();
		   BasicStroke stroke = new BasicStroke(getCurrentStroke());
		   Graphics g = getGraphics();
		   if(!rainbowEnabeled) currentColor = colorChooser.getColor();
		   else currentColor = rainbowAlterColor();
		   if(sizeFluctuation) {
			   currentHeight = fluctuateSpeed(getFluctuateSpeed()); //Need a field to enter the parameter 
			   currentWidth = fluctuateSpeed(getFluctuateSpeed()); //Need a field to enter the parameter 
		   } else if(morphEnabeled) {
			   currentHeight = morphSpeedHeight(getMorphSpeed());
			   currentWidth = morphSpeedWidth(getMorphSpeed()); 
		   } else {
			   currentHeight = getCurrentHeight();
			   currentWidth = getCurrentWidth();  
		   }
		   boolean filled = checkBoxFilled.isSelected();
		   System.out.println(x + "," + y);
		   System.out.println(getActiveShape());
		   System.out.println("Height: " + currentWidth + ", Width: " + currentHeight);
		   if(activeShape == 1) {
			   Circle cir = new Circle(currentColor, x, y, currentWidth, currentHeight, filled, stroke);
			   cir.draw((Graphics2D) g);
		   } else if(activeShape == 2) {
			   Rectangle rect = new Rectangle(currentColor, x, y, currentWidth, currentHeight, filled, stroke);
			   getGraphics().setColor(rect.getColor());
			   rect.draw((Graphics2D) g);
		   } else {
			   Triangle tri = new Triangle(Color.RED, x, y, currentWidth, currentHeight, filled, stroke);
			   tri.draw(getGraphics());
		   }
    }  
    
    //Assigns the height of the shape to the value of the height text field when an action is performed on the height text field
    private void heightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
        currentHeight = getCurrentHeight();
    }                                               

    //Assigns the width of the shape to the value of the width text field when an action is performed on the width text field
    private void widthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        currentWidth = getCurrentWidth();
    }    
    
    /*
     * This method makes sure that the values in the height and width text field are numbers and not letters or other symbols 
     */
    private void veryifyHeightAndWidth() {
    	if(!(heightTextField.getText().matches("[0-9]+"))) {
    		heightTextField.setText("50");
    	}
    	if(!widthTextField.getText().matches("[0-9]+")) {
    		widthTextField.setText(heightTextField.getText());
    	}
    	currentHeight = Integer.parseInt(heightTextField.getText());
    	currentWidth = Integer.parseInt(widthTextField.getText());
    }
    
    /*
     * Makes sure the height and width are appropriate and returns the height 
     */
    private int getCurrentHeight() {
    	veryifyHeightAndWidth();
    	return currentHeight;
    }
    
    /*
     * Makes sure the height and width are appropriate and returns the width 
     */
    private int getCurrentWidth() {
    	veryifyHeightAndWidth();
    	return currentWidth;
    }
    
    /*
     * Updates the color of shapes to be drawn when the mouse touches the color chooser 
     */
    private void colorChooserMouseEntered(java.awt.event.MouseEvent evt) {                                          
    	currentColor = colorChooser.getColor();
    }                                                         
    
    /*
     * Verifies that the value of the stroke text field is a number and not a letter or other symbol when an action is performed on that text field
     */
    private void strokeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	if(!(strokeTextField.getText().matches("[0-9]+"))) {
    		strokeTextField.setText("4");
    	}
    	
    	currentStroke = Integer.parseInt(strokeTextField.getText());
    }      
    
    /*
     * Makes sure that the value of the stroke text field is aprorpiate and returns it 
     */
    public int getCurrentStroke() {
    	if(!(strokeTextField.getText().matches("[0-9]+"))) {
    		strokeTextField.setText("4");
    	}
    	
    	currentStroke = Integer.parseInt(strokeTextField.getText());
    	
    	return currentStroke;
    }
    
    /*
     * Updates the value of the coordinate text field based on the position of the mouse when it moves on the internal canvas 
     */
    private void internalCanvasMouseMoved(java.awt.event.MouseEvent evt) {                                          
    	int x = evt.getX();
		int y = evt.getY();
		cordTextField.setText("( " + x + " , " + y + ")");
    }   
    
    /*
     * increments or decrements the value of the stroke text field when the mousewheel is scrolled while the mouse is touching the
     * text field. 
     */
    private void strokeTextFieldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                                
        int wheelRotation = evt.getWheelRotation();
        //1 is down, -1 is up..
        int value = Integer.parseInt(strokeTextField.getText());
        if(wheelRotation > 0) {
        	if(value > 0) {
        		value -= 1;
        	}
        } else {
        	value += 1;
        }
        String str = value + "";
        strokeTextField.setText(str);
    }                                                  

    /*
     * increments or decrements the value of the height text field when the mousewheel is scrolled while the mouse is touching the
     * text field. 
     */
    private void heightTextFieldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                                
        int wheelRotation = evt.getWheelRotation();
        //1 is down, -1 is up..
        int value = Integer.parseInt(heightTextField.getText());
        if(wheelRotation > 0) {
        	if(value > 0) {
        		value -= 1;
        	}
        } else {
        	value += 1;
        }
        String str = value + "";
        heightTextField.setText(str);
    }                                               

    /*
     * increments or decrements the value of the width text field when the mousewheel is scrolled while the mouse is touching the
     * text field. 
     */
    private void widthTextFieldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                               
        int wheelRotation = evt.getWheelRotation();
        //1 is down, -1 is up..
        int value = Integer.parseInt(widthTextField.getText());
        if(wheelRotation > 0) {
        	if(value > 0) {
        		value -= 1;
        	}
        } else {
        	value += 1;
        }
        String str = value + "";
        widthTextField.setText(str);
    }       
    
    /*
     * returns the shapes ArrayList
     */
    public static ArrayList<Shape> getShapes() {
    	return shapes;
    }

    //fluctuates the size of the shape for the fluctuate effect based on the speed value provided by the user in the flutcuate speed text field
    //fluctuation causes the height and width to have a direct relationship 
    public int fluctuateSpeed(int speed) {
    	int s = sizeFluctuationIndex;
    	if(sizeFluctuationIndex < 500 && fluxUp) {
    		sizeFluctuationIndex += speed;
    	} 
    	if(!(sizeFluctuationIndex < 500) && fluxUp) {
    		fluxUp = !fluxUp;
    	}
    	if(!fluxUp && sizeFluctuationIndex > 0) {
    		sizeFluctuationIndex -= speed;
    	}
    	if(!fluxUp && !(sizeFluctuationIndex > 0)) {
    		fluxUp = !fluxUp;
    	}
    	
    	return s;
    }
    
    //morphs the height of the shape for the morph effect based on the speed value provided by the user in the morph speed text field
    //fluctuation causes the height and width to have a indirect relationship 
    public int morphSpeedHeight(int speed) {
    	int s = sizeMorphIndexHeight; 
    	if(morphUpHeight && sizeMorphIndexHeight < 500) {
    		sizeMorphIndexHeight += speed;
    	}
    	if(!(sizeMorphIndexHeight < 499) && morphUpHeight) {
    		morphUpHeight = !morphUpHeight;
    	}
    	if(!morphUpHeight && sizeMorphIndexHeight > 0) {
    		sizeMorphIndexHeight -= speed;
    	}
    	if(!morphUpHeight && !(sizeMorphIndexHeight > 0)) {
    		morphUpHeight = !morphUpHeight;
    	}
    	return s;
    }
    
    //morphs the width of the shape for the morph effect based on the speed value provided by the user in the morph speed text field
    //fluctuation causes the height and width to have a indirect relationship 
    public int morphSpeedWidth(int speed) {
    	int s = sizeMorphIndexWidth;
    	if(morphDownWidth && sizeMorphIndexWidth > 0) {
    		sizeMorphIndexWidth -= speed;
    	}
    	if(!(sizeMorphIndexWidth < 500) && !morphDownWidth) {
    		morphDownWidth = !morphDownWidth;
    	}
    	if(!morphDownWidth && sizeMorphIndexWidth < 500) {
    		sizeMorphIndexWidth += speed;
    	}
    	if(morphDownWidth && !(sizeMorphIndexWidth > 0)) {
    		morphDownWidth = !morphDownWidth;
    	}
    	return s;
    }
    
    /* private int jitterWidth(int amount) {
    	int newWidth = getWidth();
    	
    	
    	return newWidth;
    }
    
    private int jitterHeight(int amount) {
    	int newHeight = getHeight();
    	
    	return newHeight;
    } */
    
    /*
     * private int sizeMorphIndexHeight = 0;
       private int sizeMorphIndexWidth = 0;	
       private boolean morphUpHeight = true;
       private boolean morphDownWidth = true;
     * 
     */
    
    /*
     * Changes the color of the shape to be drawn for the rainbow effect based on the position of the array of Colors color. 
     * The colors in color are organized in the order of the colors of a rainbow. 
     */
    public Color rainbowAlterColor() {
    	Color color = colors[rainbowPos];
    	if(rainbowPos < 5) {
    		rainbowPos++;
    	} else {
    		rainbowPos = 0;
    	}
    	return color;
    }
    
    /*
     * Verifies that the values of the fluctuate speed text field are digits and fixes them if they aren't 
     */
    private void flucuateSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                      
    	if(!(flucuateSizeTextField.getText().matches("[0-9]+"))) {
    		flucuateSizeTextField.setText("4");
    	}
    	
    	int test = Integer.parseInt(flucuateSizeTextField.getText());
    	
    	if(test > 50) {
    		test = 50;
    		String str = test + "";
    		flucuateSizeTextField.setText(str);
    	}
    	
    	fluctuateSpeed = getFluctuateSpeed();
    }     
    
    /*
     * Verifies that the values of the fluctuate speed text field are digits and fixes them if they aren't 
     * returns the speed
     */
    public int getFluctuateSpeed() {
    	if(!(strokeTextField.getText().matches("[0-9]+"))) {
    		strokeTextField.setText("10");
    	}
    	
    	fluctuateSpeed = Integer.parseInt(flucuateSizeTextField.getText());
    	
    	int test = Integer.parseInt(flucuateSizeTextField.getText());
    	
    	if(test > 50) {
    		test = 50;
    		String str = test + "";
    		flucuateSizeTextField.setText(str);
    	}
    	
    	return fluctuateSpeed;
    }

    /*
     * Verifies that the values of the morph speed text field are digits and fixes them if they aren't 
     */
    private void morphSpeedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    	if(!(morphSpeedTextField.getText().matches("[0-9]+"))) {
    		morphSpeedTextField.setText("10");
    	}
    	
    	int test = Integer.parseInt(morphSpeedTextField.getText());
    	
    	if(test > 50) {
    		test = 50;
    		String str = test + "";
    		morphSpeedTextField.setText(str);
    	}
    	
    	morphSpeed = getMorphSpeed();
    }      
    
    /*
     * Verifies that the values of the morph speed text field are digits and fixes them if they aren't 
     * returns the speed
     */
    public int getMorphSpeed() {
    	if(!(morphSpeedTextField.getText().matches("[0-9]+"))) {
    		morphSpeedTextField.setText("10");
    	}
    	
    	int test = Integer.parseInt(morphSpeedTextField.getText());
    	
    	if(test > 50) {
    		test = 50;
    		String str = test + "";
    		morphSpeedTextField.setText(str);
    	}
    	
    	morphSpeed = Integer.parseInt(morphSpeedTextField.getText());
    	
    	return morphSpeed;
    }

    /*
     * Enables or disables the rainbow effect when the rainbow button is clicked 
     */
    private void rainbowToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        rainbowEnabeled = !rainbowEnabeled;
    }                                                   

    /*
     * Enables or disables the fluctuate effect when the fluctuate button is clicked
     */
    private void flucuateSizeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                         
    	morphEffectButton.setSelected(false);
    	sizeFluctuation = !sizeFluctuation;
    	fluctuateSpeed = getFluctuateSpeed();
    	morphEnabeled = false;
    }                                                        

    /*
     * Enables or disables the morph effect when the morph button is clicked
     */
    private void morphEffectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        flucuateSizeToggleButton.setSelected(false);
        morphEnabeled = !morphEnabeled;
        morphSpeed = getMorphSpeed();
        sizeFluctuation = false;
    }                                                 

    /*
     * Increments or decrements the value of the morph speed text field when the mouse wheel is scrolled while the mouse is touching
     * the text field 
     */
    private void morphSpeedTextFieldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                                   
    	int wheelRotation = evt.getWheelRotation();
        //1 is down, -1 is up..
        int value = Integer.parseInt(morphSpeedTextField.getText());
        if(wheelRotation > 0) {
        	if(value > 0) {
        		value -= 1;
        	}
        } else if(value < 501) {
        	value += 1;
        }
        String str = value + "";
        morphSpeedTextField.setText(str);
    }                                                  

    /*
     * Increments or decrements the value of the flucuate speed text field when the mouse wheel is scrolled while the mouse is touching
     * the text field 
     */
    private void flucuateSizeTextFieldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                                      
    	int wheelRotation = evt.getWheelRotation();
        //1 is down, -1 is up..
        int value = Integer.parseInt(flucuateSizeTextField.getText());
        if(wheelRotation > 0) {
        	if(value > 0) {
        		value -= 1;
        	}
        } else if(value < 501) {
        	value += 1;
        }
        String str = value + "";
        flucuateSizeTextField.setText(str);
    }              
    
    /*
     * Returns the current shape in String form
     */
	private String getActiveShape() {
		if(activeShape == 1) return "Circle";
		else if(activeShape == 2) return "Rectangle";
		else return "Triangle";
	}
    
    /*
     * Main method
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Canvas().setVisible(true);
            }
        });
    }
}
