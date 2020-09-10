import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JTextField name_1;
    private JTextField score_1;
    private JTextField name_2;
    private JTextField score_2;
    private JButton Update;

    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        Update.addActionListener(e -> {
            String name1 = name_1.getText();
            String score1 = score_1.getText();

            String name2 = name_2.getText();
            String score2 = score_2.getText();

            try {
                createFileIfNotExist("name1.txt", name1);
                createFileIfNotExist("name2.txt", name2);
                createFileIfNotExist("score1.txt", score1);
                createFileIfNotExist("score2.txt", score2);

                JOptionPane.showMessageDialog(null, "Done", "Success", JOptionPane.PLAIN_MESSAGE);


            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
    }

    public static void createFileIfNotExist(String filePath, String content) throws IOException {
        File yourFile = new File(filePath);
        FileOutputStream oFile = new FileOutputStream(yourFile, false);
        oFile.write(content.getBytes());
    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
