package zeik.darksoulsequipmentcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class CalculatorSelectionScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator__selection__screen, menu);
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

    public void ArmorCalculatorClicked(View view)
    {
        Intent intent = new Intent(this,ArmorCalculator.class);
        startActivity(intent);
    }

    public void WeaponCalculatorClicked(View view)
    {
        Intent intent = new Intent(this,WeaponCalculator.class);
        startActivity(intent);
    }

    public void CompleteCalculatorClicked(View view)
    {
        Intent intent = new Intent(this,CompleteCalculator.class);
        startActivity(intent);
    }

    public void ShieldComparisonClicked(View view)
    {
        Intent intent = new Intent(this,ShieldComparison.class);
        startActivity(intent);
    }

}
