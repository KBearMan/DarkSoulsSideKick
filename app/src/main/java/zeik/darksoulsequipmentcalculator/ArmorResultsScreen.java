package zeik.darksoulsequipmentcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ArmorResultsScreen extends ActionBarActivity
{

    ArrayList<String> weightList;
    float weaponWeight;
    Character.weightClass weightClass;

    Character player;

    ArrayList<Armor> helmetList;
    ArrayList<Armor> chestList;
    ArrayList<Armor> handList;
    ArrayList<Armor> legList;

    ListView armorResultList;

    ListAdapter armorResultListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_armor_result_screen);

        Intent intent = getIntent();

        weaponWeight = intent.getFloatExtra("WeaponWeight",0);

        weightList = intent.getExtras().getStringArrayList("ArmorPriorityList");

        String weightString = intent.getStringExtra("WeightClass");

        if(weightString.contains("Light"))
        {
            weightClass = Character.weightClass.LightWeight;
        }
        else if(weightString.contains("Heavy"))
        {
            weightClass = Character.weightClass.HeavyWeight;
        }
        else
        {
            weightClass = Character.weightClass.MiddleWeight;
        }

        armorResultList = (ListView)findViewById(R.id.armor_result_list);

        helmetList = new ArrayList<Armor>();
        chestList = new ArrayList<Armor>();
        handList = new ArrayList<Armor>();
        legList = new ArrayList<Armor>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_armor_results_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void calculateArmorWeight()
    {
        for(Armor helmet: helmetList)
        {

            for(Armor chest: chestList)
            {

                for(Armor gauntlet: handList)
                {

                    for(Armor leg:legList)
                    {
                        if(leg.Weight+gauntlet.Weight+chest.Weight+helmet.Weight > )
                        {

                        }


                    }

                }

            }

        }

    }

    public void onChangePrioritiesClicked(View v)
    {

    }


}
