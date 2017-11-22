package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Controller {

    @FXML
    private Text output;
    private Operator operator;
    private SingleOperator singleOperator;
    private String rh = "";
    private String lh = "";
    private boolean isJustCalculated = false;
    private static DecimalFormat df = new DecimalFormat("0.#######E0");

    @FXML
    private void processNumpad(ActionEvent event){

        if(isJustCalculated){
            lh="";
            isJustCalculated=false;
        }

        if( this.operator == null ){
            if(lh.length()>15)
                return;

                lh = lh.concat(((Button)event.getSource()).getText());
        }else if(!this.lh.equals("")){
            if(rh.length()>15)
                return;

                rh = rh.concat(((Button)event.getSource()).getText());
        }

        if(rh.equals("")) {
            output.setText(lh);
        }else{
            output.setText(rh);
        }
    }

    @FXML
    private void processOperator(ActionEvent event){

        String value=((Button)event.getSource()).getText();
        isJustCalculated=false;

        if( lh.equals("")) {
            lh="0";
        }

        if(!rh.equals("")){
            try {

                lh = show(this.operator.eval(new BigDecimal(lh), new BigDecimal(rh)));
                output.setText(lh);
            }catch (ArithmeticException e){
                System.out.println(e);
                lh="";
                rh="";
                operator=null;
                output.setText("MATH ERROR");
                return;
            }
            rh = "";
        }

        switch(value){
            case "+":
                this.operator = new Add();
                break;
            case "/":
                this.operator = new Divide();
                break;
            case "-":
                this.operator = new Subtract();
                break;
            case "*":
                this.operator = new Multiply();
                break;

        }
   }

    @FXML
    private void processSingleOperator(ActionEvent event) {
        String value=((Button)event.getSource()).getText();
        isJustCalculated=false;
        if( lh.equals("")) return;

        switch(value){
            case "x^2":
                singleOperator = new Exponentiate();
                break;
            case "√x":
                singleOperator = new RootExtraction();
                break;
        }

        if(!lh.equals("") && operator != null){
            if (!rh.equals("")) {
                try {
                    rh = show(singleOperator.eval(new BigDecimal(rh)));
                }catch (NumberFormatException e){
                    System.out.println(e);
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("MATH_ERROR");
                        //alert.setContentText("");
                        alert.setHeaderText("Error");
                        alert.showAndWait();
                }
                lh = "";
                operator = null;

                output.setText(rh);
                isJustCalculated =true;

            }
        }else{
            if (!lh.equals("")) {
                try {
                    lh = show(singleOperator.eval(new BigDecimal(lh)));
                }catch (NumberFormatException ex){
                    System.out.println(ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("MATH_ERROR");
                   // alert.setContentText("");
                    alert.setHeaderText("Error");
                    alert.showAndWait();
                }
                rh = "";
                operator = null;

                output.setText(lh);
                isJustCalculated =true;
            }
        }



    }


    @FXML
    private void processResult(ActionEvent event){

        if(!rh.equals("")){
            try {
                lh = show(this.operator.eval(new BigDecimal(lh), new BigDecimal(rh)));
            }catch (ArithmeticException e){
                System.out.println(e);
                lh="";
                rh="";
                operator=null;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("MATH_ERROR");
               // alert.setContentText("");
                alert.setHeaderText("Error");
                alert.showAndWait();
                output.setText("");
                return;
            }
            rh = "";
            operator = null;

            output.setText(lh);
            isJustCalculated =true;
        }
    }

    @FXML
    private void processClear(ActionEvent event){
        rh = "";
        operator = null;
        lh = "";
        output.setText("");
    }

    @FXML
    private void processComa(ActionEvent event){

        if( !lh.equals("") && operator != null ){
            if (rh.equals("")) {
                rh = "0.";
                output.setText(rh);
            }else{
                if(!rh.contains(".")) {
                    rh = rh.concat(".");
                    output.setText(rh);
                }
            }

        }else {
            if (lh.equals("")) {
                lh = "0.";
                output.setText(lh);
            }else{
                if(!lh.contains(".")) {
                    lh = lh.concat(".");
                    output.setText(lh);
                }
            }
        }
    }

    static String show(BigDecimal a){
        if (a.toString().length() > 15){
            return df.format(a).replace(",",".");
        }else{
            return a.toString();
        }
    }
}