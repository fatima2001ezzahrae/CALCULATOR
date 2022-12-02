package ma.ensaf.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mariuszgromada.math.mxparser.*;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity  {
    @SuppressLint("MissingInflatedId")

    private TextView sol;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sol = findViewById(R.id.solution_tv);
        result = findViewById(R.id.result_tv);

        result.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = result.getText().toString();
        int cursorPos = result.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        result.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        result.setSelection(cursorPos + strToAdd.length());
    }

    public void zero(View view){
        updateText(getResources().getString(R.string.zero));
    }

    public void one(View view){
        updateText(getResources().getString(R.string.one));
    }

    public void two(View view){
        updateText(getResources().getString(R.string.two));
    }

    public void three(View view){
        updateText(getResources().getString(R.string.three));
    }

    public void four(View view){
        updateText(getResources().getString(R.string.four));
    }

    public void five(View view){
        updateText(getResources().getString(R.string.five));
    }

    public void six(View view){
        updateText(getResources().getString(R.string.six));
    }

    public void seven(View view){
        updateText(getResources().getString(R.string.seven));
    }

    public void eight(View view){
        updateText(getResources().getString(R.string.eight));
    }

    public void nine(View view){
        updateText(getResources().getString(R.string.nine));
    }

    public void multiply(View view){
        updateText(getResources().getString(R.string.multiply));
    }

    public void divide(View view){
        updateText(getResources().getString(R.string.divide));
    }

    public void subtract(View view){
        updateText(getResources().getString(R.string.subtract));
    }

    public void add(View view){
        updateText(getResources().getString(R.string.add));
    }

    public void clearall(View view){
       result.setText("");
       sol.setText("");
    }
    
    public void decimal(View view){
        updateText(getResources().getString(R.string.decimal));
    }

    public void equal(View view){
        String userExp = result.getText().toString();

        sol.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

        Expression exp = new Expression(userExp);
        String resultat = String.valueOf(exp.calculate());

        result.setText(resultat);
        result.setSelection(result.length());
    }

    public void backspace(View view){
        int cursorPos = result.getSelectionStart();
        int textLen = result.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) result.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            result.setText(selection);
            result.setSelection(cursorPos-1);
        }
    }

    public void sqrt(View view){
        updateText("sqrt(");
    }
    public void xSquared(View view){
        updateText("^(2)");
    }
    public void oposite(View view){
        updateText(getResources().getString(R.string.multiply)+"(-1)");
    }
    public void inverte(View view){
        updateText("^(-1)");
    }
    public void open(View view){
        updateText(getResources().getString(R.string.parenthesesOpen));
    }
    public void close(View view){
        updateText(getResources().getString(R.string.parenthesesClose));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_calculator1:
                Toast.makeText(this, "scientific selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_calculator2:
                Toast.makeText(this, "settings selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}