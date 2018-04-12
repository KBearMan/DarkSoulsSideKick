package zeik.darksoulsequipmentcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ClickContinue(View view)
    {
        Intent intent = new Intent(this, CalculatorSelectionScreen.class);
        startActivity(intent);
    }

    public void PlusClick(View view)
    {
        int newValue;
        switch (view.getId())
        {
            case R.id.attplusbtn:
                EditText attText = (EditText)findViewById(R.id.attunementtext);
                newValue = (Integer.parseInt((attText.getText().toString())));
                newValue++;
                attText.setText(String.valueOf(newValue));
                break;

            case R.id.dexplusbtn:
                EditText dexText = (EditText)findViewById(R.id.dexteritytext);
                newValue = (Integer.parseInt((dexText.getText().toString())));
                newValue++;
                dexText.setText(String.valueOf(newValue));
                break;

            case R.id.endplusbtn:
                EditText endText = (EditText)findViewById(R.id.endurancetext);
                newValue = (Integer.parseInt((endText.getText().toString())));
                newValue++;
                endText.setText(String.valueOf(newValue));
                break;

            case R.id.faithplusbtn:
                EditText faithText = (EditText)findViewById(R.id.faithtext);
                newValue = (Integer.parseInt((faithText.getText().toString())));
                newValue++;
                faithText.setText(String.valueOf(newValue));
                break;

            case R.id.humplusbtn:
                EditText humText = (EditText)findViewById(R.id.humanitytext);
                newValue = (Integer.parseInt((humText.getText().toString())));
                newValue++;
                humText.setText(String.valueOf(newValue));
                break;
            case R.id.intplusbtn:
                EditText intText = (EditText)findViewById(R.id.intelligencetext);
                newValue = (Integer.parseInt((intText.getText().toString())));
                newValue++;
                intText.setText(String.valueOf(newValue));
                break;

            case R.id.resplusbtn:
                EditText resText = (EditText)findViewById(R.id.resistancetext);
                newValue = (Integer.parseInt((resText.getText().toString())));
                newValue++;
                resText.setText(String.valueOf(newValue));
                break;

            case R.id.strplusbtn:
                EditText strText = (EditText)findViewById(R.id.strengthtext);
                newValue = (Integer.parseInt((strText.getText().toString())));
                newValue++;
                strText.setText(String.valueOf(newValue));
                break;

            case R.id.vitplusbtn:
                EditText vitText = (EditText)findViewById(R.id.vitalitytext);
                String herp = vitText.getText().toString();
                newValue = Integer.valueOf(herp);
                newValue++;
                vitText.setText(String.valueOf(newValue));
                break;

        }
    }

    public void MinusClick(View view)
    {
        int newValue;
        switch (view.getId())
        {
            case R.id.attminbtn:
                EditText attText = (EditText)findViewById(R.id.attunementtext);
                newValue = (Integer.parseInt((attText.getText().toString())));
                newValue--;
                attText.setText(String.valueOf(newValue));
                break;

            case R.id.dexminbtn:
                EditText dexText = (EditText)findViewById(R.id.dexteritytext);
                newValue = (Integer.parseInt((dexText.getText().toString())));
                newValue--;
                dexText.setText(String.valueOf(newValue));
                break;

            case R.id.endminbtn:
                EditText endText = (EditText)findViewById(R.id.endurancetext);
                newValue = (Integer.parseInt((endText.getText().toString())));
                newValue--;
                endText.setText(String.valueOf(newValue));
                break;

            case R.id.faithminbtn:
                EditText faithText = (EditText)findViewById(R.id.faithtext);
                newValue = (Integer.parseInt((faithText.getText().toString())));
                newValue--;
                faithText.setText(String.valueOf(newValue));
                break;

            case R.id.humminbtn:
                EditText humText = (EditText)findViewById(R.id.humanitytext);
                newValue = (Integer.parseInt((humText.getText().toString())));
                newValue--;
                humText.setText(String.valueOf(newValue));
                break;
            case R.id.intminbtn:
                EditText intText = (EditText)findViewById(R.id.intelligencetext);
                newValue = (Integer.parseInt((intText.getText().toString())));
                newValue--;
                intText.setText(String.valueOf(newValue));
                break;

            case R.id.resminbtn:
                EditText resText = (EditText)findViewById(R.id.resistancetext);
                newValue = (Integer.parseInt((resText.getText().toString())));
                newValue--;
                resText.setText(String.valueOf(newValue));
                break;

            case R.id.strminbtn:
                EditText strText = (EditText)findViewById(R.id.strengthtext);
                newValue = (Integer.parseInt((strText.getText().toString())));
                newValue--;
                strText.setText(String.valueOf(newValue));
                break;

            case R.id.vitplusbtn:
                EditText vitText = (EditText)findViewById(R.id.vitalitytext);
                newValue = (Integer.parseInt((vitText.getText().toString())));
                newValue--;
                vitText.setText(String.valueOf(newValue));
                break;

        }
    }
}
