package org.gui;

import org.crud.CharacterCRUD;
import org.crud.StatCRUD;
import org.entities.Character;
import org.entities.Stat;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class CharacterNavigation extends JDialog {
    private JPanel contentPane;
    private JButton previousButton;
    private JButton exitButton;
    private JButton nextButton;
    private JPanel keyPanel;
    private JPanel namePanel;
    private JPanel housePanel;
    private JPanel birthPanel;
    private JPanel heightPanel;
    private JPanel weightPanel;
    private JPanel weaponPanel;
    private JLabel keyLabel;
    private JLabel nameLabel;
    private JLabel houseLabel;
    private JLabel birthLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel weaponLabel;
    private JPanel optionsPanel;
    private JPanel characterPanel;
    private JPanel statsPanel;
    private JLabel avgBeheadings;
    private JLabel avgGuttings;
    private JLabel avgMaimings;
    private JLabel avgRansoms;

    List<Character> characterList;
    Character currentCharacter;
    List<Stat> currentCharacterStatsList;
    int index;
    double totalBeheadings;
    double totalGuttings;
    double totalMaimings;
    double totalRansoms;


    public CharacterNavigation() {
        characterList = CharacterCRUD.getAllCharacters();
        index = 0;
        currentCharacter = characterList.get(index);
        currentCharacterStatsList = StatCRUD.getStatsByCharacterKey(currentCharacter.getCharacterKey());


        setListeners();

        setContentPane(contentPane);
        setModal(true);
        setVisible(true);
        getRootPane().setDefaultButton(null);
        updateLabels();
    }

    public void setListeners(){
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onNext();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPrevious();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onPrevious() {
        index--;
        currentCharacter=characterList.get(index);
        currentCharacterStatsList = StatCRUD.getStatsByCharacterKey(currentCharacter.getCharacterKey());
        updateLabels();
    }

    private void onNext(){
        index++;
        currentCharacter=characterList.get(index);
        currentCharacterStatsList = StatCRUD.getStatsByCharacterKey(currentCharacter.getCharacterKey());
        updateLabels();
    }

    private void onExit() {
        // add your code here if necessary
        dispose();
    }

    private void updateLabels(){
        keyLabel.setText("Character Key: "+currentCharacter.getCharacterKey());
        nameLabel.setText("Name: " + currentCharacter.getName());
        houseLabel.setText("House: " + currentCharacter.getHouse().getName());
        birthLabel.setText("Birthplace: " + currentCharacter.getBirthplace());
        heightLabel.setText("Height: " + currentCharacter.getHeight());
        weightLabel.setText("Weight: " + currentCharacter.getWeight());
        weaponLabel.setText("Weapon: " + currentCharacter.getWeapon());

        // Reset and Calculate average statistics
        totalBeheadings = 0.0;
        totalGuttings = 0.0;
        totalMaimings = 0.0;
        totalRansoms = 0.0;

        for (Stat stat : currentCharacterStatsList) {
            totalBeheadings += stat.getBeheadingsPerBout();
            totalGuttings += stat.getGuttingsPerBout();
            totalMaimings += stat.getMaimingsPerBout();
            totalRansoms += stat.getRansomsPerBout();
        }

        // Calculate averages
        double avgBeheadings = totalBeheadings / currentCharacterStatsList.size();
        double avgGuttings = totalGuttings / currentCharacterStatsList.size();
        double avgMaimings = totalMaimings / currentCharacterStatsList.size();
        double avgRansoms = totalRansoms / currentCharacterStatsList.size();

        // Update labels with averages
        this.avgBeheadings.setText("Average Beheadings: " + avgBeheadings);
        this.avgGuttings.setText("Average Guttings: " + avgGuttings);
        this.avgMaimings.setText("Average Maimings: " + avgMaimings);
        this.avgRansoms.setText("Average Ransoms: " + avgRansoms);
    }

}
