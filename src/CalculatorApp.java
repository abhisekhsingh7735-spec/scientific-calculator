import javax.swing.SwingUtilities;

/**
 * Main entry point for the Scientific Calculator application
 */
public class CalculatorApp {
    
    public static void main(String[] args) {
        // Launch GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI();
        });
    }
}
