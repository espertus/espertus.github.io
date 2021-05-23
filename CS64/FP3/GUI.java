package edu.mills.cs64.final_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * Provides a GUI for getting information about transcripts and
 * core requirements. Specifically, a transcript can be loaded
 * and be displayed along with the core requirements satisfied.
 * This can also recommend courses to satisfy remaining core
 * requirements.
 * 
 * @author [replace the brackets and this text with your Mills id]
 * @version April 25, 2016
 */
public class GUI
{
  private static final String COURSES_FILE = "courses.txt";
  private Transcript currentTranscript;
  
  // GUI constants
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;
  private static final int MAX_VERTICAL_GAP = 6;
  private static final String TITLE = "Core Requirements Calculator";
  private static final String INSTRUCTIONS =
      // Beginning with the "<html>" tag enables using HTML like "<br>"
      // for line breaks.
      "<html>Find out what core requirements are satisfied by a transcript<br>" +
      "and what courses to take to satisfy the remaining requirements.<br>" +
      "Begin by loading a transcript.</html>";
  private static final String LOAD_TRANSCRIPT = "Load Transcript";
  private static final String EXIT = "Exit";

  // GUI components
  private JFrame frame;
  private JLabel instructionsLabel; // instructions to user
  private JTextArea feedbackArea;   // feedback to user
  private JTextArea transcriptArea; // where to display transcript
  private JButton loadTranscriptButton; // click on to load a transcript
  private JButton exitButton;           // click on to exit

  private GUI()
  {
    // Initialize the frame.
    frame = new JFrame(TITLE);
    frame.setSize(WIDTH, HEIGHT);
    // Make program end when this frame is closed.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Center the frame on the screen.
    frame.setLocationRelativeTo(null);

    // Create GUI components.
    instructionsLabel = new JLabel(INSTRUCTIONS, SwingConstants.CENTER);
    loadTranscriptButton = new JButton(LOAD_TRANSCRIPT);
    exitButton = new JButton(EXIT);
    feedbackArea = new JTextArea();
    transcriptArea = new JTextArea();
    JScrollPane transcriptPane = new JScrollPane(transcriptArea);

    // Add listeners.
    loadTranscriptButton.addActionListener(new LoadTranscriptButtonHandler());

    // Lay out components.
    GroupLayout layout = new GroupLayout(frame.getContentPane());
    layout.setHorizontalGroup(
        layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(instructionsLabel)
            .addComponent(loadTranscriptButton)
            .addComponent(exitButton)
            .addComponent(feedbackArea))
        .addComponent(transcriptPane));
    frame.getContentPane().setLayout(layout);
    layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addComponent(instructionsLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                    GroupLayout.DEFAULT_SIZE, MAX_VERTICAL_GAP)
                .addComponent(loadTranscriptButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                    GroupLayout.DEFAULT_SIZE, MAX_VERTICAL_GAP)
                .addComponent(exitButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(feedbackArea))
            .addComponent(transcriptPane)));         
  }

  public void setVisibility(boolean visibility)
  {
    frame.setVisible(visibility);
  }

  public class LoadTranscriptButtonHandler implements ActionListener
  {
    // Create a file chooser that starts in the directory of the project.
    private JFileChooser fileChooser = 
        new JFileChooser(System.getProperty("user.dir"));

    @Override
    public void actionPerformed(ActionEvent ae)
    {
      int retval = fileChooser.showOpenDialog(frame);
      switch (retval)
      {
      case JFileChooser.CANCEL_OPTION:
        feedbackArea.append("Load transcript operation cancelled.\n");
        break;
      case JFileChooser.APPROVE_OPTION:
        // TODO:
        // 1. Load the transcript from the selected file.
        //    If an exception occurs, display an appropriate error
        //    message and return.
        // 2. Display a confirmation message in feedbackArea that
        //    says that a file was loaded and giving its path.
        // 3. Display the transcript in transcriptArea.
        break;
      case JFileChooser.ERROR_OPTION:
        feedbackArea.append("Error with load transcript dialog.");
        break;
      }
    }  
  }

  public static void main(String[] args)
  {
    try {
      // Read in courses.
      Course.loadCourses(COURSES_FILE);
    } catch (FileNotFoundException e) {
      System.err.println("Unable to load required file " + COURSES_FILE);
      return;
    }
    GUI gui = new GUI();
    gui.setVisibility(true);
  }

}
