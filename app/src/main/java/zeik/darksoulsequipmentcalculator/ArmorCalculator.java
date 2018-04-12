package zeik.darksoulsequipmentcalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.widget.AdapterView.OnItemClickListener;


public class ArmorCalculator extends ActionBarActivity {

    ListView priorityListView;

    ArrayList<String> priorityList;

    public int selectedPosition;

    ArrayAdapter<String> priorityListAdapter;

    TextView weightlistView;

    ArrayList<String> weightList;

    EditText weaponWeightText;

    OnItemClickListener priorityListClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                View lilV = parent.getChildAt(i);
                changeRowAppearance(false, lilV);
            }

            changeRowAppearance(true, view);

            selectedPosition = position;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.armor_calc_screen);
        priorityListView = (ListView) findViewById(R.id.prioritylist);
        CreatePriorityList();
        priorityListView.setOnItemClickListener(priorityListClickListener);
        weaponWeightText = (EditText) findViewById(R.id.weaponweighttext);
        weightlistView = (TextView) findViewById(R.id.weightclasslist);

    }

    public void CreatePriorityList() {
        priorityList = new ArrayList<String>() {
        };
        priorityList.add(getString(R.string.normal_defense));
        priorityList.add(getString(R.string.slashing_defense));
        priorityList.add(getString(R.string.striking_defense));
        priorityList.add(getString(R.string.thrusting_defense));
        priorityList.add(getString(R.string.magical_defense));
        priorityList.add(getString(R.string.fire_defense));
        priorityList.add(getString(R.string.lightning_defense));
        priorityList.add(getString(R.string.poise));
        priorityList.add(getString(R.string.bleed_resistance));
        priorityList.add(getString(R.string.curse_resistance));
        priorityList.add(getString(R.string.poison_resistance));
        priorityListAdapter = new PriorityAdapter(this, R.layout.priority_list_row, priorityList);
        priorityListView.setAdapter(priorityListAdapter);
    }

    public void selectWeightClass(View v) {

        weightList = new ArrayList<String>(){};
        String[] dialogList = new String[3];

        weightList.add(getString(R.string.light_weight_load) + " <= 25% Max Load");
        dialogList[0] = getString(R.string.light_weight_load) + " <= 25% Max Load";

        weightList.add(getString(R.string.medium_weight_load) + " <= 50% Max Load");
        dialogList[1] = getString(R.string.medium_weight_load) + " <= 50% Max Load";

        weightList.add(getString(R.string.heavy_weight_load) + " > 50% Max Load");
        dialogList[2] = getString(R.string.heavy_weight_load)+ " > 50% Max Load";


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.weight).setItems(dialogList,new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        weightlistView.setText(weightList.get(which));

                    }

                });

        builder.create();

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_armor_calculator, menu);
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

    public void ArrowButtonClicked(View view) {

        String listString = priorityList.get(selectedPosition);

        int newPosition = selectedPosition;

        switch (view.getId()) {

            case R.id.priorityrpwupbutton:

                if (selectedPosition != 0) {
                    newPosition--;
                    String newPositionString = priorityList.get(newPosition);
                    priorityList.set(newPosition, listString);
                    priorityList.set(selectedPosition, newPositionString);
                }
                break;

            case R.id.priorityrowdownbutton:

                if (selectedPosition != (priorityList.size() - 1)) {

                    newPosition++;
                    String newPositionString = priorityList.get(newPosition);
                    priorityList.set(newPosition, listString);
                    priorityList.set(selectedPosition, newPositionString);

                }
                break;

            default:

        }

        selectedPosition = newPosition;
        priorityListAdapter.notifyDataSetChanged();

    }

    private void changeRowAppearance(boolean bSelected, View view)
    {

        if (bSelected)
        {

            view.setBackgroundColor(Color.WHITE);
            Button viewBtn = (Button) view.findViewById(R.id.priorityrpwupbutton);
            viewBtn.setClickable(true);
            viewBtn.setVisibility(View.VISIBLE);
            viewBtn = (Button) view.findViewById(R.id.priorityrowdownbutton);
            viewBtn.setClickable(true);
            viewBtn.setVisibility(View.VISIBLE);

        }
        else
        {

            view.setBackgroundColor(Color.TRANSPARENT);
            Button viewBtn = (Button) view.findViewById(R.id.priorityrpwupbutton);
            viewBtn.setClickable(false);
            viewBtn.setVisibility(View.INVISIBLE);
            viewBtn = (Button) view.findViewById(R.id.priorityrowdownbutton);
            viewBtn.setClickable(false);
            viewBtn.setVisibility(View.INVISIBLE);

        }

    }

    public void onContinueClick(View v)
    {

        Intent intent = new Intent(this,ArmorResultsScreen.class);
        intent.putExtra("ArmorPriorityList",priorityList);
        intent.putExtra("WeaponWeight", Float.parseFloat(weaponWeightText.getText().toString()));
        intent.putExtra("WeightClass",weightlistView.getText().toString());
        startActivity(intent);


    }

    public class PriorityAdapter extends ArrayAdapter<String>
    {
        Context context;
        int layoutResourceId;
        public ArrayList<String> data = null;


        public void resetList(ArrayList<String> iList) {
            data = iList;
        }


        public PriorityAdapter(Context context, int layoutResourceId, ArrayList<String> data)
        {

            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RowItemHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new RowItemHolder();
                holder.imgIcon = (ImageView) row.findViewById(R.id.priorityrowitemicon);
                holder.txtTitle = (TextView) row.findViewById(R.id.priorityrowitemtext);

                row.setTag(holder);
            } else {
                holder = (RowItemHolder) row.getTag();
            }

            if (position == selectedPosition) {
                changeRowAppearance(true, row);
            } else {
                changeRowAppearance(false, row);
            }

            String rowItem = data.get(position);
            holder.txtTitle.setText(rowItem);
            if (rowItem.equals(getString(R.string.normal_defense))) {
                holder.imgIcon.setImageResource(R.drawable.physicaldefense);
            } else if (rowItem.equals(getString(R.string.lightning_defense))) {
                holder.imgIcon.setImageResource(R.drawable.lightningdefense);
            } else if (rowItem.equals(getString(R.string.fire_defense))) {
                holder.imgIcon.setImageResource(R.drawable.firedefense);
            } else if (rowItem.equals(getString(R.string.magical_defense))) {
                holder.imgIcon.setImageResource(R.drawable.magicdefense);
            } else if (rowItem.equals(getString(R.string.poise))) {
                holder.imgIcon.setImageResource(R.drawable.poise);
            } else if (rowItem.equals(getString(R.string.poison_resistance))) {
                holder.imgIcon.setImageResource(R.drawable.poison);
            } else if (rowItem.equals(getString(R.string.curse_resistance))) {
                holder.imgIcon.setImageResource(R.drawable.curse);
            } else if (rowItem.equals(getString(R.string.bleed_resistance))) {
                holder.imgIcon.setImageResource(R.drawable.bleed);
            } else if (rowItem.equals(getString(R.string.slashing_defense))) {
                holder.imgIcon.setImageResource(R.drawable.slashdefense);
            } else if (rowItem.equals(getString(R.string.striking_defense))) {
                holder.imgIcon.setImageResource(R.drawable.strikedefense);
            } else {
                holder.imgIcon.setImageResource(R.drawable.thrustdefense);
            }


            return row;
        }

        class RowItemHolder {
            ImageView imgIcon;
            TextView txtTitle;
        }


    }
}

