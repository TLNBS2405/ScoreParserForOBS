import javax.swing.*;
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
            String name1 = readTextField(name_1);
            String score1 = readTextField(score_1);

            String name2 = readTextField(name_2);
            String score2 = readTextField(score_2);

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

    public static String readTextField(JTextField field) {
        try {
            return field.getText();

        } catch (NullPointerException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
