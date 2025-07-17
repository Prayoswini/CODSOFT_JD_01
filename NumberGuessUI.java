import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessUI extends JFrame {

    private static final int MAX_GUESSES = 10;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    private int randomNumber;
    private int guessCount;

    private JLabel messageLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JButton playAgainButton;

    public NumberGuessUI() {
        setTitle("Number Guessing Game");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Message Panel
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ":");
        messagePanel.add(messageLabel);
        add(messagePanel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        guessField = new JTextField();
        guessField.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                handleGuess();
            }
        });
        inputPanel.add(guessButton);

        // Play Again Panel
        JPanel playAgainPanel = new JPanel();
        playAgainButton = new JButton("Play Again");
        playAgainButton.setEnabled(false);
        playAgainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Play Again clicked!!");
                startNewGame();
            }
        });
        playAgainPanel.add(playAgainButton);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(playAgainPanel);
        add(centerPanel, BorderLayout.CENTER);

        startNewGame();
    }
      private void handleGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            guessCount++;

            if (userGuess == randomNumber) {
                messageLabel.setText("Correct! You guessed it in " + guessCount + " tries.");
                guessButton.setEnabled(false);
                playAgainButton.setEnabled(true);
            } else if (guessCount == MAX_GUESSES) {
                messageLabel.setText("Out of guesses! The number was " + randomNumber + ".");
                guessButton.setEnabled(false);
                playAgainButton.setEnabled(true);
            } else if (userGuess < randomNumber) {
                messageLabel.setText("Too low! Try again.");
            } else {
                messageLabel.setText("Too high! Try again.");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText(" Please enter a valid number.");
        }
      }
    


    private void startNewGame() {
        randomNumber = new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        guessCount = 0;
        messageLabel.setText("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ":");
        guessField.setText("");
        guessButton.setEnabled(true);
        playAgainButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumberGuessUI().setVisible(true);
        });
    }
 }
