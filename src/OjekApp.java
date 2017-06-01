import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OjekApp extends javax.swing.JFrame {

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel configPanel;
    private javax.swing.JButton executeBtn;
    private javax.swing.JTextField finishField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JButton saveHistory;
    private javax.swing.JComboBox<String> serviceTypeSelector;
    private javax.swing.JButton showMapBtn;
    private javax.swing.JTextField startField;
    private javax.swing.JTextArea tripSummaryArea;
    private java.awt.Graphics2D mapGraphics;
    private OwjekService ojek;
    private Map peta;
    private String startCoordinate;
    private String finishCoordinate;
    private String serviceType;

    public OjekApp() {
        initComponents();
        peta = new Map();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        mapPanel = new javax.swing.JPanel();
        configPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startField = new javax.swing.JTextField();
        finishField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        executeBtn = new javax.swing.JButton();
        showMapBtn = new javax.swing.JButton();
        saveHistory = new javax.swing.JButton();
        serviceTypeSelector = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tripSummaryArea = new javax.swing.JTextArea();
        tripSummaryArea.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OW-JEK Main Application");

        mapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 838, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 406, Short.MAX_VALUE)
        );

        configPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("OW-JEK");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);// NOI18N
        jLabel2.setText("Application");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap(64, Short.MAX_VALUE))
        );

        startField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startFieldActionPerformed(evt);
            }
        });

        finishField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Go From");

        jLabel4.setText("Destination");

        jLabel5.setText("Select Service Type");

        executeBtn.setText("Ride!");
        executeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeBtnActionPerformed(evt);
            }
        });

        showMapBtn.setText("Show Map");
        showMapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMapBtnActionPerformed(evt);
            }
        });

        saveHistory.setText("Save History");
        saveHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHistoryActionPerformed(evt);
            }
        });

        serviceTypeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Sporty", "Exclusive" }));
        serviceTypeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceTypeSelectorActionPerformed(evt);
            }
        });

        tripSummaryArea.setColumns(20);
        tripSummaryArea.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tripSummaryArea.setRows(5);
        tripSummaryArea.setText("Your trip summary will be shown here...");
        jScrollPane2.setViewportView(tripSummaryArea);

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
                configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(configPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(configPanelLayout.createSequentialGroup()
                                                .addComponent(executeBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showMapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(saveHistory))
                                        .addGroup(configPanelLayout.createSequentialGroup()
                                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(finishField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGap(34, 34, 34)
                                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(serviceTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        configPanelLayout.setVerticalGroup(
                configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addGroup(configPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(serviceTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finishField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(executeBtn)
                                        .addComponent(showMapBtn)
                                        .addComponent(saveHistory))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        pack();
    }

    //[Show Map] Button
    private void showMapBtnActionPerformed(java.awt.event.ActionEvent evt) {
        tripSummaryArea.setText("Your trip summary will be shown here...");
        mapGraphics = (Graphics2D) mapPanel.getGraphics();
        try{
            FileReader mapFile = new FileReader("map.txt");
            Scanner input = new Scanner(mapFile);
            int line = 0;
            while (input.hasNextLine()){
                String textLine = input.nextLine();
                for (int i = 0; i < textLine.length(); i++){
                    if (textLine.charAt(i) == '#'){
                        mapGraphics.setColor(Color.black);
                        mapGraphics.fillRect(5+(i*8),5+(line*8),10,12);
                    }
                    else {
                        mapGraphics.setColor(Color.WHITE);
                        mapGraphics.fillRect(5+(i*8),5+(line*8),10,12);
                    }
                }
                line++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //[Save History] button
    private void saveHistoryActionPerformed(java.awt.event.ActionEvent evt){
        try{
            File tripReceipt = new File("tripReceipt.txt");
            FileWriter fileWriter = new FileWriter(tripReceipt);

            fileWriter.write(tripSummaryArea.getText());
            fileWriter.close();

            JOptionPane.showMessageDialog(null, "Trip Summary telah berhasil disimpan.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    //[Ride!] button
    private void executeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            if (startCoordinate.equals(finishCoordinate)){
                JOptionPane.showMessageDialog(null, "Anda tidak dapat melakukan perjalanan berjarak 0 KM.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }

            if (serviceType.equals("Regular")) {
                int distance = OwjekService.shortestPath(startCoordinate, finishCoordinate, peta);
                ojek = new OwjekRegular(startCoordinate, finishCoordinate, peta);
                ojek.calculateTotalCostPerKm(0, distance);
                ojek.calculatePromoCost();
                ojek.calculateTotalCost();
                tripSummaryArea.setText("");
                tripSummaryArea.append(ojek.printTripText());
            }
            else if (serviceType.equals("Sporty")){
                int distance = OwjekService.shortestPath(startCoordinate, finishCoordinate, peta);
                ojek = new OwjekSporty(startCoordinate, finishCoordinate, peta);
                ojek.calculateTotalCostPerKm(0, distance);
                ojek.calculatePromoCost();
                ojek.calculateTotalCost();
                ojek.calculateProtectionCost();
                tripSummaryArea.setText("");
                tripSummaryArea.append(ojek.printTripText());
            }
            else if (serviceType.equals("Exclusive")){
                int distance = OwjekService.shortestPath(startCoordinate, finishCoordinate, peta);
                ojek = new OwjekExclusive(startCoordinate, finishCoordinate, peta);
                ojek.calculateTotalCostPerKm(0, distance);
                ojek.calculatePromoCost();
                ojek.calculateProtectionCost();
                ojek.calculateProtectionCost();
                tripSummaryArea.setText("");
                tripSummaryArea.append(ojek.printTripText());
            }

            mapGraphics = (Graphics2D) mapPanel.getGraphics();
            for (int i = 0; i < Map.HEIGHT; i++){
                for (int j = 0; j < peta.getMap()[i].length; j++){
                    if (peta.getMap()[i][j] == '#'){
                        mapGraphics.setColor(Color.black);
                        mapGraphics.fillRect(5+(j*8),5+(i*8),10,12);
                    }
                    else if (peta.getMap()[i][j] == '.'){
                        mapGraphics.setColor(Color.RED);
                        mapGraphics.fillRect(5+(j*8),5+(i*8),10,12);
                    }
                    else {
                        mapGraphics.setColor(Color.WHITE);
                        mapGraphics.fillRect(5+(j*8),5+(i*8),10,12);
                    }
                }
            }
            peta.resetMap();
            startField.setText("");
            finishField.setText("");
        }
        catch (Exception e){
            if (startCoordinate == null){
                JOptionPane.showMessageDialog(null, "Anda harus memasukkan koordinat awal.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (startCoordinate == null){
                JOptionPane.showMessageDialog(null, "Anda harus memasukkan koordinat tujuan.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (serviceType == null){
                JOptionPane.showMessageDialog(null, "Anda harus memilih jenis layanan OW-JEK.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void startFieldActionPerformed(java.awt.event.ActionEvent evt) {
        startCoordinate = startField.getText();
    }

    private void finishFieldActionPerformed(java.awt.event.ActionEvent evt) {
        finishCoordinate = finishField.getText();
    }

    private void serviceTypeSelectorActionPerformed(java.awt.event.ActionEvent evt) {
        serviceType = serviceTypeSelector.getSelectedItem().toString();
    }
}