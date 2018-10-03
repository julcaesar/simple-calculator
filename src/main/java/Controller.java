import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private Label lbl_result;
    private long number1=0;
    private String operator= "";
    private boolean start= true;

    model model=new model();
    @FXML
    public void numbers(ActionEvent event){
        if (start){
            lbl_result.setText("");
            start=false;
        }

        String value=((Button)event.getSource()).getText();
        lbl_result.setText(lbl_result.getText()+value);
    }

    @FXML
    public void operator(ActionEvent event){

        String value=((Button)event.getSource()).getText();
        op(value);
    }

    public void op(String value){

        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(lbl_result.getText().toString());
            lbl_result.setText("");
        }else{
            if(operator.isEmpty())
                return;
            long number2 = Long.parseLong(lbl_result.getText());
            float output=model.calculate(number1,number2,operator);
            lbl_result.setText(String.valueOf(output));
            operator = "";
            start=true;
        }
    }

    @FXML
    public void keyboardPress(KeyEvent event) {
        if (start) {
            lbl_result.setText("");
            start = false;
        }

        String st = event.getText();
        System.out.println("ERROR " + st);
        try {
            if (st.equals("1") || st.equals("2")|| st.equals("3") ||
                st.equals("4") || st.equals("5")|| st.equals("6") || st.equals("7") ||
                st.equals("8") || st.equals("9")|| st.equals("0"))
                lbl_result.setText(lbl_result.getText() + st);

            if (st.equals("=") || st.equals("*") || st.equals("/") ||
                    st.equals("+") || st.equals("-") )
                op(st);


        }catch (Exception e){

        }
    }
}
