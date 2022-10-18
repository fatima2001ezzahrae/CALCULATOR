package ma.ensaf.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView sol,result;
    MaterialButton bt1,bt2,bt3,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14
            ,bt15,bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23,bt24;
    ImageButton bt4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= (MaterialButton) findViewById(R.id.bt1);
        bt2= (MaterialButton) findViewById(R.id.bt2);
        bt4= (ImageButton) findViewById(R.id.bt4);
        bt5= (MaterialButton) findViewById(R.id.bt5);
        bt6= (MaterialButton) findViewById(R.id.bt6);
        bt7= (MaterialButton) findViewById(R.id.bt7);
        bt8= (MaterialButton) findViewById(R.id.bt8);
        bt9= (MaterialButton) findViewById(R.id.bt9);
        bt10= (MaterialButton) findViewById(R.id.bt10);
        bt11= (MaterialButton) findViewById(R.id.bt11);
        bt12= (MaterialButton) findViewById(R.id.bt12);
        bt13= (MaterialButton) findViewById(R.id.bt13);
        bt14= (MaterialButton) findViewById(R.id.bt14);
        bt15= (MaterialButton) findViewById(R.id.bt15);
        bt16= (MaterialButton) findViewById(R.id.bt16);
        bt17= (MaterialButton) findViewById(R.id.bt17);
        bt18= (MaterialButton) findViewById(R.id.bt18);
        bt19= (MaterialButton) findViewById(R.id.bt19);
        bt20= (MaterialButton) findViewById(R.id.bt20);
        bt21= (MaterialButton) findViewById(R.id.bt21);
        bt22= (MaterialButton) findViewById(R.id.bt22);
        bt23= (MaterialButton) findViewById(R.id.bt23);
        bt24= (MaterialButton) findViewById(R.id.bt24);

        result=(TextView)findViewById(R.id.result_tv);
        sol=(TextView)findViewById(R.id.solution_tv);

        bt3= (MaterialButton) findViewById(R.id.bt3);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText=button.getText().toString();
        //sol.setText(buttonText);
        result.setText(buttonText);
        String calculate=sol.getText().toString();

        if(buttonText.equals("AC")){
            sol.setText("");
            result.setText("0");
            return;
        }
        else if(buttonText.equals("=")){
            sol.setText(result.getText());
            return;
        }
        else if(buttonText.equals("C")){
            calculate=calculate.substring(0,calculate.length()-1);
        }
        else {
            calculate += buttonText;
        }
        sol.setText(calculate);
        String finalResult=getResultat(calculate);
        if(!finalResult.equals("error")){
            result.setText(finalResult);
        }
    }
    String getResultat(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable =context.initStandardObjects();
            String endresult=context.evaluateString(scriptable,data
                    ,"Javascript",1,null).toString();
            if(endresult.endsWith(".0"))
                endresult=endresult.replace(".0","");
            return endresult;
        }
        catch(Exception e) {
            return "error";
        }
    }
}