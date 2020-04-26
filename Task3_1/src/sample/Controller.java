package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Queue;


public class Controller {
    @FXML
    private TextField firstInputField;

    @FXML
    private TextField secondInputField;

    @FXML
    private Button btn;

    @FXML
    private Text outputText;

    public void initialize() {
        btn.setOnMouseClicked((event -> {
            String[] first = firstInputField.getText().split(" ");
            String[] second = secondInputField.getText().split(" ");
            MyQueue<Float> firstQueue = new MyQueue<>();
            MyQueue<Float> secondQueue = new MyQueue<>();

            for (String item : first) {
                firstQueue.add(Float.parseFloat(item));
            }
            for (String item : second) {
                secondQueue.add(Float.parseFloat(item));
            }

            try {
                Integer ans = solutionWithMyQueue(firstQueue, secondQueue);
                outputText.setText(ans.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    public int solutionWithMyQueue(MyQueue<Float> X, MyQueue<Float> Y) throws Exception {
        int ans = 0;

        while (!X.isEmpty() && !Y.isEmpty()) {
            float x = X.get();
            float y = Y.get();

            if (x < y) X.add(x + y);
            else Y.add(x - y);
            ans++;
        }

        return ans;
    }

    public int solutionWithStandardQueue(Queue<Float> X, Queue<Float> Y) throws Exception {
        int ans = 0;

        while (!X.isEmpty() && !Y.isEmpty()) {
            float x = X.poll();
            float y = Y.poll();

            if (x < y) X.add(x + y);
            else Y.add(x - y);
            ans++;
        }

        return ans;
    }
}
