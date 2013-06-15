/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moppydesk.ui;

import moppydesk.inputs.MoppySequencer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Transmitter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.Timer;
import moppydesk.*;

/**
 *
 * @author Sam
 */
public class SequencerControls extends InputPanel implements MoppyStatusConsumer {

    MoppySequencer seq;
    MoppyControlWindow controlWindow;
    MoppyUI app;
    final JFileChooser sequenceChooser = new JFileChooser();
    Timer progressTimer;
    private boolean isConnected = false;
    private boolean fileLoaded = false;

    
    private DefaultListModel _Model;
    //Create a file chooser
    final JFileChooser _Fc;
    /**
     * Creates new form SequencerControls
     */
    public SequencerControls(MoppyUI app, MoppyControlWindow mcw, MoppySequencer newSequencer) {
        this.seq = newSequencer;
        this.app = app;
        this.controlWindow = mcw;

        initComponents();
        
        _Fc = new JFileChooser();
        _Fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        _Model = new DefaultListModel();
        jListPlayList.setModel(_Model);
        
        
        
        progressTimer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateProgressDisplay();
            }
        });
    }

    private void updateProgressDisplay() {
        long currentSeconds = seq.getSecondsPosition();
        sequenceProgressSlider.setValue((int) (currentSeconds));
        String currentPosition = String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(currentSeconds),
                currentSeconds % 60);
        String totalPosition = String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(seq.getSecondsLength()),
                seq.getSecondsLength() % 60);
        currentPositionLabel.setText(currentPosition);
        totalPositionLabel.setText(totalPosition);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sequenceNameLabel = new javax.swing.JLabel();
        bpmLabel = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        sequenceProgressSlider = new javax.swing.JSlider();
        currentPositionLabel = new javax.swing.JLabel();
        totalPositionLabel = new javax.swing.JLabel();
        jButtonPath = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlayList = new javax.swing.JList();
        jButtonGetList = new javax.swing.JButton();

        jLabel1.setText("Current Sequence:");

        sequenceNameLabel.setText("<None loaded>");

        bpmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bpmLabel.setText(jSlider1.getValue() + " bpm");

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(310);
        jSlider1.setMinimum(20);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(120);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1tempoSliderChanged(evt);
            }
        });

        startButton.setText("Start");
        startButton.setEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonClicked(evt);
            }
        });

        stopButton.setText("Stop/Reset");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonstopResetClicked(evt);
            }
        });

        loadButton.setText("Load Sequence");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonloadSequence(evt);
            }
        });

        sequenceProgressSlider.setToolTipText("");
        sequenceProgressSlider.setValue(0);
        sequenceProgressSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sequenceProgressDragged(evt);
            }
        });
        sequenceProgressSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sequenceProgressDragged(evt);
            }
        });

        currentPositionLabel.setText("00:00");

        totalPositionLabel.setText("00:00");

        jButtonPath.setText("Path");
        jButtonPath.setToolTipText("");
        jButtonPath.setActionCommand("");
        jButtonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPathActionPerformed(evt);
            }
        });

        jListPlayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPlayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPlayListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListPlayList);

        jButtonGetList.setText("Get List");
        jButtonGetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGetList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sequenceProgressSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPath)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldPath, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sequenceNameLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stopButton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bpmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPath)
                    .addComponent(loadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sequenceNameLabel)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stopButton)
                            .addComponent(startButton))
                        .addGap(18, 18, 18)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(bpmLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonGetList)
                        .addComponent(currentPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sequenceProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1tempoSliderChanged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1tempoSliderChanged
        JSlider s = (JSlider) evt.getSource();
        seq.setTempo(s.getValue());
        bpmLabel.setText(s.getValue() + " bpm");
    }//GEN-LAST:event_jSlider1tempoSliderChanged

    private void startButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonClicked
        if (startButton.getText().equals("Start")) {
            playSequencer();
        } else {
            pauseSequencer();
        }
    }//GEN-LAST:event_startButtonClicked

    private void playSequencer() {
        seq.startSequencer();
        seq.setTempo(jSlider1.getValue());
        controlWindow.setStatus("Playing!");
        startButton.setText("Pause");
    }

    private void pauseSequencer() {
        seq.stopSequencer();
        startButton.setText("Start");
        controlWindow.setStatus("...Paused");
    }

    private void stopResetSequencer() {
        if (seq.isRunning()) {
            controlWindow.setStatus("Stopping...");
            seq.stopSequencer();
            seq.resetSequencer();
            startButton.setText("Start");
            controlWindow.setStatus("Stopped.");
        } else {
            app.rm.reset();
            controlWindow.setStatus("Reset.");
        }
    }

    private void stopButtonstopResetClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonstopResetClicked
        stopResetSequencer();
    }//GEN-LAST:event_stopButtonstopResetClicked

    private void loadButtonloadSequence(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonloadSequence
        String previouslyLoaded = app.prefs.get(Constants.PREF_LOADED_SEQ, null);
        if (previouslyLoaded != null) {
            sequenceChooser.setCurrentDirectory(new File(previouslyLoaded));
        }
        int returnVal = sequenceChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            loadSequenceFile(sequenceChooser.getSelectedFile());
        } else {
            //Cancelled
        }
    }//GEN-LAST:event_loadButtonloadSequence

    private void sequenceProgressDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sequenceProgressDragged
        int seconds = ((JSlider) evt.getSource()).getValue();
        seq.setSecondsPosition(seconds);
        currentPositionLabel.setText(String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(seconds),
                seconds % 60));
    }//GEN-LAST:event_sequenceProgressDragged

    private void jButtonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPathActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == jButtonPath) {
            int returnVal = _Fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = _Fc.getSelectedFile();
                //This is where a real application would open the file.
                 System.out.println("Opening: " + file.getPath() + ".");
                 jTextFieldPath.setText(file.getPath());
            } else {
                System.out.println("Open command cancelled by user.");
            }
        }
    }//GEN-LAST:event_jButtonPathActionPerformed

    private void jListPlayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPlayListValueChanged
        // TODO add your handling code here:
        if (evt.getValueIsAdjusting() == false) {

            if (jListPlayList.getSelectedIndex() == -1) {
                //No selection, disable fire button.

            } else {
                System.out.println(jTextFieldPath.getText() + "\\" + jListPlayList.getSelectedValue());
                File sequenceFile = new File(jTextFieldPath.getText() + "\\" + jListPlayList.getSelectedValue());
                
                loadSequenceFile(sequenceFile);
            }
        }
    }//GEN-LAST:event_jListPlayListValueChanged

    private void jButtonGetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetListActionPerformed
        // TODO add your handling code here:
        String path = jTextFieldPath.getText();
        System.out.println(path);
        
        getFileList(jTextFieldPath.getText());
    }//GEN-LAST:event_jButtonGetListActionPerformed

    public void tempoChanged(int newTempo) {
        jSlider1.setValue(newTempo);
        bpmLabel.setText(newTempo + " bpm");
    }
    
    private void getFileList(String sPath) {
    
        //sPath == Directory path

        String files;
        File folder = new File(sPath);
        File[] listOfFiles = folder.listFiles(); 
 
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                
                if ( files.endsWith(".mid") || files.endsWith(".midi")){
                    System.out.println(files);
                    
                    // add items to the play list
                    _Model.addElement(files);
                   
                }
            }
        }
        
        jListPlayList.setSelectedIndex(0);
        jListPlayList.ensureIndexIsVisible(0);
    }

    public void loadSequenceFile(File sequenceFile) {
        try {
            controlWindow.setStatus("Loading file...");
            seq.loadFile(sequenceFile.getPath());
            sequenceNameLabel.setText(sequenceFile.getName());
            sequenceProgressSlider.setMaximum((int) (seq.getSecondsLength()));
            app.prefs.put(Constants.PREF_LOADED_SEQ, sequenceFile.getPath());
            fileLoaded = true;
            controlWindow.setStatus("Loaded " + sequenceFile.getName());
            updateProgressDisplay();
            if (isConnected) {
                startButton.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(MoppyControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            controlWindow.setStatus("File loading error!");
            JOptionPane.showMessageDialog(this.getRootPane(), ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bpmLabel;
    private javax.swing.JLabel currentPositionLabel;
    private javax.swing.JButton jButtonGetList;
    private javax.swing.JButton jButtonPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListPlayList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel sequenceNameLabel;
    private javax.swing.JSlider sequenceProgressSlider;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel totalPositionLabel;
    // End of variables declaration//GEN-END:variables

    public Transmitter getTransmitter() {
        return seq;
    }

    public void connected() {
        progressTimer.start();
        isConnected = true;
        if (fileLoaded) {
            startButton.setEnabled(true);
        }
    }

    public void disconnected() {
        startButton.setEnabled(false);
        pauseSequencer();
        isConnected = false;
        progressTimer.stop();
        seq.setReceiver(null); //Clear receiver so there's no connection here.
    }
}
